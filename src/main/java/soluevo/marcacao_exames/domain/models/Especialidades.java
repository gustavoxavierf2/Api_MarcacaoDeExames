package soluevo.marcacao_exames.domain.models;

import java.util.HashSet;
import java.util.Set;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_ESPECIALIDADES")
public class Especialidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String especialidade;
    @Column(nullable = false)
    @ManyToMany(mappedBy = "FK_Especialidades", fetch = FetchType.EAGER)
    private Set<Medico> FK_Medicos = new HashSet<>();
}
