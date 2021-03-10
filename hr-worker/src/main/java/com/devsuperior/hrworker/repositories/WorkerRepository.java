package com.devsuperior.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.hrworker.entities.worker;

public interface WorkerRepository extends JpaRepository<worker, Long> {

}
