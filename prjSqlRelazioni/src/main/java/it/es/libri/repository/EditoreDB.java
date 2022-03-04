package it.es.libri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.es.libri.model.Editore;

@Repository
public interface EditoreDB extends JpaRepository<Editore, Integer>{
	
}

