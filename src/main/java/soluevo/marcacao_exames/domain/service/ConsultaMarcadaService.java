package soluevo.marcacao_exames.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soluevo.marcacao_exames.api.requests.ConsultaMarcadaRequest;
import soluevo.marcacao_exames.domain.models.ConsultaMarcada;
import soluevo.marcacao_exames.domain.repository.ConsultaMarcadaRepo;
import soluevo.marcacao_exames.domain.repository.MedicoRepo;
import soluevo.marcacao_exames.domain.repository.PacienteRepo;

@Service
public class ConsultaMarcadaService {
    @Autowired
    ConsultaMarcadaRepo consultaMarcadaRepo;

    @Autowired
    PacienteRepo pacienteRepo;

    @Autowired
    MedicoRepo medicoRepo;

    public Optional<ConsultaMarcada> getConsultaMarcada(Long request){
        Optional<ConsultaMarcada> response =  consultaMarcadaRepo.findById(request);
        return response;
    }

    public ConsultaMarcada createConsultaMarcada(ConsultaMarcadaRequest request){
        ConsultaMarcada response = new ConsultaMarcada();
        response.setFK_PacienteId(pacienteRepo.findById(request.pacienteId()).get());
        response.setFK_MedicoId(medicoRepo.findById(request.medicoId()).get());
        return consultaMarcadaRepo.save(response);
    }
}
