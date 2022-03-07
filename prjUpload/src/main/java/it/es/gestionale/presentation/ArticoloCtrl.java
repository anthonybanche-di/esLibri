package it.es.gestionale.presentation;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import it.es.gestionale.model.ArticoloEntity;
import it.es.gestionale.repository.ArticoloDB;
import it.es.gestionale.service.FileService;

@Controller
@RequestMapping("/articolo")
public class ArticoloCtrl {


	@Autowired
	ArticoloDB artdb;

	@Autowired
	FileService fs;

	@GetMapping()
	public String preload(Model model) {
		model.addAttribute("articoloForm", new ArticoloEntity());
		return "articolo_editor";
	}

	@GetMapping("/lista")
	public String list(Model model) {
		model.addAttribute("articoli", artdb.findAll());
		return "articolo_lista";
	}
	
	@PostMapping("/save")
	public String saveArt(Model model, ArticoloEntity articoloForm, @RequestParam(name="image") MultipartFile immagine) {

		if(immagine!=null){
			try{
				String percorso=fs.saveFile("img/articoli", articoloForm.getDescrizione()+immagine.getName(), immagine);
				articoloForm.setImmagine(percorso);
			}catch(IOException e){
				e.printStackTrace();
			}
		}

		artdb.save(articoloForm);
		return "redirect:/articolo/lista";
	}
	

	
}
