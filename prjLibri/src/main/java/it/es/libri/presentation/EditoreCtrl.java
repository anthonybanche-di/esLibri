package it.es.libri.presentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
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
	
	@GetMapping("/export")
	public ResponseEntity downloadEditore(String param) throws IOException {

		String outFile = srv.exportCsv();

		if (outFile != null) {
			File download = new File(outFile);
			InputStreamResource resource = new InputStreamResource(new FileInputStream(download));

			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "exportedEditor.csv")
					.contentLength(download.length())
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(resource);
		}

		return null;
	}

	@PostMapping("/import")
	public ResponseEntity insertCSVEditore(@RequestPart("fileCSV") MultipartFile file) {
		
		srv.importCsv(file);
		return ResponseEntity.ok().build();
		
	}
}


