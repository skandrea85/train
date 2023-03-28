package com.example.dbmonitor.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dbmonitor.model.Richiesta;
@Repository
public interface DAORichiesta extends CrudRepository<Richiesta,Long>,JpaSpecificationExecutor<Richiesta>{
 

}
