package it.es.gestionale;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.LinkedHashMap;

import it.es.gestionale.model.ImpiegatoEntity;
import it.es.gestionale.model.OrdineEntity;
import it.es.gestionale.repository.ImpiegatoDB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EsTestImpiegato {
	@Autowired
	ImpiegatoDB db;

	/*
	 Elenca (mediante Sysout) gli ordini di un impiegato 
	*/
	@Test
	void esOrdiniImp() {
		int idImpiegato=4;
		ImpiegatoEntity impiegato=this.db.getById(idImpiegato);
		for (OrdineEntity ordine:impiegato.getOrdini()) {
			System.out.println(ordine);
		}
		
		assertTrue(true);
	}

	/*
	 Conta e mostra il numero di ordini a sistema di ogni impiegato
	*/
	@Test
	void esCountOrdiniImp() {
		var impiegati = this.db.findAll();
		var numOrdini = new HashMap<Integer,Integer>();
		int[] valoriAttesi = {0,0,0,5,0,0,0,2,0};
		
//		int numOrdImp4=0;
//		int numOrdImp8=0;
		for (ImpiegatoEntity impiegato : impiegati )
			numOrdini.put(impiegato.getId(), impiegato.getOrdini().size());
//				
//				switch (impiegato.getId()) {
//					case 4:
//					numOrdImp4++;
//					break;
//					case 8:
//					numOrdImp8++;
//					break;
//				}
		
		for (var check : numOrdini.entrySet()) {
			System.out.println("numero oridini impiegato ["+check.getKey()+"] = "+check.getValue());
			assertTrue(check.getValue()==valoriAttesi[check.getKey()-1]);			
		}
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
