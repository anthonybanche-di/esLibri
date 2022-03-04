package it.es.gestionale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import it.es.gestionale.repository.EsempioDB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestLezione {
	@Autowired
	EsempioDB db;


	@Test
	void contextLoads() {
	}

	

}
