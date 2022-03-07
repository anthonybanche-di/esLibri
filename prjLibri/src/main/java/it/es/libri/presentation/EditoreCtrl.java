package it.es.libri.presentation;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import it.es.libri.model.Editore;
import it.es.libri.service.EditoreService;
import it.es.libri.service.FileService;

@Controller
@RequestMapping("/lista-editori")
@SessionAttributes("editore")
public class EditoreCtrl {

	@Autowired
	EditoreService srv; // Autowired consente a Spring di capire se trattare un oggetto come un transient o un singleton

	@Autowired
	FileService fs;

	@GetMapping
	public String getEditori(Model model, HttpSession session) {

		String titolo = "Elenco degli editori";

		model.addAttribute("titolo", titolo);
		model.addAttribute("editori", srv.getListaEditori());
		// Passiamo la lista mediante il "passacarte" del service

		if(session.getAttribute("esito") != null) {
			model.addAttribute("esito", session.getAttribute("esito"));
			session.setAttribute("esito", null);
		}

		return "editori";
	}

	@PostMapping("/modify-editore")
	public String modifyEditore(Editore editore, Model model, HttpSession session, @RequestParam(name="img") MultipartFile immagine) {
		
		if(immagine!=null){
			
			try {
				String percorso=fs.saveFile("img/editori", editore.getImmagine()+immagine.getName(), immagine);
				editore.setImmagine(percorso);
				srv.saveEditore(editore);
				session.setAttribute("esito", "Editore numero " + editore.getId() + " modificato correttamente.");
			} catch(Exception e) {
				session.setAttribute("esito", "Qualcosa è andato storto: " + e.getMessage() + ".");
			}
		}
		return "redirect:/lista-editori";	
	}
	
	//	@PostMapping("/add-editore")
	//	public String addEditore(Model model, String nome, String contatto, String immagine, HttpSession session) {
	//		
	//		try {
	//			session.setAttribute("esito", "Editore numero " + srv.saveEditore(new Editore(nome, contatto, immagine)).getId() + " inserito correttamente.");
	//			
	//		} catch(Exception e) {
	//			session.setAttribute("esito", "Qualcosa è andato storto: " + e.getMessage() + ".");
	//		}
	//		
	//		return "redirect:/lista-editori";
	//	}


	//	@PostMapping("/save")
	//	public String saveArt(Model model, Editore editoreForm, ) {
	//
	//		if(immagine!=null){
	//			try{
	//				String percorso=fs.saveFile("img/editori", editoreForm.getImmagine()+immagine.getName(), immagine);
	//				editoreForm.setImmagine(percorso);
	//			}catch(IOException e){
	//				e.printStackTrace();
	//			}
	//		}
	//
	//		srv.save(editoreForm);
	//		return "redirect:/articolo/lista";
	//	}
}
