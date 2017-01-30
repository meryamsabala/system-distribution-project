package com.opendevup.metier;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.opendevup.dao.OrderRepository;
import com.opendevup.entities.Ordre;
@Service
public class OrdreImpl implements IOrdreBourse{
	
	@Autowired
	private OrderRepository orderRopository;
	@Override
	public Ordre save(Ordre c) {
		// TODO Auto-generated method stub
		return orderRopository.save(c);
	}
	@Override
	public List<Ordre> Ordres() {
		// TODO Auto-generated method stub
		return orderRopository.findAll();
	}
	@Override
	public Ordre Ordre(Long num) {
		// TODO Auto-generated method stub
		return orderRopository.findOne(num);
	}
	@Override
	public void SupprimerOrdre(Long num) {
		// TODO Auto-generated method stub
		orderRopository.delete(num);
			}
	@Override
	public List<Ordre> ListAchat(String code) {
		// TODO Auto-generated method stub
		return orderRopository.ListAchatsSociete(code);
	}
	@Override
	public List<Ordre> ListVente(String code) {
		// TODO Auto-generated method stub
		return orderRopository.listeVentesSociete(code);
	}
	@Override
	public List<Ordre> ToutOrdres(String code) {
		// TODO Auto-generated method stub
		return orderRopository.OrdresSociete(code);
	}
	@Override
	public int totaleAchat(String code) {
		// TODO Auto-generated method stub
		return orderRopository.TotalAchatSociete(code);
	}
	@Override
	public int totaleVente(String code) {
		// TODO Auto-generated method stub
		return orderRopository.TotalVenteSociete(code);
	}
	@Override
	public int MoyenAchat(String code) {
		// TODO Auto-generated method stub
		return orderRopository.MoyenPrixAchatSociete(code);
	}
	@Override
	public int MoyenVente(String code) {
		// TODO Auto-generated method stub
		return orderRopository.MoyenPrixVenteSociete(code);
	}
	@Override
	public int EstimationActionAchat(String code) {
		// TODO Auto-generated method stub
		return orderRopository.EstimationPrixAchatSociete(code);
	}
	@Override
	public int EstimationActionVente(String code) {
		// TODO Auto-generated method stub
		return orderRopository.EstimationPrixVenteSociete(code);
	}
	@Override
	public Page<Ordre> PageOrdres(String code,Pageable p) {
		// TODO Auto-generated method stub
		return orderRopository.PageOrdres(code,p);
	}
	@Override
	public Page<Ordre> PageAchat(String code, int page,
			int size) {
		// TODO Auto-generated method stub
		return orderRopository.PageAchatsSociete(code, new PageRequest(page, size));
	}
	@Override
	public Page<Ordre> PageVente(String code, int page,
			int size) {
		// TODO Auto-generated method stub
		return orderRopository.PageVentesSociete(code, new PageRequest(page, size));
	}

	
}
