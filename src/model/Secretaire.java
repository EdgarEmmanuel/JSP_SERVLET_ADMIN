package model;

public class Secretaire extends Employes {
	private String password ;
	private String login;
	private String matricule;

	public Secretaire(String nom, int idEmploye, String prenom, String adresse, String telephone, String email,
			String password, String login, String matricule) {
		super(nom, idEmploye, prenom, adresse, telephone, email);
		this.password = password;
		this.login = login;
		this.matricule = matricule;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
	
	

}
