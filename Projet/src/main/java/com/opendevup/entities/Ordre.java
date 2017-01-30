package com.opendevup.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_ordre")
@DiscriminatorValue("Ordre")
public abstract class Ordre implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long numero;
	protected Date dateOrdre;
	protected int NombreAction;
	protected double prixAction;
	@ManyToOne
	@JoinColumn(name="ID_Societ")
	protected Societe societe;
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Date getDateOrdre() {
		return dateOrdre;
	}
	public void setDateOrdre(Date dateOrdre) {
		this.dateOrdre = dateOrdre;
	}
	public int getNombreAction() {
		return NombreAction;
	}
	public void setNombreAction(int nombreAction) {
		NombreAction = nombreAction;
	}
	public double getPrixAction() {
		return prixAction;
	}
	public void setPrixAction(double prixAction) {
		this.prixAction = prixAction;
	}
	
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	public Ordre(Date dateOrdre, int nombreAction, double prixAction,
			Societe societe) {
		super();
		this.dateOrdre = dateOrdre;
		NombreAction = nombreAction;
		this.prixAction = prixAction;
		this.societe = societe;
	}
	public Ordre() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ordre numero= " + numero + " , dateOrdre= " + dateOrdre
				+ "  NombreAction= " + NombreAction + "  prixAction= "
				+ prixAction + "  societe= " + societe ;
	}

}
