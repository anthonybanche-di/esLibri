package it.es.libri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.es.libri.model.Utente;

@Repository
public interface UtentiDB extends JpaRepository<Utente, Integer>{
	
	
}

