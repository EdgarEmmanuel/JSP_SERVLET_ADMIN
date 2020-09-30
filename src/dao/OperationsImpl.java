package dao;

import model.Operations;

public class OperationsImpl implements IOperations {
	private BD bd = new BD();

	@Override
	public int insertOperations(Operations operation) {
		int ok=0;
		String sql = "INSERT INTO operation_comptes VALUES(null,?,?,?,?,?,?)";
		try {
			bd.initPrepare(sql);
			bd.getStmt().setInt(1, operation.getId_employe());
			bd.getStmt().setInt(2, operation.getId_Compte_desti());
			bd.getStmt().setString(3, operation.getTypeOPeration());
			bd.getStmt().setDouble(4, operation.getMontantOperation());
			bd.getStmt().setString(5, operation.getDateOperation());
			bd.getStmt().setInt(6, operation.getId_Compte_desti());
			
			ok = bd.exUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

}
