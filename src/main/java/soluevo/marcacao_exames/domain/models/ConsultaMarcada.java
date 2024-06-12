package soluevo.marcacao_exames.domain.models;


import jakarta.persistence.Entity;
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
public class ConsultaMarcada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pacienteId")
    private Paciente FK_PacienteId;
    @ManyToOne
    @JoinColumn(name = "medicoId")
    private Medico FK_MedicoId;
    
}
