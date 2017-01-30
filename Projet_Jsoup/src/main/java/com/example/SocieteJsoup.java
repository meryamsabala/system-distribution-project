package com.example;

import java.rmi.Naming;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.opendevup.entities.Societe;
import com.opendevup.rmi.BourseRmiRemote;


public class SocieteJsoup {

	public static void main(String[] args) {
	
			try {
			BourseRmiRemote proxy=(BourseRmiRemote) Naming.lookup("rmi://localhost:1099/BK");
			Document doc=Jsoup.connect("https://www.wafabourse.com/marches/actions/r").get();
		    Elements xx = doc.select(".longNameQS a");
			for (Element x : xx) 
			{
				String code=x.attr("href").split("/")[3];
				System.out.println(code);
				proxy.ajouterSocieter(new Societe(code, x.text()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
