package it.es.libri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.libri.model.Libro;
import it.es.libri.repository.LibroDB;

@Service
public class LibroService {

	@Autowired
	LibroDB db;

	public List<Libro> getListaLibri() {
		return db.findAll(); //Passacarte
	}

	public Libro getLibroById(int id) {
		return db.getById(id);
	}

	public Libro addLibro(Libro l) {

		if(!l.getTitolo().equals("")) {
			if(Double.valueOf(l.getPrezzo()) != 0) {
				if(Integer.valueOf(l.getPagine()) != 0) {
					return db.save(l);
				}
			}
		}
		return null;
	}

	public Libro updLibro(Libro l) {
		return db.save(l);
	}

	public void deleteLibroById(int id) {
		db.deleteById(id);
	}
}
