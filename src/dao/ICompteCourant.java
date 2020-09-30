package dao;

import model.CompteCourant;

public interface ICompteCourant {
	public int getSoldeCreation();
	public String getNumCompteCourant();
	public int insertC_Courant(CompteCourant compte_courant);
}
