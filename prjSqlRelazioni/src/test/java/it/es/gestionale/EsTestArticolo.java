package it.es.gestionale;

import static org.junit.jupiter.api.Assertions.assertTrue;

import it.es.gestionale.repository.EsempioDB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EsTestArticolo {
	@Autowired
	EsempioDB db;

	/*
	 Elenca (mediante Sysout) gli utenti che hanno ordinato l'articolo
	*/
	@Test
	void esOrdiniImp() {

		int idArticolo=4;
		assertTrue(false);
	}

	/*
	 Conta e mostra il numero di ordini a sistema di ogni articolo
	*/
	@Test
	void esCountOrdiniImp() {
		assertTrue(false);
	}

	/*
	 Mostra la somma del totale venduto di un articolo
	*/
	@Test
	void esSumVenduto() {

		int idImpiegato=6;
		assertTrue(false);
		
	}

	/*
	 Mostra il cliente che ha ordinato il numero maggiore di articolo 2
	*/
	@Test
	void esCountOrdiniAllImp() {
		assertTrue(false);
		
	}









}
