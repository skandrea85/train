package com.example.dbmonitor.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dbmonitor.dto.CountSede;
import com.example.dbmonitor.dto.DtoRichiesta;
import com.example.dbmonitor.model.Richiesta;
import com.example.dbmonitor.model.Sede;


@Service
public class CriteriaQueryRichiesta {
	@Autowired
	EntityManager entityManager;
	
	public List<Richiesta> queryOk(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		// Query for a List of objects.
		CriteriaQuery<Richiesta> criteriaQuery = criteriaBuilder.createQuery(Richiesta.class);
		Root<Richiesta> root = criteriaQuery.from(Richiesta.class);
		
		criteriaQuery.multiselect(root.get("id"),root.get("tipo"),root.get("stato"),root.get("dataStato"));
//		 Path<Richiesta> tipo = richieste.get("tipo");
//		 Path<Richiesta> dataStato = richieste.get("dataStato");
//		criteriaQuery.select(tipo,dataStato);
		Query query = entityManager.createQuery(criteriaQuery);
		List<Richiesta> result = query.getResultList();
		
		
		
		return result;
	}
	
	
	public List<Richiesta> joinSede(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		// Query for a List of objects.
		CriteriaQuery<Richiesta> criteriaQuery = criteriaBuilder.createQuery(Richiesta.class);
		Root<Richiesta> root = criteriaQuery.from(Richiesta.class);
		Join<Richiesta, Sede> sede = root.join("sede");
		
		
		criteriaQuery.multiselect(root.get("id"),root.get("tipo"),root.get("stato"),root.get("dataStato"),sede.get("nome"));
//		 Path<Richiesta> tipo = richieste.get("tipo");
//		 Path<Richiesta> dataStato = richieste.get("dataStato");
//		criteriaQuery.select(tipo,dataStato);
		Query query = entityManager.createQuery(criteriaQuery);
		List<Richiesta> result = query.getResultList();
		
		
		
		return result;
	}
	
	public Richiesta joinSedeB(int a){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		// Query for a List of objects.
		CriteriaQuery<Richiesta> criteriaQuery = criteriaBuilder.createQuery(Richiesta.class);
		Root<Richiesta> root = criteriaQuery.from(Richiesta.class);
		Join<Richiesta, Sede> sede = root.join("sede");
		
		
		//criteriaQuery.select(root);
		criteriaQuery.multiselect(root.get("id"),root.get("tipo"),root.get("stato"),root.get("dataStato"),root.get("sede"));
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), criteriaBuilder.parameter(Integer.class, "id")));

		Query query = entityManager.createQuery(criteriaQuery);
		query.setParameter("id", a);
		Optional<Richiesta> first = query.getResultList().stream().findFirst();
		
		
		
		Richiesta s= (Richiesta) query.getSingleResult();
		
		
		
		return s;
	}
	
	public List<CountSede> countBySede(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<CountSede> criteriaQuery = criteriaBuilder.createQuery(CountSede.class);
		Root<Richiesta> root = criteriaQuery.from(Richiesta.class);
		Join<Richiesta, Sede> sede = root.join("sede");
		
		
		criteriaQuery.multiselect(criteriaBuilder.count(root.get("sede")),sede.get("nome"));
		
		criteriaQuery.groupBy(root.get("sede"));
		
		

		Query query = entityManager.createQuery(criteriaQuery);
	
		List<CountSede> first = query.getResultList();
		
		
		
		
		
		
		return first;
	}
	
	
	public List<Richiesta> wherePredicate(String text,Date dataStatoStart,Date dataStatoEnd,String sede1){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		// Query for a List of objects.
		CriteriaQuery<Richiesta> criteriaQuery = criteriaBuilder.createQuery(Richiesta.class);
		Root<Richiesta> root = criteriaQuery.from(Richiesta.class);
		Join<Richiesta, Sede> sede = root.join("sede");
		
		List<Predicate> ciao=new ArrayList<Predicate>();
		
	
		if(text!=null) {
		Predicate d=criteriaBuilder.or(criteriaBuilder.like(root.get("note"), "%" + text + "%"),
                criteriaBuilder.like(root.get("noteStato"), "%" + text + "%"));
		ciao.add(d);
		}
		if(dataStatoStart!=null&& dataStatoEnd!=null) {
    
		Predicate dr=criteriaBuilder.between(root.get("dataStato"),dataStatoStart,dataStatoEnd);
		
		ciao.add(dr);
		}
		
		if(sede1!=null) {
		    
			Predicate dr=criteriaBuilder.like(sede.get("nome"), "%" + sede1 + "%");
			
			ciao.add(dr);
			}
		
		
		   criteriaQuery.multiselect(root.get("id"),root.get("tipo"),root.get("stato"),root.get("dataStato"),root.get("sede"))
           .where(ciao.toArray(new Predicate[]{}));
		
		


		Query query = entityManager.createQuery(criteriaQuery);
		
		List<Richiesta> first = query.getResultList();
		
		
		
		
		
		
		return first;
	}
	
	
	
	
	
	
	
	
	

}
