package model;

public class CompteEpargne extends Compte{
	private int solde;
	private int idCompte;
	

	public CompteEpargne( int cleRib, String date,
			int solde) {
		super( cleRib, date);
		this.solde = solde;
	}


	public int getSolde() {
		return solde;
	}


	public void setSolde(int solde) {
		this.solde = solde;
	}


	public int getIdCompte() {
		return idCompte;
	}


	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	
	
	

}
