package com.opendevup.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.opendevup.entities.*;
import com.opendevup.metier.*;
@CrossOrigin("*")
@RestController
public class OrdreService {
	@Autowired
	private OrdreImpl order;
	@Autowired
	private SocieteImpl societe;
	@RequestMapping(value="/Ordres",method=RequestMethod.GET)
	public List<Ordre> findAll() {
		// TODO Auto-generated method stub
		return order.Ordres();
	}
	@RequestMapping(value="/Ordre/{num}",method=RequestMethod.GET)
	public Ordre findOne(@PathVariable("num")Long num) {
		// TODO Auto-generated method stub
		return order.Ordre(num);
	}
	@RequestMapping(value="/SuppOrdre/{num}",method=RequestMethod.GET)
	public void remove(@PathVariable("num")Long num) {
		// TODO Auto-generated method stub
		order.SupprimerOrdre(num);}
	@RequestMapping(value="/ListAchat/{code}",method=RequestMethod.GET)
	public List<Ordre> ListAchat(@PathVariable("code")String code) {
		// TODO Auto-generated method stub
		return order.ListAchat(code);
	}
	@RequestMapping(value="/ListVente/{code}",method=RequestMethod.GET)
	public List<Ordre> ListVente(@PathVariable("code")String code) {
		// TODO Auto-generated method stub
		return order.ListVente(code);
	}
	@RequestMapping(value="/ToutOrdres/{code}",method=RequestMethod.GET)
	public List<Ordre> ToutOrdres(@PathVariable("code")String code) {
		// TODO Auto-generated method stub
		return order.ToutOrdres(code);
	}
	@RequestMapping(value="/totalAchat/{code}",method=RequestMethod.GET)
	public int totaleAchat(@PathVariable("code")String code) {
		// TODO Auto-generated method stub
		return order.totaleAchat(code);
	}
	@RequestMapping(value="/totalVente/{code}",method=RequestMethod.GET)
	public int totaleVente(@PathVariable("code")String code) {
		// TODO Auto-generated method stub
		return order.totaleVente(code);
	}
	@RequestMapping(value="/MoyenAchat/{code}",method=RequestMethod.GET)
	public int MoyenAchat(@PathVariable("code")String code) {
		// TODO Auto-generated method stub
		return order.MoyenAchat(code);
	}
	@RequestMapping(value="/MoyenVente/{code}",method=RequestMethod.GET)
	public int MoyenVente(@PathVariable("code")String code) {
		// TODO Auto-generated method stub
		return order.MoyenVente(code);
	}
	@RequestMapping(value="/EstimationAchat/{code}",method=RequestMethod.GET)
	public int EstimationActionAchat(@PathVariable("code")String code) {
		// TODO Auto-generated method stub
		return order.EstimationActionAchat(code);
	}
	@RequestMapping(value="/EstimationVente/{code}",method=RequestMethod.GET)
	public int EstimationActionVente(@PathVariable("code")String code) {
		// TODO Auto-generated method stub
		return order.EstimationActionVente(code);
	}
	@RequestMapping(value="/PageOrdres",method=RequestMethod.GET)
	public Page<Ordre> PageOrdres(String code, int page,int size) {
		// TODO Auto-generated method stub
		return order.PageOrdres(code,new PageRequest(page, size));
	}
	
	@RequestMapping(value="/societes/{code}/achats",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Ordre saveAchat(@PathVariable("code")String code,@RequestBody Achat a){
		a.setSociete(societe.Societe(code));
		return order.save(a);
	}
	@RequestMapping(value="/societes/{code}/ventes",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Ordre saveVente(@PathVariable("code")String code,@RequestBody Vente v){
		v.setSociete(societe.Societe(code));
		return order.save(v);
	}
}
