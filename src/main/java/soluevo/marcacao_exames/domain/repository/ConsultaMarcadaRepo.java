package soluevo.marcacao_exames.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import soluevo.marcacao_exames.domain.models.ConsultaMarcada;

public interface ConsultaMarcadaRepo extends JpaRepository<ConsultaMarcada, Long>{
    
}
