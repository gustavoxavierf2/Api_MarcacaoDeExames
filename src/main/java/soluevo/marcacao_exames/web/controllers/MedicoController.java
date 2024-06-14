package soluevo.marcacao_exames.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soluevo.marcacao_exames.api.requests.MedicoRequest;
import soluevo.marcacao_exames.api.response.MedicoResponse;
import soluevo.marcacao_exames.domain.models.Medico;
import soluevo.marcacao_exames.domain.service.MedicoService;

@RestController
@RequestMapping("/soluevo/medico")
public class MedicoController {
    @Autowired
    MedicoService medicoService;
    
    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponse> getMedico(@PathVariable("id") Long id) {
        MedicoResponse response = medicoService.getMedico(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    

    @PostMapping
    public ResponseEntity<Medico> createMedico(@RequestBody MedicoRequest request) {
        Medico response = medicoService.createMedico(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
