package it.es.libri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.libri.model.Editore;
import it.es.libri.repository.EditoreDB;

@Service
public class EditoreService {
	
	@Autowired
	EditoreDB dbEdi;
	
	public List<Editore> getListaEditori() {
		return dbEdi.findAll();	//Passacarte
	}
	
	public Editore saveEditore(Editore e){
		return dbEdi.save(e);
	}

	public void deleteEditore(int id) {
		dbEdi.delete(dbEdi.getById(id));
	}
	
	public Editore getByid(int id) {
		return dbEdi.findById(id).orElse(new Editore());
	}

}

