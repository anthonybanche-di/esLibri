package it.es.libri.integration;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.es.libri.model.Editore;
import it.es.libri.service.EditoreService;

@RestController
@RequestMapping("/api/editore")
@SessionAttributes("editore")
public class EditoreREST {

	@Autowired
	EditoreService srv;
	
	@DeleteMapping("/{id}")
	public String deleteEditore(@PathVariable("id") int id, HttpSession session) {

		try {
			srv.deleteEditore(id);
			session.setAttribute("esito", "Cancellazione avvenuta correttamente.");
			return "Cancellazione avvenuta correttamente.";
		} catch(Exception e) {
			session.setAttribute("esito", "Qualcosa è andato storto: " + e.getMessage() + ".");
			return "Qualcosa è andato storto: " + e.getMessage() + ".";
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Editore> findEditore(@PathVariable("id") int id) {
		
		try {
			Editore x = srv.getByid(id);
			return ResponseEntity.ok(x);
		}catch (Exception e) {
			return ResponseEntity.ok(new Editore());
		}
	}
	

//	@PostMapping("/saveCanzone")
//	public String salvaModifica (@RequestParam(value = "isUpdate", required = true) boolean isUpdate, 
//								 @RequestBody Utente newCanzone
//			){
//		
//		
//		if(srv.salvaModifica(newCanzone, isUpdate)) return "Salvataggio effettuato";
//		else return "Errore nel passaggio della richiesta";
//
//		
//	}
//	
//	@DeleteMapping("/deleteCanzone")
//	public String deleteCanzone (@RequestParam(value = "id", required = true) int id) {
//		
//		if(srv.deleteCanzone(id)) return "Cancellazione effettuata";
//		else return "Errore durante la cancellazione";
//		
//	}
//	
//	public Utente getCanzone (@PathVariable(value = "id") int id) {
//		
//	return srv.getOne(id);
//	}
//	
	
	
	
}
