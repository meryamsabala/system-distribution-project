/*package com.opendevup.service;

import java.util.List;

import javax.jws.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.opendevup.entities.Societe;
import com.opendevup.metier.SocieteImpl;

@Component
@WebService
public class SocieteSOAPService {
	@Autowired
	private SocieteImpl societe;
	
	@WebMethod(operationName="AfficherTout")
	public List<Societe> findAll() {
		// TODO Auto-generated method stub
		return societe.Societes();
	}

	@WebMethod(operationName="findOne")
	public Societe findOne(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		return societe.Societe(code);
	}

	@WebMethod(operationName="removeSociete")
	public void remove(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		societe.SupprimerSociete(code);	
	}

	@WebMethod(operationName="InfoSociete")
	public void InfoSociete(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		Societe s=societe.Societe(code);
		System.out.println("La societe "+s.getNomSociete()+" qui a le code "+s.getCode());
		
	}

}
*/