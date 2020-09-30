package model;

public abstract class Client {
	private String id;
	private String telephone;
	private String email;
	private String matricule ;
	
	
	public Client(String email  , String tel) {
		this.telephone = tel;
		this.email = email;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
