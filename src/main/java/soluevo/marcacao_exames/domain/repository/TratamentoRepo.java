package soluevo.marcacao_exames.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import soluevo.marcacao_exames.domain.models.Tratamento;

public interface TratamentoRepo extends JpaRepository<Tratamento, Long>{
    
}
