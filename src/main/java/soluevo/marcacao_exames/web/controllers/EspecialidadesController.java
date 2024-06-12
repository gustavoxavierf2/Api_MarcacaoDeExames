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

import soluevo.marcacao_exames.domain.models.Especialidades;
import soluevo.marcacao_exames.domain.service.EspecialidadesService;

@RestController
@RequestMapping("/soluevo/especialidades")
public class EspecialidadesController {
    @Autowired
    EspecialidadesService especialidadesService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Especialidades>> getEspecialidades(@PathVariable("id") Long id) {
        Optional<Especialidades> response = especialidadesService.getEspecialidades(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    

    @PostMapping
    public ResponseEntity<Especialidades> createEspecialidades(@RequestBody Especialidades request) {
        Especialidades response = especialidadesService.createEspecialidades(request);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
