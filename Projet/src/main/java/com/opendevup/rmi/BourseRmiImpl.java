package com.opendevup.rmi;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opendevup.entities.*;
import com.opendevup.metier.*;

@Component("myRmiService")
public class BourseRmiImpl  implements BourseRmiRemote{
	protected BourseRmiImpl() throws RemoteException {
		super();
	}
	@Autowired
	private OrdreImpl ordre;
	@Autowired
	private SocieteImpl societe;
	@Override
	public List<Societe> ToutSociete() throws RemoteException {
		return societe.Societes();
	}
	@Override
	public List<Ordre> ToutOrdre() throws RemoteException {
		return ordre.Ordres();
	}
	@Override
	public List<Ordre> ListAchat(String code) throws RemoteException {
		return ordre.ListAchat(code);
	}
	@Override
	public List<Ordre> ListVente(String code) throws RemoteException {
		return ordre.ListVente(code);
	}
	@Override
	public List<Ordre> ToutOrdres(String code) throws RemoteException {
		return ordre.ToutOrdres(code);
	}
	@Override
	public int totaleAchat(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordre.totaleAchat(code);
	}
	@Override
	public int totaleVente(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordre.totaleVente(code);
	}
	@Override
	public int MoyenAchat(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordre.MoyenAchat(code);
	}
	@Override
	public int MoyenVente(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordre.MoyenVente(code);
	}
	@Override
	public int EstimationActionAchat(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordre.EstimationActionAchat(code);
	}
	@Override
	public int EstimationActionVente(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return ordre.EstimationActionVente(code);
	}
	@Override
	public void ajouterSocieter(Societe s) throws RemoteException{
		// TODO Auto-generated method stub
		societe.AjouterSociete(s);
		
	}
	@Override
	public void ajouterOrdre(Achat a) throws RemoteException{
		// TODO Auto-generated method stub
		ordre.save(a);
		
	}
	@Override
	public void AjouterVente(Vente v) throws RemoteException{
		// TODO Auto-generated method stub
		ordre.save(v);
		
	}
	@Override
	public Societe getSociete(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return societe.Societe(code);
	}

}
