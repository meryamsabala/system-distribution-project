package com.opendevup.service;

import java.util.List;
import javax.jws.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.opendevup.entities.Ordre;
import com.opendevup.metier.OrdreImpl;
@Component
@WebService
public class OrdreSOAPService {

	@Autowired
	private OrdreImpl order;
	

	@WebMethod(operationName="ToutOrdres")
	public List<Ordre> findAll() {
		// TODO Auto-generated method stub
		return order.Ordres();
	}
	@WebMethod(operationName="OneOrdre")
	public Ordre findOne(@WebParam(name="num")Long num) {
		// TODO Auto-generated method stub
		return order.Ordre(num);
	}
	@WebMethod(operationName="RemoveOrdre")
	public void remove(@WebParam(name="num")Long num) {
		// TODO Auto-generated method stub
		order.SupprimerOrdre(num);
			}
	
	@WebMethod(operationName="listAchat")
	public List<Ordre> ListAchat(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		return order.ListAchat(code);
	}
	@WebMethod(operationName="ListVente")
	public List<Ordre> ListVente(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		return order.ListVente(code);
	}
	@WebMethod(operationName="OrdresSociete")
	public List<Ordre> ToutOrdres(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		return order.ToutOrdres(code);
	}
	@WebMethod(operationName="totaleAchat")
	public int totaleAchat(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		return order.totaleAchat(code);
	}
	@WebMethod(operationName="totaleVente")
	public int totaleVente(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		return order.totaleVente(code);
	}
	@WebMethod(operationName="MoyenAchat")
	public int MoyenAchat(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		return order.MoyenAchat(code);
	}
	@WebMethod(operationName="MoyenVente")
	public int MoyenVente(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		return order.MoyenVente(code);
	}
	@WebMethod(operationName="EstimationActionAchat")
	public int EstimationActionAchat(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		return order.EstimationActionAchat(code);
	}
	@WebMethod(operationName="EstimationActionVente")
	public int EstimationActionVente(@WebParam(name="code")String code) {
		// TODO Auto-generated method stub
		return order.EstimationActionVente(code);
	}
	
}
