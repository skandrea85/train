package com.example.dbmonitor.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="nazione")
public class Nazione {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="nomeEn")
	private String nomeEn;
	
	
	
	@OneToMany(mappedBy ="nazione" )
	private Set<Sede> sede;
	
	
	
	

}
