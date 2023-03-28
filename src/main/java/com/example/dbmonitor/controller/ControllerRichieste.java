package com.example.dbmonitor.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbmonitor.dto.CountSede;
import com.example.dbmonitor.dto.DTOSede;
import com.example.dbmonitor.dto.DtoRichiesta;
import com.example.dbmonitor.model.Nazione;
import com.example.dbmonitor.model.Richiesta;
import com.example.dbmonitor.model.Sede;
import com.example.dbmonitor.repository.CriteriaQueryNazione;
import com.example.dbmonitor.repository.CriteriaQueryRichiesta;
import com.example.dbmonitor.service.ServiceRichiesta;

@RestController
@RequestMapping("/richieste/")
public class ControllerRichieste {
	
	@Autowired
	CriteriaQueryRichiesta criteria;
	@Autowired
	CriteriaQueryNazione criteriaQueryNazione;
	
	@Autowired
	ServiceRichiesta serviceRichiesta;
	
	@GetMapping("/getricheste")
	public List<Richiesta> getRichieste() {
		
		return criteria.queryOk();
	}
	
	
	@GetMapping("/getSede")
	public List<Richiesta> getRichijoinsedeeste() {
		
		return criteria.joinSede();
	}
	
	@GetMapping("/getRichiesta/{id}")
	public DtoRichiesta getRichijoinsedeeste2(@PathVariable int id) {
		
		Richiesta a= criteria.joinSedeB(id);
		
		DtoRichiesta c=new DtoRichiesta();
		DTOSede sede=new DTOSede();
		
		sede.setNome(a.getSede().getNome());
		sede.setIndirizzo(a.getSede().getIndirizzo());
		
		c.setId(a.getId());
		c.setDataStato(a.getDataStato());
		c.setSede(sede);
		
	
		
		return c;
				
	}
	
	@GetMapping("/countBySede")
	public List<CountSede> countSede() {
		

	
		
		return criteria.countBySede();
				
	}
	

	
	@PostMapping("/insertNazione")
	public void postSede(@RequestBody Nazione nazione) {
		

	
		criteriaQueryNazione.insertWithEntityRichiesta(nazione);
		 
				
	}
	
	@PatchMapping("/updateNazione/{id}/{nome}")
	public void updateSede(@PathVariable int id,@PathVariable String nome ) {
		

	
		criteriaQueryNazione.updateNazione(id,nome);
		 
				
	}
	
	@GetMapping("/ricercaRichieste")
	public List<Richiesta> maskSearch(@RequestParam (required = false)String note,@RequestParam (required = false)Date data1,@RequestParam (required = false)Date data2) {
		

	
	return	serviceRichiesta.findByLikeAndBetweenCriteria(note, data1, data2);
		 
				
	}
	
	
	
	@GetMapping("/ricercaRichieste2")
	public List<DtoRichiesta> maskSearch2(@RequestParam (required = false)String note,@RequestParam (required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date data1,@RequestParam (required = false)@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date data2,@RequestParam (required = false)String sede) {
		
		List<Richiesta> richieste=criteria.wherePredicate(note, data1, data2,sede);
		
		List<DtoRichiesta>dto=new ArrayList<DtoRichiesta>();
		
		
		for(Richiesta item: richieste) {
			
			DtoRichiesta c=new DtoRichiesta();
			DTOSede sede1=new DTOSede();
			
			
			sede1.setNome(item.getSede().getNome());
			sede1.setIndirizzo(item.getSede().getIndirizzo());
			
			c.setId(item.getId());
			c.setDataStato(item.getDataStato());
			c.setSede(sede1);
			
			dto.add(c);
			
		}
		
		
		
    return dto;
 
				
	}
	
	
	
	
	
	



}
