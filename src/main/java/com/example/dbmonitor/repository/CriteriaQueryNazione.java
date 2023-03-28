package com.example.dbmonitor.repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dbmonitor.model.Nazione;
import com.example.dbmonitor.model.Sede;

@Service
@Transactional("transactionManager")
public class CriteriaQueryNazione {
	
	@Autowired
	
	EntityManager entityManager;
	
	
	
	public void insertWithEntityRichiesta(Nazione nazione) {
	    this.entityManager.persist(nazione);
	}
	
	public void updateNazione(int a,String nome) {
		
		
	
	
	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();


	CriteriaUpdate<Nazione> update = criteriaBuilder.createCriteriaUpdate(Nazione.class);
	Root<Nazione> nazione = update.from(Nazione.class);
	update.set("nome", nome);
	update.where(criteriaBuilder.equal(nazione.get("id"), criteriaBuilder.parameter(Integer.class, "id")));	
	javax.persistence.Query query = entityManager.createQuery(update);
	query.setParameter("id", a);
	int rowCount = query.executeUpdate();
	
	}
	

}
