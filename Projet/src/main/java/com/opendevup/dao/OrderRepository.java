package com.opendevup.dao;
import java.util.List;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import com.opendevup.entities.Ordre;
public interface OrderRepository extends JpaRepository<Ordre, Long>{
	@Query("select o from Ordre o where o.societe.Code = :code") 
	public Page<Ordre> PageOrdres(@Param("code")String code,Pageable p); 
	@Query("select o from Ordre o where o.societe.Code = :code") 
	public List<Ordre> OrdresSociete(@Param("code")String code);
	@Query("select o from  Ordre o where o.numero = :num")
	public Page<Ordre> findByNuméro(@Param("num")String num,Pageable pageable);
	@Query("select a from Achat a where a.societe.Code = :code") 
	public Page<Ordre> PageAchatsSociete(@Param("code")String code,Pageable p); 
	@Query("select a from Achat a where a.societe.Code = :code") 
	public List<Ordre> ListAchatsSociete(@Param("code")String code); 
	@Query("select v from Vente v where v.societe.Code = :code") 
	public Page<Ordre> PageVentesSociete(@Param("code")String code,Pageable p);
	@Query("select v from Vente v where v.societe.Code = :code") 
	public List<Ordre> listeVentesSociete(@Param("code")String code);
	@Query("select SUM(a.NombreAction) from Achat a where a.societe.Code = :code") 
	public int TotalAchatSociete(@Param("code")String code);
	@Query("select SUM(v.NombreAction) from Vente v where v.societe.Code = :code") 
	public int TotalVenteSociete(@Param("code")String code);
	@Query("select AVG(a.prixAction) from Achat a where a.societe.Code = :code") 
	public int MoyenPrixAchatSociete(@Param("code")String code);
	@Query("select AVG(v.prixAction) from Vente v where v.societe.Code = :code") 
	public int MoyenPrixVenteSociete(@Param("code")String code);
	@Query("select sum(a.NombreAction*a.prixAction) / sum(a.NombreAction) from Achat a where a.societe.Code = :code") 
	public int EstimationPrixAchatSociete(@Param("code")String code);
	@Query("select sum(v.NombreAction*v.prixAction) / sum(v.NombreAction) from Vente v where v.societe.Code = :code") 
	public int EstimationPrixVenteSociete(@Param("code")String code);
}
