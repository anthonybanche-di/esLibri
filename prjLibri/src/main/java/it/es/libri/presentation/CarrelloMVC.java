package it.es.libri.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.es.libri.model.Utente;

@Controller
@RequestMapping("/carrello")
@SessionAttributes("utente")
public class CarrelloMVC {

	@GetMapping
	public String get(Utente utente, Model model) {
		if (utente.getEmail()==null) {
			return "redirect:/login";
		}return "carrello";
	}
	
	
	
}
