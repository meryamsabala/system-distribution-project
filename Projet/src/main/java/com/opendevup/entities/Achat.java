package com.opendevup.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Achat")
public class Achat extends Ordre{


	public Achat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Achat(Date dateOrdre, int nombreAction, double prixAction,
			Societe societe) {
		super(dateOrdre, nombreAction, prixAction, societe);
		// TODO Auto-generated constructor stub
	}	
}
