package model;

public class ClientS extends Client {
	private String nom ;
	private String prenom;
	private String nom_entreprise;
	private String localisation;
	private String cni;
	private String profession;
	

	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public ClientS(String email,  String tel, String nom, 
			String prenom, String nom_entreprise,
			String localisation, String cni,String profession) {
		super(email, tel);
		this.nom = nom;
		this.prenom = prenom;
		this.nom_entreprise = nom_entreprise;
		this.localisation = localisation;
		this.cni = cni;
		this.profession=profession;
	}


	public String getNom() {
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


	public String getNom_entreprise() {
		return nom_entreprise;
	}


	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}


	public String getLocalisation() {
		return localisation;
	}


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}


	public String getCni() {
		return cni;
	}


	public void setCni(String cni) {
		this.cni = cni;
	}

}
