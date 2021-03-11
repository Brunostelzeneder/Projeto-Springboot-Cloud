package com.devsuperior.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private org.springframework.core.env.Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("CONFIG = " + testConfig);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<worker>> findAll() {
		List<worker> list = repository.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping(value = ("/{id}"))
	public ResponseEntity<worker> findById(@PathVariable Long id ) {
		
		
		
		
		logger.info("PORT = " + env.getProperty("local.server.port"));	
		worker obj = repository.findById(id).get();
		
		return ResponseEntity.ok(obj);
	}
}
