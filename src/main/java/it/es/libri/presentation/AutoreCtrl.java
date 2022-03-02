package it.es.libri.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.es.libri.model.Autore;
import it.es.libri.service.AutoriService;

@Controller
@RequestMapping("/autore")
public class AutoreCtrl {

	@Autowired
	AutoriService srv;
	
	@GetMapping("/list")
	public String get(Model model) {		
		model.addAttribute("autori", srv.getAll());
		return "autori";
	}
	
	@GetMapping()
	public String getByID(@RequestParam(value="id", required=true) int autoreId, Model model) {
				
		var autore = srv.getByID(autoreId);
		if(autore!=null)
			model.addAttribute("autori", srv.getAll());
		else
			model.addAttribute("error", "#404 autore [id: "+autoreId+"] not found");		
		
		return "autore";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute Autore autore, Model model) {	
		autore.setId(-1);
		model.addAttribute("message", srv.add(autore));
		return this.get(model);
	}
	
	@PutMapping("/upd")
	public String update(@ModelAttribute Autore autore, Model model) {	
		model.addAttribute("message", srv.update(autore));
		return this.get(model);
	}
	
	@DeleteMapping()
	public String delete(@RequestParam(value="id", required=true) int autoreId, Model model) {
		var autore = new Autore();
		autore.setId(autoreId);
		model.addAttribute("message", this.srv.remove(autore));
		return this.get(model);
	}
}
