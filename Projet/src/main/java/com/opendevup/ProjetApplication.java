package com.opendevup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.opendevup.metier.OrdreImpl;
import com.opendevup.metier.SocieteImpl;

@SpringBootApplication
//@ComponentScan
@EnableAutoConfiguration
public class ProjetApplication implements CommandLineRunner {
	@Autowired
	private SocieteImpl societe;
	@Autowired
	private OrdreImpl ordre;

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
