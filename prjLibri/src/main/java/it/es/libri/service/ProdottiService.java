package it.es.libri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.libri.model.Prodotto;
import it.es.libri.model.Utente;
import it.es.libri.repository.ProdottiDB;
import it.es.libri.repository.UtentiDB;

@Service
public class ProdottiService {
	
	@Autowired
	ProdottiDB db;
	
	public List<Prodotto> getListaProdotti() {
		
		return db.getAll(); //Passacarte
		
	}

}
