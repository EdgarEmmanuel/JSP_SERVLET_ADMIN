package model;

import java.io.Serializable;

public class Employes implements Serializable{
	protected String nom ;
	protected String prenom;
	protected String adresse;
	protected String telephone;
	protected String email;
	protected int idEmploye;
	
	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public Employes(String nom,int idEmploye ,String prenom, String adresse, String telephone, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.idEmploye = idEmploye;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[nom =>"+nom+",prenom=>"+prenom+",adresse=>"+adresse+""
				+ ",telephone=>"+telephone+",email=>"+email+",idEmploye=>"+idEmploye+"]";
	}
	
	public String getNom(){
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
