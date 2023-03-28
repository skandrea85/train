package com.example.dbmonitor.service;

import java.util.Date;
import java.util.List;

import com.example.dbmonitor.model.Richiesta;

public interface ServiceRichiesta {
	
	
	 List<Richiesta> findByLikeAndBetweenCriteria(String employeeName, Date employeeIdStart, Date employeeIdEnd);

}
