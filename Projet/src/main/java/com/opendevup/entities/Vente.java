package com.opendevup.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Vente")
public class Vente extends Ordre{

	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vente(Date dateOrdre, int nombreAction, double prixAction,
			Societe societe) {
		super(dateOrdre, nombreAction, prixAction, societe);
		// TODO Auto-generated constructor stub
	}
}
