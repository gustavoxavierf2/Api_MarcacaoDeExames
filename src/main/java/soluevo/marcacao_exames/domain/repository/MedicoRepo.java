package soluevo.marcacao_exames.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import soluevo.marcacao_exames.domain.models.Medico;

public interface MedicoRepo extends JpaRepository<Medico, Long>{
    
}
