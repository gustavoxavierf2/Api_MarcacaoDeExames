package soluevo.marcacao_exames.api.requests;

import java.util.Set;

import lombok.Data;

@Data
public class MedicoRequest {
    private String nome;
    private String crm;
    private Set<Long> especialidades;
}

