package it.es.libri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.es.libri.model.Autore;

@Repository
public interface AutoreDB extends JpaRepository<Autore, Integer>{	
}

