package it.es.libri.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.es.libri.model.Libro;
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
}
