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
	 Elenca (mediante Sysout) gli ordini del cliente 4
	*/
	@Test
	void esOrdiniImp() {

		int idArticolo=4;
		assertTrue(false);
	}

	/*
	 Conta e mostra il numero di ordini a sistema di ogni cliente
	*/
	@Test
	void esCountOrdiniImp() {
		assertTrue(false);
	}

	/*
	 Mostra il numero di articoli in ogni ordine del cliente 3
	*/
	@Test
	void esSumVenduto() {

		int idImpiegato=6;
		assertTrue(false);
		
	}

	/*
	 Mostra il l'utente con il più alto numero di ordini
	*/
	@Test
	void esCountOrdiniAllImp() {
		assertTrue(false);
		
	}









}
