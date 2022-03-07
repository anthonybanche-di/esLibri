package it.es.libri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity // -> Lo stereotipo entity identifica le classi che rappresentano delle tabelle di database
@Table(name = "autore") //  -> E' il nome della tabella che viene collegata a questa classe
public class Autore {

	@Id // -> Serve per dire che il campo id è la chiave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // -> Serve per dire che è AUTO INCREMENT
	private int id;
	
	@Column(length = 40)
	private String nome;
	
	@Column(length = 50)
	private String cognome;
	
	@Column(length = 2)
	private String nazionalita;
	
	@Column(name="immagine")
	private String immagine;

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public Autore() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Autore(String nome, String cognome, String nazionalita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalita = nazionalita;
	}

	@Override
	public String toString() {
		return "Autore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", nazionalita=" + nazionalita + "]";
	}
	
}
