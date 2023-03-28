package com.example.dbmonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dbmonitor.model.Consistenza;
import com.example.dbmonitor.model.Richiesta;
import com.example.dbmonitor.service.ConsistenzaServiceImpl;
import com.example.dbmonitor.service.ConsistenzaServices;

@Controller
public class ControllerConsistenze {
	
	@Autowired
	public ConsistenzaServices consistenzaImpl;
	

	
	 @GetMapping("/")
	    public String viewHomePage(Model model) {

	        
	        return findPaginated(1, "id", "desc", model);
	    }
	 
	 
	 @GetMapping("/richieste")
	    public String viewPageRichiesteList(Model model) {

	        
	        return findPaginatedRichieste(1, "id", "desc", model);
	    }
	 
	 @GetMapping("/dettaglioConsistenza/{id}")
	 
	 public String dettaglioConsistenza (@PathVariable(value="id")int id,Model model)
	 
	 
	 {Consistenza consistenza =consistenzaImpl.findByid(id);
	 
	 
		model.addAttribute("consistenza", consistenza);

	 
		 
		 
		 return "dettaglioConsistenza";
	 }
	 
	 
	 @GetMapping("/page/{pageNo}")
		public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
				@RequestParam("sortField") String sortField,
				@RequestParam("sortDir") String sortDir,
				Model model) {
			int pageSize = 20;
			
			Page<Consistenza> page = consistenzaImpl.findPaginated(pageNo, pageSize, sortField, sortDir);
			List<Consistenza> listConsistenza = page.getContent();
			
			model.addAttribute("currentPage", pageNo);
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements());
			
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDir", sortDir);
			model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
			// List<Consistenza> a=listConsistenza;
			model.addAttribute("allconsistenzalist", listConsistenza);
			return "index";
		}
	 
	 @GetMapping("/pageRichieste/{pageNo}")
		public String findPaginatedRichieste(@PathVariable (value = "pageNo") int pageNo, 
				@RequestParam("sortField") String sortField,
				@RequestParam("sortDir") String sortDir,
				Model model) {
			int pageSize = 20;
			
			Page<Richiesta> page = consistenzaImpl.findPaginatedRichiesta(pageNo, pageSize, sortField, sortDir);
			List<Richiesta> listRichiesta = page.getContent();
			
			model.addAttribute("currentPage", pageNo);
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements());
			
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDir", sortDir);
			model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
			// List<Consistenza> a=listConsistenza;
			model.addAttribute("allRichiestaList", listRichiesta);
			return "richiestaList";
		}
	
	
	
	

}
