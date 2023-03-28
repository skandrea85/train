package com.example.dbmonitor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table
@Data
@AllArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Richiesta implements Serializable{
	
	

	


     
	

	public Richiesta() {
		super();
	}

	public Richiesta(int id, int tipo, int stato, Date dataStato, Sede sede
			) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.stato = stato;
		this.dataStato = dataStato;
		
		this.sede = sede;
	
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="tipo")
	private  int tipo;
	
	@Column(name="noteStato")
	private  String  noteStato;
	
	
	@Column(name="note")
	private String note;
	
	@Column
	private int stato;
	
	@Column(name="dataStato")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataStato;

	
	@OneToMany(mappedBy="richiesta")
	private Set<Consistenza> consistenzeItems;
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="idSedeA")
	private Sede sede;
	
	@ManyToOne
	@JoinColumn(name="idServizio")
	private Servizio servizio;
	
	

	
}
