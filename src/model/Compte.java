package model;

import java.io.Serializable;

public class Compte implements Serializable{
	private int cleRib;
	private String date;
	private int idClient;
	private int idAgence;
	private int idREspoCompte;
	
	public Compte( int cleRib, String date) {
		super();
		this.cleRib = cleRib;
		this.date = date;
	}

	public int getCleRib() {
		return cleRib;
	}

	public void setCleRib(int cleRib) {
		this.cleRib = cleRib;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}

	public int getIdREspoCompte() {
		return idREspoCompte;
	}

	public void setIdREspoCompte(int idREspoCompte) {
		this.idREspoCompte = idREspoCompte;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
