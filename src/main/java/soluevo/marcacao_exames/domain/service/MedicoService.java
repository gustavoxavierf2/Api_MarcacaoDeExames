package soluevo.marcacao_exames.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soluevo.marcacao_exames.domain.models.Medico;
import soluevo.marcacao_exames.domain.repository.MedicoRepo;

@Service
public class MedicoService {
    @Autowired
    MedicoRepo medicoRepo;

    public Optional<Medico> getMedico(Long request){
        Optional<Medico> response =  medicoRepo.findById(request);
        return response;
    }

    public Medico createMedico(Medico request){
        return medicoRepo.save(request);
    }
}
