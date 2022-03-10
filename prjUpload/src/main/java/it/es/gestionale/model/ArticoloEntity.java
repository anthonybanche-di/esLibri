package it.es.gestionale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "articolo")
public class ArticoloEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="descrizione")
	@CsvBindByName
	private String descrizione;
	
	@Column(name="prezzo")
	@CsvBindByName
	private double prezzo;

	@Column(name="categoria")
	@CsvBindByName
	private String categoria;

	@Column(name="rimanenza")
	@CsvBindByName
	private int rimanenza;

	@Column(name="immagine")
	private String immagine;

	public ArticoloEntity() {
		super();
	}

	public ArticoloEntity(String descrizione, double prezzo, String categoria, int rimanenza) {
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.categoria = categoria;
		this.rimanenza = rimanenza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getRimanenza() {
		return rimanenza;
	}

	public void setRimanenza(int rimanenza) {
		this.rimanenza = rimanenza;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	
	
}
