package model;

public class ClientIndep extends Client {
	private String nom;
	private String prenom;
	private String localisation;
	private String cni;
	private String activiteClient;
	private String matricule;

	public ClientIndep(String email, String tel, String nom,
			String prenom, String localisation, String cni,
			String activiteClient,String matricule) {
		super(email, tel);
		this.nom = nom;
		this.prenom = prenom;
		this.localisation = localisation;
		this.cni = cni;
		this.matricule = matricule;
		this.activiteClient = activiteClient;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
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

	public String getActiviteClient() {
		return activiteClient;
	}

	public void setActiviteClient(String activiteClient) {
		this.activiteClient = activiteClient;
	}
	
	



}
