package it.es.libri.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.es.libri.model.Libro;
import it.es.libri.repository.LibroDB;

@Service
public class LibroService {

	@Autowired
	LibroDB db;

	@Autowired
	FileService fs;

	public List<Libro> getListaLibri() {
		return db.findAll(); //Passacarte
	}

	public Libro getLibroById(int id) {
		return db.getById(id);
	}

	public Libro addLibro(Libro l,MultipartFile img) throws IOException {
		if(img != null ){
			try{
				String percorso = fs.saveFile("img/articoli", l.getTitolo()+img.getName(), img);
				l.setImmagine(percorso);
			}catch(IOException e){
				e.printStackTrace();
			}
		}


		if(!l.getTitolo().equals("")) {
			if(Double.valueOf(l.getPrezzo()) != 0) {
				if(Integer.valueOf(l.getPagine()) != 0) {
						return db.save(l);
				}
			}
		}
		return null;
	}

	public Libro updLibro(Libro l) {
		return db.save(l);
	}

	public void deleteLibroById(int id) {
		db.deleteById(id);
	}
}
