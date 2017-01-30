package com.opendevup.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.opendevup.entities.Societe;
import com.opendevup.metier.SocieteImpl;
@RestController
public class SocieteService {
	@Autowired
	private SocieteImpl societe;
	@RequestMapping(value="/societes",method=RequestMethod.GET)
	public List<Societe> findSocietes()
	{
		return societe.Societes();
	}
	@RequestMapping(value="/addSociete",method=RequestMethod.POST)
	public void ajouterSociete(@RequestBody Societe s)
	{
		societe.AjouterSociete(s);
	}
	@RequestMapping(value="/societe/{code}")
	public Societe getSociete(@PathVariable("code")String code)
	{
		return societe.Societe(code);
	}
	@RequestMapping(value="/remove/{code}")
	public void supprimerSociete(@PathVariable("code")String code)
	{
		societe.SupprimerSociete(code);
	}
	@RequestMapping(value="/byNom")
	public Page<Societe> SocieteByNom(String nom,int page,int size)
	{
		return societe.PageSocietes(nom,page,size);
	}
	
	
}
