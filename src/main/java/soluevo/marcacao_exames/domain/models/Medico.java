package soluevo.marcacao_exames.domain.models;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_MEDICO")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_medico_especialidade",
        joinColumns = @JoinColumn(name = "medico_id"),
        inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
    private Set<Especialidades> FK_Especialidades = new HashSet<>();
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String crm;
    @OneToMany(mappedBy = "FK_MedicoId", fetch = FetchType.EAGER)
    private Set<ConsultaMarcada> consultaMarcada = new HashSet<>();
}
