package soluevo.marcacao_exames.api.response;

import java.util.Set;

import lombok.Data;
import soluevo.marcacao_exames.domain.models.Especialidades;

@Data
public class MedicoResponse {
    private String nome;
    private String crm;
    private Set<Especialidades> especialidades;
}
