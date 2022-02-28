package it.es.libri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.libri.model.Prodotto;
import it.es.libri.model.Utente;
import it.es.libri.repository.ProdottiDB;
import it.es.libri.repository.UtentiDB;

@Service
public class CarrelloService {
	
	@Autowired
	UtentiDB dbUte;
	
	@Autowired
	ProdottiDB dbProd;
	
	public List<Prodotto> getCarrello(int id) {
		
		return dbUte.getById(id).getCarrello(); 
		
	}
	
	public String addCarrello(int idUtente, int idProdotto){
		
		Prodotto p = dbProd.getById(idProdotto);
		List<Prodotto> carrello = getCarrello(idUtente);
		carrello.add(p);
		
		//getCarrello(idUtente).add(dbProd.getById(idProdotto));
		
		return "Prodotto aggiunto al carrello";
		
	}
	
	public String removeCarrello(int idUtente, int idProdotto) {
		
		Prodotto p = dbProd.getById(idProdotto);
		List<Prodotto> carrello = getCarrello(idUtente);
		carrello.remove(p);
		
		return "Prodotto rimossso";
	}
	
	
}
