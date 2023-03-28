package com.example.dbmonitor.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dbmonitor.model.Consistenza;
import com.example.dbmonitor.model.Richiesta;

public interface ConsistenzaServices {
	
	Page<Consistenza> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

	List<Consistenza> getAllConsitenze();
	
	public Consistenza findByid(int id) ;
	
	
	 public Page<Richiesta> findPaginatedRichiesta(int pageNo, int pageSize, String sortField, String sortDirection);



    
    


}
