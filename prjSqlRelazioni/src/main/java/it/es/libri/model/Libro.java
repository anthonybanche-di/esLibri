package it.es.libri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="titolo", length = 50, nullable = false)
	private String titolo;
	@Column(name="pagine", nullable = false)
	private int pagine;
	@Column(name="prezzo", nullable = false)
	private double prezzo;
	
	public Libro() {
	}

	public Libro(int id, String titolo, int pagine, double prezzo) {
		this.id = id;
		this.titolo = titolo;
		this.pagine = pagine;
		this.prezzo = prezzo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getPagine() {
		return pagine;
	}
	public void setPagine(int pagine) {
		this.pagine = pagine;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
}
