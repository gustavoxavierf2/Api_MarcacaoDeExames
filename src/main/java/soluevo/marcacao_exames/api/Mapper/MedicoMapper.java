package soluevo.marcacao_exames.api.Mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import soluevo.marcacao_exames.api.requests.MedicoRequest;
import soluevo.marcacao_exames.api.response.MedicoResponse;
import soluevo.marcacao_exames.domain.models.Especialidades;
import soluevo.marcacao_exames.domain.models.Medico;
import soluevo.marcacao_exames.domain.service.EspecialidadesService;

@Component
public class MedicoMapper {
    @Autowired
    EspecialidadesService especialidadesService;

    public Medico toMedico(MedicoRequest request){
        Set<Especialidades> especialidades = new HashSet<>();
        for (Long e : request.getEspecialidades()) {
            especialidades.add(especialidadesService.getEspecialidades(e).get());
        }
        Medico medico = new Medico();
        medico.setNome(request.getNome());
        medico.setCrm(request.getCrm());
        medico.setFk_especialidades(especialidades);

        return medico;
    }

    public MedicoResponse medicoToMedicoResponse(Medico request){

        MedicoResponse response = new MedicoResponse();
        response.setNome(request.getNome());
        response.setCrm(request.getCrm());
        response.setEspecialidades(request.getFk_especialidades());
        return response;
    }
}
