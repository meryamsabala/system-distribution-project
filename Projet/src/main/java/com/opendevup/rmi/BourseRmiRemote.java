package com.opendevup.rmi;

import java.rmi.Remote;


import java.rmi.RemoteException;
import java.util.List;

import com.opendevup.entities.*;

public interface BourseRmiRemote extends Remote{
	
	public List<Societe>  ToutSociete() throws RemoteException;
	public List<Ordre> ToutOrdre() throws RemoteException;
	public List<Ordre> ListAchat(String code) throws RemoteException;
	public List<Ordre> ListVente(String code) throws RemoteException;
	public List<Ordre> ToutOrdres(String code) throws RemoteException;
	public int totaleAchat(String code) throws RemoteException;
	public int totaleVente(String code)throws RemoteException;
	public int MoyenAchat(String code)throws RemoteException;
	public int MoyenVente(String code)throws RemoteException;
	public int EstimationActionAchat(String code)throws RemoteException;
	public int EstimationActionVente(String code)throws RemoteException;
	public void ajouterSocieter(Societe s)throws RemoteException;
	public void ajouterOrdre(Achat a)throws RemoteException;
	public void AjouterVente(Vente v)throws RemoteException;
	public Societe getSociete(String code) throws RemoteException;

}
