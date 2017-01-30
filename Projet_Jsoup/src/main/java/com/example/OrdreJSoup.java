package com.example;
import java.rmi.Naming;
import java.text.*;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import com.opendevup.entities.*;
import com.opendevup.rmi.BourseRmiRemote;
public class OrdreJSoup {
	public static void main(String[] args) throws Exception {
		BourseRmiRemote proxy=(BourseRmiRemote) Naming.lookup("rmi://localhost:1099/BK");
		List<Societe> listSos=proxy.ToutSociete();
      Timer minuteur = new Timer();
	  TimerTask tache = new TimerTask() {
		  @Override
			public void run() {
	            	try{
	            	for(Societe s: listSos){
	    				Document docOr = Jsoup.connect("https://www.wafabourse.com/trader/market/"+s.getCode()+"/XCAS/ISIN").get();
	    				Elements achats =docOr.select("table:has(th.th_achat)").select("table.t-data-grid").select("tr:has(td.bidNbOrders)");
	    				for(Element a: achats){
	    					if(!a.select(".bidNbOrders").text().equals("-") && !a.select(".bidPrice").text().equals("-")){
	    						int nbreAction=Integer.parseInt(a.select(".bidNbOrders").text());
	    						NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
	    					    Number nbrPrix = format.parse(a.select(".bidPrice").text());
	    					    double prixAction = nbrPrix.doubleValue();
	    					    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    						Date dateAction = formatter.parse(docOr.select(".lastPriceDateTime").not(".t-first").text());
	    						Achat ach=new Achat(dateAction, nbreAction, prixAction,s);
	    						proxy.ajouterOrdre(ach);
	    						System.out.println(ach.getNombreAction() + "  " +ach.getPrixAction()+ "  "+ach.getDateOrdre());
	    					}
	    				}
	    				Elements ventes =docOr.select("table:has(th.th_vente)").select("table.t-data-grid").select("tr:has(td.askNbOrders)");
	    				
	    				for(Element v: ventes){	
	    					if(!v.select(".askNbOrders").text().equals("-") && !v.select(".askPrice").text().equals("-")){
	    						int nbreAction=Integer.parseInt(v.select(".askNbOrders").text());
	    						NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
	    					    Number nbrPrix = format.parse(v.select(".askPrice").text());
	    					    double prixAction = nbrPrix.doubleValue();
	    					    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    						Date dateAction = formatter.parse(docOr.select(".lastPriceDateTime").not(".t-first").text());
	    						Vente ven=new Vente(dateAction, nbreAction, prixAction,s);
	    						proxy.AjouterVente(ven);
	    						System.out.println(ven.getNombreAction() + "  " +ven.getPrixAction()+ "  "+ven.getDateOrdre());
	    					}
	    				}
	    				}
	            	}
	            	catch (Exception e) {
	            		e.printStackTrace();
					}	
					}
	       };
	       minuteur.schedule(tache, 0, 15000);
	}
}
