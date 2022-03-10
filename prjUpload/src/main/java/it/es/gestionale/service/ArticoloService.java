package it.es.gestionale.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.es.gestionale.model.ArticoloEntity;
import it.es.gestionale.repository.ArticoloDB;

@Service
public class ArticoloService {
	
	 @Autowired
	ArticoloDB db;
	
	// public List<EsempioModel> getListaEditori() {
	// 	return dbEdi.findAll();	//Passacarte
	// }
	
	// public EsempioModel saveEditore(EsempioModel e){
	// 	return dbEdi.save(e);
	// }

	// public void deleteEditore(int id) {
	// 	dbEdi.delete(dbEdi.getById(id));
	// }
	
	// public EsempioModel getByid(int id) {
	// 	return dbEdi.findById(id).orElse(new EsempioModel());
	// }

	/* Carica i dati da un CSV e limette nel database */
	//public int inportCsv(){

	//}

	/* Carica i dati dal database e li mette nel CSV */
	public String exportCsv(){
		final String sep=";";
		final String aCapo="\n";
		final String fileName="file.csv";

		List<ArticoloEntity> lista=db.findAll();
		

		try{
			FileWriter csvWriter = new FileWriter(fileName);
			csvWriter.append("descrizione"+sep+"prezzo"+sep+"categoria"+sep+"rimanenza"+aCapo);

			for(ArticoloEntity art:lista){
				csvWriter.append(art.getDescrizione()+sep+art.getPrezzo()+sep+art.getCategoria()+sep+art.getRimanenza()+aCapo);
			}

			csvWriter.flush();
			csvWriter.close();

			return fileName;


		}catch(IOException ioe){

		}

		return null;
		





	}

}
