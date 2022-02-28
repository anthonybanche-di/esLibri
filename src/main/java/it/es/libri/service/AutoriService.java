package it.es.libri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.libri.model.Autore;
import it.es.libri.model.Prodotto;
import it.es.libri.model.Utente;
import it.es.libri.repository.AutoreDB;
import it.es.libri.repository.ProdottiDB;
import it.es.libri.repository.UtentiDB;

@Service
public class AutoriService {
	
	@Autowired
	AutoreDB db;
	
	private String save(Autore autore, boolean add) {
		try {
			Autore saved = db.save(autore);			
			return "Autore [id:"+saved.getId()+"] "+(add?"aggiunto":"modificato");
		}catch (IllegalArgumentException e) {
			return "something went wrong";
		}
	}
	
	public List<Autore> getAll() {
		return db.findAll();
	}

	public Autore getByID(int id) {
		var autore = db.findById(id);
		if(autore.isEmpty())
			return null;
		return autore.get();
	}
	
	public String add(Autore autore) {
		return this.save(autore, true);
	}

	public String update(Autore autore) {
		return this.save(autore, false);
	}
	
	public String remove(Autore autore) {
		try {
			db.delete(autore);
			return "Autore [id:"+autore.getId()+"] eliminato";
		}catch (IllegalArgumentException e) {
			return "something went wrong";
		}
	}
}
