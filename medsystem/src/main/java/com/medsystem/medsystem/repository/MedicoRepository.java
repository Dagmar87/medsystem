package com.medsystem.medsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medsystem.medsystem.model.Especialidade;
import com.medsystem.medsystem.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{
	
	@Query(value = "select * from medico m where esp_id = ?", nativeQuery = true)
	List<Medico> findByEspecialidade(Especialidade especialidade);
	
	@Query(value = "select * from medico m where ativo = ?", nativeQuery = true)
	List<Medico> findByAtivo(boolean ativo);

}
