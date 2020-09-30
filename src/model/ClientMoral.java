package model;

public class ClientMoral extends Client{
	private String nomEntre;
	private String adresseEntreprise;
	private String typeEntreprise;
	private int ninea;
	private int id_client_entreprise;
	private String activite;
	private String matricule ;
	
	

	public String getMatricule() {
		return matricule;
	}



	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}



	public String getActivite(){
		return activite;
	}



	public void setActivite(String activite) {
		this.activite = activite;
	}



	public ClientMoral(String email, String tel, String nomEntre, 
			String adresseEntreprise, String typeEntreprise, int ninea,
			String activite,String matricule) {
		super(email, tel);
		this.nomEntre = nomEntre;
		this.adresseEntreprise = adresseEntreprise;
		this.typeEntreprise = typeEntreprise;
		this.ninea = ninea;
		this.matricule = matricule;
		this.activite = activite;
	}



	public String getNomEntre() {
		return nomEntre;
	}



	public void setNomEntre(String nomEntre) {
		this.nomEntre = nomEntre;
	}



	



	public String getAdresseEntreprise() {
		return adresseEntreprise;
	}



	public void setAdresseEntreprise(String adresseEntreprise) {
		this.adresseEntreprise = adresseEntreprise;
	}



	public String getTypeEntreprise() {
		return typeEntreprise;
	}



	public void setTypeEntreprise(String typeEntreprise) {
		this.typeEntreprise = typeEntreprise;
	}



	public int getNinea() {
		return ninea;
	}



	public void setNinea(int ninea) {
		this.ninea = ninea;
	}



	public int getId_client_entreprise() {
		return id_client_entreprise;
	}



	public void setId_client_entreprise(int id_client_entreprise) {
		this.id_client_entreprise = id_client_entreprise;
	}
	
	




}
