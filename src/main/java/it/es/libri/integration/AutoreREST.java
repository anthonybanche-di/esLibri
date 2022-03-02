package it.es.libri.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import it.es.libri.model.Autore;
import it.es.libri.model.Utente;
import it.es.libri.service.AutoriService;

@RestController
@RequestMapping("/api")
public class AutoreREST {

	@Autowired
	AutoriService srv;
	
	@GetMapping("/autori")
	public List<Autore> getAll(Model m) {
		return srv.getAll();
	}
	
	@GetMapping("/autore")
	public Autore getById(@RequestParam int id, Model m) {
		return srv.getByID(id);
	}
	
	@PostMapping("/create_autore")
	public String add(@ModelAttribute Autore autore) {
		return srv.add(autore);
	}

	@PostMapping("/update_autore")
	public String update(@ModelAttribute Autore autore) {
		return srv.update(autore);
	}
	
	@DeleteMapping("/delete_autore")
	public String deleteProdotto(@RequestParam int id , Utente u) {
		var autore = new Autore();
		autore.setId(id);
		return this.srv.remove(autore);
	}	
}
