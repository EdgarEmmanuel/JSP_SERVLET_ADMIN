package dao;

import model.ClientS;

public interface IClientS {
	public ClientS findByIdClient(int id);
	public int insertSalarie(ClientS clients);
	public int findClienytByMat(String matricule);
	
}
