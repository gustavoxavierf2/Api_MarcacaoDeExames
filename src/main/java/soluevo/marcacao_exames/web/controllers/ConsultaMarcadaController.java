package soluevo.marcacao_exames.web.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soluevo.marcacao_exames.api.requests.ConsultaMarcadaRequest;
import soluevo.marcacao_exames.domain.models.ConsultaMarcada;
import soluevo.marcacao_exames.domain.service.ConsultaMarcadaService;

@RestController
@RequestMapping("/soluevo/consulta_marcada")
public class ConsultaMarcadaController {
    @Autowired
    ConsultaMarcadaService consultaMarcada;
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ConsultaMarcada>> getConsultaMarcada(@PathVariable("id") Long id) {
        Optional<ConsultaMarcada> response = consultaMarcada.getConsultaMarcada(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    

    @PostMapping
    public ResponseEntity<ConsultaMarcada> createConsultaMarcada(@RequestBody ConsultaMarcadaRequest request) {
        ConsultaMarcada response = consultaMarcada.createConsultaMarcada(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
