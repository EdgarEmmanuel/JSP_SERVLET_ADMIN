package model;

public class Operations {
	private int id_operation;
	private int id_employe;
	private int idCompte;
	private String typeOPeration;
	private double montantOperation;
	private String dateOperation;
	private int id_Compte_desti;
	
	
	public Operations(String typeOPeration, double montantOperation, String dateOperation) {
		this.typeOPeration = typeOPeration;
		this.montantOperation = montantOperation;
		this.dateOperation = dateOperation;
	}
	
	
	public int getId_operation() {
		return id_operation;
	}
	public void setId_operation(int id_operation) {
		this.id_operation = id_operation;
	}
	public int getId_employe() {
		return id_employe;
	}
	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public String getTypeOPeration() {
		return typeOPeration;
	}
	public void setTypeOPeration(String typeOPeration) {
		this.typeOPeration = typeOPeration;
	}
	public double getMontantOperation() {
		return montantOperation;
	}
	public void setMontantOperation(double montantOperation) {
		this.montantOperation = montantOperation;
	}
	public String getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}
	public int getId_Compte_desti() {
		return id_Compte_desti;
	}
	public void setId_Compte_desti(int id_Compte_desti) {
		this.id_Compte_desti = id_Compte_desti;
	}
	
	
	
	
	
	
	
	
	
	
	
}
