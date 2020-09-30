package model;

public class CompteBloque extends Compte {
	private String dateDeblocage;
	private int solde;

	public CompteBloque(int cleRib, String date, String dateDeblocage, int solde) {
		super(cleRib, date);
		this.dateDeblocage = dateDeblocage;
		this.solde = solde;
	}

	public String getDateDeblocage() {
		return dateDeblocage;
	}

	public void setDateDeblocage(String dateDeblocage) {
		this.dateDeblocage = dateDeblocage;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}
	
	
	
	

	
}
