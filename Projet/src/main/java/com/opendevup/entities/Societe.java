package com.opendevup.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Societe implements Serializable{


	@Id
	private String Code;
	private String nomSociete;
	
	//@OneToMany(mappedBy="societe",fetch=FetchType.LAZY)
	//private Collection<Ordre> Ordres;
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
/*
	public Collection<Ordre> getOrdres() {
		return Ordres;
	}
	public void setOrdres(Collection<Ordre> ordres) {
		Ordres = ordres;
	}
*/
	public Societe(String code,String nomSociete) {
		super();
		this.Code=code;
		this.nomSociete = nomSociete;
	}
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Societe(String code) {
		// TODO Auto-generated constructor stub
		this.Code=code;
	}
	
	
	
	
	
	

}
