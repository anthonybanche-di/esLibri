package it.es.gestionale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import it.es.gestionale.model.UfficioEntity;
import it.es.gestionale.repository.ImpiegatoDB;
import it.es.gestionale.repository.UfficioDB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestLezione {
	@Autowired
	UfficioDB tabellaUfficio;

	@Autowired
	ImpiegatoDB tabellaImpiegato;


	@Test
	@Transactional 
	void contextLoads() {

		List<UfficioEntity> luf=tabellaUfficio.findAll();


		System.out.println("-------");
		for(UfficioEntity u:luf){
			System.out.println(u.toString());
		}
		
		System.out.println("-------");

	}

	

}
