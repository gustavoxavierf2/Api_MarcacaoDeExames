package soluevo.marcacao_exames.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soluevo.marcacao_exames.domain.models.Especialidades;
import soluevo.marcacao_exames.domain.repository.EspecialidadesRepo;

@Service
public class EspecialidadesService {
    @Autowired
    EspecialidadesRepo especialidadesRepo;

    public Optional<Especialidades> getEspecialidades(Long request){
        Optional<Especialidades> response =  especialidadesRepo.findById(request);
        return response;
    }

    public Especialidades createEspecialidades(Especialidades request){
        return especialidadesRepo.save(request);
    }
}
