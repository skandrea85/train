package com.example.dbmonitor.dto;

import java.io.Serializable;

import com.example.dbmonitor.model.Sede;

import lombok.Data;

@Data
public class DTOSede extends Sede implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private int id;
	
	

	private String nome;
	

	private String indirizzo;
	

}
