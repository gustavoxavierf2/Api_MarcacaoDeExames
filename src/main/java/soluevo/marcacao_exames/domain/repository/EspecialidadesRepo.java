package soluevo.marcacao_exames.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import soluevo.marcacao_exames.domain.models.Especialidades;

public interface EspecialidadesRepo extends JpaRepository<Especialidades, Long>{
    
}
