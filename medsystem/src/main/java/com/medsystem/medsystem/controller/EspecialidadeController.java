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
import com.medsystem.medsystem.repository.EspecialidadeRepository;

@RestController
@RequestMapping({"/especialidade"})
public class EspecialidadeController {
	
	@Autowired
	private EspecialidadeRepository repository;
	
	//Consultar uma lista de todas especialidades cadastradas - http://localhost:8075/especialidade
	@GetMapping
	public List findAll(){
		
		return repository.findAll();
		
	}
	
	//Consultar uma determinada especialidade partir do id deste - http://localhost:8075/especialidade/{id}
	@GetMapping(value = "{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	//Criar um novo cadastro de uma especialidade - http://localhost:8075/especialidade
	@PostMapping
	public Especialidade create(@RequestBody Especialidade esp){
		
		return repository.save(esp);
		
	}
	
	//Atualizar os dados de uma especialidade cadastrada - http://localhost:8075/especialidade/{id}
	@PutMapping(value = "{id}")
	public  ResponseEntity<?> update(@PathVariable Long id, @RequestBody Especialidade esp){
		
		return repository.findById(id)
				.map(record -> {
					record.setNome(esp.getNome());
					record.setDescricao(esp.getDescricao());
					record.setAtivo(esp.isAtivo());
					Especialidade update = repository.save(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
		
	}
	
	//Deletar os dados da especialidade cadastrada - http://localhost:8075/especialidade/{id}
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					return ResponseEntity.ok().body("Deletado com Sucesso");
				}).orElse(ResponseEntity.notFound().build());
		
	}

}



