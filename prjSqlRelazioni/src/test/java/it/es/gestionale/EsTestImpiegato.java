package it.es.gestionale;

import static org.junit.jupiter.api.Assertions.assertTrue;

import it.es.gestionale.repository.EsempioDB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GestionaleApplicationTests {
	@Autowired
	EsempioDB db;

	/*
	 Elenca (mediante Sysout) gli ordini di un impiegato 
	*/
	@Test
	void esOrdiniImp() {

		int idImpiegato=4;
		assertTrue(false);
	}

	/*
	 Conta e mostra il numero di ordini a sistema di ogni impiegato
	*/
	@Test
	void esCountOrdiniImp() {
		assertTrue(false);
	}

	/*
	 Mostra la somma del totale venduto di un impiegato
	*/
	@Test
	void esSumVenduto() {

		int idImpiegato=6;
		assertTrue(false);
		
	}

	/*
	 Conta e mostra il numero di ordini a sistema di ogni impiegato
	*/
	@Test
	void esCountOrdiniAllImp() {
		assertTrue(false);
		
	}









}
