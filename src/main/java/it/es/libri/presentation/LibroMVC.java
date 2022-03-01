package it.es.libri.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.es.libri.model.Libro;
import it.es.libri.model.Utente;
import it.es.libri.service.LibroService;

@Controller
@RequestMapping("/listaLibri")
public class LibroMVC {
	
	@Autowired
	LibroService srv;

	
	
	@GetMapping
	public String getLibri(Libro l, Model m) {
		
		String titolo = "Lista Libri";
		
		List<Libro> libri = srv.getListaLibri();
		
		m.addAttribute("titolo",titolo);
		m.addAttribute("libri", libri);
		
		return "libri2";
	}
	
	@GetMapping("/updLibro/{id}")
	public String updLibro(@PathVariable ("id") int id,Model m) {
		
		String titolo = "Modifica Libro";
		m.addAttribute("titolo2", titolo);
		
		Libro modificare = srv.getLibroById(id);
		
		m.addAttribute("formLibro",modificare);
	
		return "updateLibro";
	}
	
	@PostMapping("/updLibro")
	public String updLibro(@ModelAttribute("libro") Libro l) {
		srv.updLibro(l);
		return "libri2";
	}
	
	
	
}
