package com.opendevup.metier;

import java.util.List;
import org.springframework.data.domain.Page;
import com.opendevup.entities.Societe;
public interface IsocieteBourse {
	public Societe AjouterSociete(Societe c);
	public List<Societe> Societes();
	public Societe Societe(String code);
	public void InfoSociete(String code);
	public void SupprimerSociete(String code);
	public Page<Societe> PageSocietes(String code,int page,int size);
}
