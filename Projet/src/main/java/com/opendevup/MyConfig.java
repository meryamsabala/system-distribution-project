package com.opendevup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.opendevup.rmi.BourseRmiRemote;

@Configuration
public class MyConfig {
	
	//Deploiement du WebService
	
	
	@Bean
	public SimpleJaxWsServiceExporter getJWS(){
		SimpleJaxWsServiceExporter  exporter =new SimpleJaxWsServiceExporter ();
		exporter.setBaseAddress("http://localhost:8089/bourse");
		return exporter;
	}
	//Deploiement du service RMI
   @Bean
	public RmiServiceExporter getRmiService(ApplicationContext ctx){
		RmiServiceExporter exporter=new RmiServiceExporter();
	    exporter.setService(ctx.getBean("myRmiService"));
		exporter.setRegistryPort(1099);
		exporter.setServiceName("BK");
		exporter.setServiceInterface(BourseRmiRemote.class);
		return exporter;
	}
	
	


}
