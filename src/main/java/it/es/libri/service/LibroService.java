package it.es.libri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.libri.model.Libro;
import it.es.libri.repository.LibroDB;

@Service
public class LibroService {
	
	@Autowired
	LibroDB libri;
	
	public List<Libro> getListaLibri() {
		return libri.findAll(); //Passacarte
	}
}
