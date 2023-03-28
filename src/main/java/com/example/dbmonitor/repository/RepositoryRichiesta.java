package com.example.dbmonitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dbmonitor.model.Consistenza;
import com.example.dbmonitor.model.Richiesta;

public interface RepositoryRichiesta extends JpaRepository<Richiesta, Integer>{

}
