package it.es.libri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.es.libri.model.Libro;

@Repository
public interface LibroDB extends JpaRepository<Libro, Integer> {

}
