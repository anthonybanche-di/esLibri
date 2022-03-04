package it.es.gestionale.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordine")
public class OrdineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//cliente

	//impiegato

	//dettaglio per articoli

	@Column(name="data")
	private Date data;

	@Column(name="consegna")
	private String consegna;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getConsegna() {
		return consegna;
	}

	public void setConsegna(String consegna) {
		this.consegna = consegna;
	}
	
	
}
