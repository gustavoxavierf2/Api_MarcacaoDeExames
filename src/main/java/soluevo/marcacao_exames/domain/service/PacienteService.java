package soluevo.marcacao_exames.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soluevo.marcacao_exames.domain.models.Paciente;
import soluevo.marcacao_exames.domain.repository.PacienteRepo;

@Service
public class PacienteService {
    @Autowired
    PacienteRepo pacienteRepo;

    public Optional<Paciente> getPaciente(Long request){
        Optional<Paciente> response =  pacienteRepo.findById(request);
        return response;
    }

    public Paciente createPaciente(Paciente request){
        return pacienteRepo.save(request);
    }
}
