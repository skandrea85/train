package com.example.dbmonitor.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.dbmonitor.model.Richiesta;
import com.example.dbmonitor.model.Sede;

import lombok.Data;
@Data
public class DtoRichiesta implements Serializable{




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private int id;
	
	
	private  int tipo;
	
	
	private int stato;
	

	private Date dataStato;


	
	
	
	private DTOSede sede;
	
	
	
	

}
