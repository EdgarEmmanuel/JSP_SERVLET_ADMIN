package model;

public class RespoCompte extends Employes {
	
	private String login;
	private String password;
	private String matricule;

	public RespoCompte(String nom,int idEmploye, String prenom, String adresse, 
			String telephone, String email,String login , String password , String mat) {
		super(nom,idEmploye, prenom, adresse, telephone, email);
		this.password = password;
		this.login = login;
		this.matricule = mat;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
	
	
	
	
}
