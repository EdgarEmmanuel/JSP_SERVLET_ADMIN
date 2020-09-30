package model;

public class CompteCourant extends Compte{
	private String nomEmployeur;
	private String adresesEmployeur;
	private String raisonSic;
	private int solde;

	public CompteCourant(int cleRib, String date, String nomEmployeur,
			String adresesEmployeur, String raisonSic,
			int solde) {
		super(cleRib, date);
		this.nomEmployeur = nomEmployeur;
		this.adresesEmployeur = adresesEmployeur;
		this.raisonSic = raisonSic;
		this.solde = solde;
	}

	public String getNomEmployeur() {
		return nomEmployeur;
	}

	public void setNomEmployeur(String nomEmployeur) {
		this.nomEmployeur = nomEmployeur;
	}

	public String getAdresesEmployeur() {
		return adresesEmployeur;
	}

	public void setAdresesEmployeur(String adresesEmployeur) {
		this.adresesEmployeur = adresesEmployeur;
	}

	public String getRaisonSic() {
		return raisonSic;
	}

	public void setRaisonSic(String raisonSic) {
		this.raisonSic = raisonSic;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

}
