package com.medsystem.medsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsystem.medsystem.model.Especialidade;
import com.medsystem.medsystem.model.Medico;
import com.medsystem.medsystem.repository.MedicoRepository;

@RestController
@RequestMapping({"/medico"})
public class MedicoController {
		
	@Autowired
	private MedicoRepository repository;
	
	//Consultar uma lista de todos medicos cadastrados - http://localhost:8075/medico
	@GetMapping
	public List findAll(){
		
		return repository.findAll();
		
	}
	
	//Consultar um determinado medico cadastrado partir do id deste - http://localhost:8075/medico/{id}
	@GetMapping(value = "{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	
	//Consultar uma lista de medicos cadastrados partir da especialidade destes - http://localhost:8075/medico/especialidade/{especialidade}
	@GetMapping({"/especialidade/{especialidade}"})
	public List<Medico> findByEsp(@PathVariable Especialidade especialidade){
			
		return repository.findByEspecialidade(especialidade);
		
	}
	
	
	//Consultar uma lista de medicos cadastrados que são ativos ou inativos - http://localhost:8075/medico/tipo/{ativo}
	@GetMapping({"/tipo/{ativo}"})
	public List<Medico> findByAtivo(@PathVariable boolean ativo){
		
		return repository.findByAtivo(ativo);
		
	}
	
	
	//Criar um novo cadastro de um medico - http://localhost:8075/medico
	@PostMapping
	public Medico create(@RequestBody Medico med){
		
		return repository.save(med);
		
	}
	
	//Atualizar os dados de um medico cadastrado - http://localhost:8075/medico/{id}
	@PutMapping(value = "{id}")
	public  ResponseEntity<?> update(@PathVariable Long id, @RequestBody Medico med){
		
		return repository.findById(id)
				.map(record -> {
					record.setNome(med.getNome());
					record.setDatanascimento(med.getDatanascimento());
					record.setAtivo(med.isAtivo());
					record.setEspecialidade(med.getEspecialidade());
					Medico update = repository.save(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
		
	}
	
	//Deletar os dados do medico cadastrado - http://localhost:8075/medico/{id}
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					return ResponseEntity.ok().body("Deletado com Sucesso");
				}).orElse(ResponseEntity.notFound().build());
		
	}

}
