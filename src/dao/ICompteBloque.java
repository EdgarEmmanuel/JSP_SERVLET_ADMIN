package dao;

import model.CompteBloque;

public interface ICompteBloque {
	public String getMatricule();
	public CompteBloque verifyIfCompteExist(String numCompte);
	public int insertCompteBloque(CompteBloque compte_bloque);
}
