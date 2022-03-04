package it.es.gestionale;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.es.gestionale.model.ArticoloEntity;
import it.es.gestionale.model.DettaglioEntity;
import it.es.gestionale.model.OrdineEntity;
import it.es.gestionale.repository.ArticoloDB;
import it.es.gestionale.repository.DettaglioDB;
import it.es.gestionale.repository.OrdineDB;
import it.es.gestionale.repository.UfficioDB;

@SpringBootTest
class EsTestArticolo {
	
	@Autowired
	ArticoloDB dbArt;

	@Autowired
	DettaglioDB dbDet;
	
	@Autowired
	OrdineDB dbOr;

	/*
	 Elenca (mediante Sysout) gli utenti che hanno ordinato l'articolo
	*/
	@Test
	void esOrdiniImp() {
		
		List<DettaglioEntity> dettagli = dbDet.findAll();
		
		for(DettaglioEntity dettaglio : dettagli) {
			if(dettaglio.getArticolo().getId() == 4) System.out.println(dettaglio.getOrdine().getClienteId());
		}
		
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
