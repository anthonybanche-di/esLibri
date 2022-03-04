package it.es.gestionale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.es.gestionale.model.EsempioModel;

@Repository
public interface EsempioDB extends JpaRepository<EsempioModel, Integer>{
	
}

