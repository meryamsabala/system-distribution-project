package com.opendevup.metier;

import java.util.List;
import org.springframework.data.domain.*;
import com.opendevup.entities.Ordre;
public interface IOrdreBourse {
	public Ordre save(Ordre c);
	public List<Ordre> ListAchat(String code);
	public List<Ordre> ListVente(String code);
	public Page<Ordre> PageAchat(String code,int page,int size);
	public Page<Ordre> PageVente(String code,int page, int size);
	public List<Ordre> ToutOrdres(String code);
	public int totaleAchat(String code);
	public int totaleVente(String code);
	public int MoyenAchat(String code);
	public int MoyenVente(String code);
	public int EstimationActionAchat(String code);
	public int EstimationActionVente(String code);
	public List<Ordre> Ordres();
	public void SupprimerOrdre(Long num);
	public Page<Ordre> PageOrdres(String code,Pageable p);
	public Ordre Ordre(Long num);
	
}


































