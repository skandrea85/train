package com.example.dbmonitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Sort;



import com.example.dbmonitor.model.Consistenza;
import com.example.dbmonitor.model.Richiesta;
import com.example.dbmonitor.repository.RepositoryConsistenza;
import com.example.dbmonitor.repository.RepositoryRichiesta;

@Service
public class ConsistenzaServiceImpl implements ConsistenzaServices {
	
	
	@Autowired
	private RepositoryConsistenza consistenzaRepository;
	
	@Autowired
	private RepositoryRichiesta richiestaRepository;
	
	@Override
	public List<Consistenza> getAllConsitenze() {
		return consistenzaRepository.findAll();
	}

	@Override
	public Page<Consistenza> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.consistenzaRepository.findAll(pageable);
	}

	@Override
	public Consistenza findByid(int id) {
		
		return consistenzaRepository.getOne(id);
	}

	@Override
	public Page<Richiesta> findPaginatedRichiesta(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.richiestaRepository.findAll(pageable);
	}
	
	
	

}
