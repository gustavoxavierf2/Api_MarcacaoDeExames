package soluevo.marcacao_exames.domain.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "TB_PACIENTE")
public class Paciente implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate dataNascimento;
    @Column(nullable = false, unique = true)
    private String cpf;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "FK_PacienteId",  fetch = FetchType.LAZY)
    //@JsonIgnore
    private Set<ConsultaMarcada> consultasMarcadas = new HashSet<>();

}
