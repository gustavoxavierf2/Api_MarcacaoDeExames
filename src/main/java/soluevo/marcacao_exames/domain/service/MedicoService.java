package soluevo.marcacao_exames.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soluevo.marcacao_exames.api.Mapper.MedicoMapper;
import soluevo.marcacao_exames.api.requests.MedicoRequest;
import soluevo.marcacao_exames.api.response.MedicoResponse;
import soluevo.marcacao_exames.domain.models.Medico;
import soluevo.marcacao_exames.domain.repository.MedicoRepo;

@Service
public class MedicoService {
    @Autowired
    MedicoRepo medicoRepo;

    @Autowired
    MedicoMapper medicoMapper;

    public MedicoResponse getMedico(Long request){
        Medico medico =  medicoRepo.findById(request).get();
        System.out.println("aaaa"+medico);
        
        return medicoMapper.medicoToMedicoResponse(medico);
    }

    public Medico createMedico(MedicoRequest request) {
        Medico response = medicoMapper.toMedico(request);

        return medicoRepo.save(response);
    }
}
