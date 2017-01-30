package com.opendevup.dao;

import java.util.List;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import com.opendevup.entities.Societe;

public interface SocieteRepository extends JpaRepository<Societe, String>{
	
	@Query("select s from Societe s where s.nomSociete like :x")
	public Page<Societe> PageSociete(@Param("x")String nom,Pageable page);
	
	@Query("select s from Societe s where s.nomSociete like :x")
	public List<Societe> ListSociete(@Param("x")String nom);
	
}
