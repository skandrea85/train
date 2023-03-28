package com.example.dbmonitor.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Sede implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -625059409674513110L;
	
	
	public Sede(int id, String nome, String indirizzo) {
	super();
	this.id = id;
	this.nome = nome;
	this.indirizzo = indirizzo;
	
}





	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="indirizzo")
	private String indirizzo;
	
	
	
	
	
	  @JsonManagedReference
	@OneToMany(mappedBy="sede")
	private Set<Richiesta> sedeItems;
	
	  
		@ManyToOne
		@JoinColumn(name="idNazione")
		private Nazione nazione;
	

}
