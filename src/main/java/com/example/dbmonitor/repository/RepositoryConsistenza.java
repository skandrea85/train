package com.example.dbmonitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbmonitor.model.Consistenza;


@Repository
public interface RepositoryConsistenza extends JpaRepository<Consistenza, Integer> {
	

}
