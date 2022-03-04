package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.EsempioModel;
import it.es.gestionale.repository.EsempioDB;

@Service
public class EsempioService {
	
	@Autowired
	EsempioDB dbEdi;
	
	public List<EsempioModel> getListaEditori() {
		return dbEdi.findAll();	//Passacarte
	}
	
	public EsempioModel saveEditore(EsempioModel e){
		return dbEdi.save(e);
	}

	public void deleteEditore(int id) {
		dbEdi.delete(dbEdi.getById(id));
	}
	
	public EsempioModel getByid(int id) {
		return dbEdi.findById(id).orElse(new EsempioModel());
	}

}
