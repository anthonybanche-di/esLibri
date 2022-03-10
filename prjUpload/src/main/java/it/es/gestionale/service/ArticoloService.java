package it.es.gestionale.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

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
	public void importCsv(MultipartFile file){
		
		try {
			
			InputStreamReader isr = new InputStreamReader(file.getInputStream(), "UTF-8"); //Permette di ottenere il flusso di dati
			BufferedReader buffer = new BufferedReader(isr); //Prassi per la lettura del flusso
			/*
			while(buffer.ready()) {
				
				String[] art = buffer.readLine().split(";"); //Otteniamo un'array di stringhe con gli attributi
				
				ArticoloEntity articolo = new ArticoloEntity(art[0], Double.parseDouble(art[1]), art[2], Integer.parseInt(art[3]));
				db.save(articolo);
			
			}
			*/
			
			CsvToBean <ArticoloEntity> csv = new CsvToBeanBuilder(buffer)
					.withSeparator(';')
					.withIgnoreLeadingWhiteSpace(true)
					.withType(ArticoloEntity.class).build();
			List<ArticoloEntity> listaCsv = csv.parse();
			db.saveAll(listaCsv);
					
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

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
