package soluevo.marcacao_exames.domain.models;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_CONSULTA_MARCADA")
public class ConsultaMarcada implements Serializable{
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pacienteId")
    private Paciente FK_PacienteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicoId")
    private Medico FK_MedicoId;
    
}
