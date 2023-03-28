package com.example.dbmonitor.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dbmonitor.model.Richiesta;
import com.example.dbmonitor.repository.DAORichiesta;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
@Service
public class ServiceRichiestaImpl  implements ServiceRichiesta{
	
	
	@Autowired
	DAORichiesta daoRichiesta;
	@Override
	public List<Richiesta> findByLikeAndBetweenCriteria(String text,Date dataStatoStart, Date dataStatoEnd){
        return daoRichiesta.findAll(new Specification<Richiesta>() {
            @Override
            public javax.persistence.criteria.Predicate toPredicate(Root<Richiesta> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(text!=null) {
                    predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("note"), "%" + text + "%"),
                            criteriaBuilder.like(root.get("noteStato"), "%" + text + "%")));
                }
                if(dataStatoStart!=null && dataStatoEnd!=null){
                    predicates.add(criteriaBuilder.between(root.get("dataStato"),dataStatoStart,dataStatoEnd));
                }
        		

                return query.multiselect(root.get("id"),root.get("tipo"),root.get("stato"),root.get("dataStato")).where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))).getRestriction();
            }
        });
    }

	
		
	

	
}
