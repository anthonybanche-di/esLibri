package it.es.gestionale;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.transaction.Transactional;

import it.es.gestionale.model.DettaglioEntity;
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
	@Transactional
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
	@Transactional
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

	private double calcoloVenduto(int idImpiegato){
		ImpiegatoEntity impiegato=this.db.getById(idImpiegato);
		double count=0;
		for (OrdineEntity ord : impiegato.getOrdini()) {
			for (DettaglioEntity de : ord.getDettagli()) {
				count += de.getArticolo().getPrezzo()*de.getQuantita();
			}
		}
		return count;
	}


	/*
	 Mostra la somma del totale venduto di un impiegato
	*/
	@Test
	@Transactional
	void esSumVenduto() {

		int idImpiegato=6;
		double somma=this.calcoloVenduto(idImpiegato);
		System.out.println("Somma= "+somma);
		assertEquals(somma, 0);
		
	}

	/*
	 Conta e mostra il numero di ordini a sistema di ogni impiegato
	*/
	@Test
	void esCountOrdiniAllImp() {
		assertTrue(false);
		
	}









}
