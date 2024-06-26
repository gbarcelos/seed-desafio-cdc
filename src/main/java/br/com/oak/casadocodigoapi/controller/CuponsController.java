package br.com.oak.casadocodigoapi.controller;

import br.com.oak.casadocodigoapi.controller.request.CriarCupomRequest;
import br.com.oak.casadocodigoapi.model.Cupom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cupons")
public class CuponsController {

  @PersistenceContext
  private EntityManager entityManager;

  @PostMapping
  @Transactional
  public ResponseEntity<Object> criarCupom(
      @RequestBody @Valid CriarCupomRequest criarCupomRequest) {
    Cupom cupom = criarCupomRequest.toModel();
    entityManager.persist(cupom);
    return ResponseEntity.ok(cupom.toString());
  }
}
