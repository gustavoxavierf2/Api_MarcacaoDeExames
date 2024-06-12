package soluevo.marcacao_exames.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import soluevo.marcacao_exames.domain.models.Paciente;

public interface PacienteRepo extends JpaRepository<Paciente, Long>{
    
}
