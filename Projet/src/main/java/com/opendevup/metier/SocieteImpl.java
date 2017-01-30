package com.opendevup.metier;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.opendevup.dao.SocieteRepository;
import com.opendevup.entities.Societe;
@Service
public class SocieteImpl implements IsocieteBourse{
	@Autowired
	private SocieteRepository  societeRepository;
	@Override
	public Societe AjouterSociete(Societe c) {
		// TODO Auto-generated method stub
		return societeRepository.save(c);
	}
	@Override
	public List<Societe> Societes() {
		// TODO Auto-generated method stub
		return societeRepository.findAll();
	}
	
	@Override
	public Societe Societe(String code) {
		// TODO Auto-generated method stub
		return societeRepository.findOne(code);
	}
	@Override
	public void SupprimerSociete(String code) {
		// TODO Auto-generated method stub
		societeRepository.delete(code);	
	}
	@Override
	public Page<Societe> PageSocietes(String nom, int page,int size) {
		// TODO Auto-generated method stub
		return societeRepository.PageSociete(nom,new PageRequest(page,size));
	}
	@Override
	public void InfoSociete(String code) {
		// TODO Auto-generated method stub
		Societe s=societeRepository.findOne(code);
		System.out.println("La societe "+s.getNomSociete()+" qui a le code "+s.getCode());
		
	}

	
}
