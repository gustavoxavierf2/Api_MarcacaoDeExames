package soluevo.marcacao_exames.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soluevo.marcacao_exames.domain.models.Paciente;
import soluevo.marcacao_exames.domain.service.PacienteService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/soluevo/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> getPaciente(@PathVariable("id") Long id) {
        Optional<Paciente> response = pacienteService.getPaciente(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente request) {
        Paciente response = pacienteService.createPaciente(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
}
