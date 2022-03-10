package it.es.libri.service;

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

import it.es.libri.model.Editore;
import it.es.libri.repository.EditoreDB;

@Service
public class EditoreService {
	
	@Autowired
	EditoreDB dbEdi;
	
	public List<Editore> getListaEditori() {
		return dbEdi.findAll();	//Passacarte
	}
	
	public Editore saveEditore(Editore e){
		return dbEdi.save(e);
	}

	public void deleteEditore(int id) {
		dbEdi.delete(dbEdi.getById(id));
	}
	
	public Editore getByid(int id) {
		return dbEdi.findById(id).orElse(new Editore());
	}
	
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
			
			CsvToBean <Editore> csv = new CsvToBeanBuilder(buffer)
					.withSeparator(';')
					.withIgnoreLeadingWhiteSpace(true)
					.withType(Editore.class).build();
			List<Editore> listaCsv =csv.parse();
			dbEdi.saveAll(listaCsv);
			
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/* Carica i dati dal database e li mette nel CSV */
	public String exportCsv(){
		final String sep=";";
		final String aCapo="\n";
		final String fileName="file.csv";

		List<Editore> lista=dbEdi.findAll();
		

		try{
			FileWriter csvWriter = new FileWriter(fileName);
			csvWriter.append("nome"+sep+"contatto"+aCapo);

			for(Editore edi:lista){
				csvWriter.append(edi.getNome()+sep+edi.getContatto()+aCapo);
			}

			csvWriter.flush();
			csvWriter.close();

			return fileName;


		}catch(IOException ioe){

		}

		return null;
		
	}

}

