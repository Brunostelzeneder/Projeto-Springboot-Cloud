package com.devsuperior.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<worker>> findAll() {
		List<worker> list = repository.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping(value = ("/{id}"))
	public ResponseEntity<worker> findById(@PathVariable Long id ) {
		worker obj = repository.findById(id).get();
		
		return ResponseEntity.ok(obj);
	}
}
