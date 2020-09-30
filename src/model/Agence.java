package model;

import java.io.Serializable;

public class Agence implements Serializable {
	private String localisation;
	private String numeroAgence;
	private int idAgence;
	
	public Agence() {
		
	}
	
	public int getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}

	public Agence(int id ,String localisation, String numeroAgence) {
		this.localisation = localisation;
		this.numeroAgence = numeroAgence;
		this.idAgence = id;
	}
	
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getNumeroAgence() {
		return numeroAgence;
	}
	public void setNumeroAgence(String numeroAgence) {
		this.numeroAgence = numeroAgence;
	}
	
	@Override
	public String toString() {
		return "[localisation => "+localisation+","
				+ "numeroAgence=>"+numeroAgence+",idAgence=>"+idAgence+"]";
	}
	
	
}
