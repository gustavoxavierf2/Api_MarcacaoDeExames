package soluevo.marcacao_exames.domain.service;

import java.util.HashSet;
import java.util.Optional;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soluevo.marcacao_exames.api.requests.MedicoRequest;
import soluevo.marcacao_exames.domain.models.Especialidades;
import soluevo.marcacao_exames.domain.models.Medico;
import soluevo.marcacao_exames.domain.repository.EspecialidadesRepo;
import soluevo.marcacao_exames.domain.repository.MedicoRepo;

@Service
public class MedicoService {
    @Autowired
    MedicoRepo medicoRepo;

    @Autowired
    EspecialidadesService especialidadesService;

    public Optional<Medico> getMedico(Long request){
        Optional<Medico> response =  medicoRepo.findById(request);
        return response;
    }

    public Medico createMedico(MedicoRequest request) {
        System.out.println("llll"+request);
        System.out.println("qqqqqq0"+request.getEspecialidades());
        // Carrega as especialidades completas com base nos IDs fornecidos
        Set<Especialidades> especialidades = new HashSet<>();
        for (Long especialidade : request.getEspecialidades()) {
            especialidades.add(especialidadesService.getEspecialidades(especialidade).get());
        }
        System.out.println(especialidades);
        Medico medico = new Medico();
        medico.setNome(request.getNome());
        medico.setCrm(request.getCrm());
        medico.setFK_Especialidades(especialidades);

        return medicoRepo.save(medico);
    }
}
