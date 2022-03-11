package it.es.libri.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import it.es.libri.model.Autore;
import it.es.libri.repository.AutoreDB;

@Service
public class AutoriService {

	@Autowired
	AutoreDB db;

	private String save(Autore autore, boolean add) {
		try {
			Autore saved = db.save(autore);
			return "Autore [id:" + saved.getId() + "] " + (add ? "aggiunto" : "modificato");
		} catch (IllegalArgumentException e) {
			return "something went wrong";
		}
	}

	public List<Autore> getAll() {
		return db.findAll();
	}

	public Autore getByID(int id) {
		var autore = db.findById(id);
		if (autore.isEmpty())
			return null;
		return autore.get();
	}

	public String add(Autore autore) {
		return this.save(autore, true);
	}

	public String update(Autore autore) {
		return this.save(autore, false);
	}

	public String remove(Autore autore) {
		try {
			db.delete(autore);
			return "Autore [id:" + autore.getId() + "] eliminato";
		} catch (IllegalArgumentException e) {
			return "something went wrong";
		}
	}

	public String exportCsv() {
		final String sep = ";";
		final String aCapo = System.lineSeparator();
		final String fileName = "file.csv";

		List<Autore> lista = db.findAll();

		try {
			FileWriter csvWriter = new FileWriter(fileName);

			var line = String.join(sep, new String[] { "nome", "cognome", "nazionalita" });

			csvWriter.append(line+aCapo);

			for (var autore : lista)
				csvWriter.append(autore.toCsv() + aCapo);

			csvWriter.flush();
			csvWriter.close();

			return fileName;

		} catch (IOException ioe) {

		}

		return null;
	}

	public void importCsv(MultipartFile file) {
		try {
			
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(file.getInputStream(), "UTF-8"));
			
			CsvToBean<Autore> csv = new CsvToBeanBuilder<Autore>(buffer)
					.withSeparator(';')
					.withIgnoreLeadingWhiteSpace(true)
					.withType(Autore.class).build();

			var listaCsv = csv.parse();
			db.saveAll(listaCsv);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
