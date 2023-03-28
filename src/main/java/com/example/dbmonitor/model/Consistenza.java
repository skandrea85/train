package com.example.dbmonitor.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;

import lombok.Data;

@Data
@Table
@Entity
public class Consistenza implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	@Column
	private int  stato;
	
	
	@Column(name="dataAttivazione")
	@Temporal(TemporalType.TIMESTAMP)

	
	private Date dataAttivazione;
	
	@Column
	private String tgu;
	
	
	

	@Column(name="dataStato")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataStato;
	
	@Column(name="esitoCollaudo")
	@NonNull
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean esitoCollaudo;
	
	
	
	
	 @ManyToOne
	 @JoinColumn(name="idRichiesta")
	 private Richiesta richiesta;
	 
	 

	  
	 public Consistenza () {
		
		
		
	 }
	


}
