package dao;

import java.sql.ResultSet;

import model.Secretaire;

public class SecretaireImpl implements ISecretaire {
	private BD bd = new BD();

	@Override
	public Secretaire findByLoginAndPassword(String login, String password) {
		Secretaire secretaire = null;
		String sql = "SELECT * FROM caissiere c , employes em where c.login=?"
				+ " and c.password=? and c.idEmp=em.idEmploye ";
		try {
			bd.initPrepare(sql);
			bd.getStmt().setString(1, login);
			bd.getStmt().setString(2, password);
			
			ResultSet rs = bd.exSelect();
			
			if(rs.next()) {
				secretaire = new Secretaire(rs.getString("nom"), rs.getInt("idEmploye"),
						rs.getString("prenom"), rs.getString("adresse"), 
						rs.getString("telephone"), 
						rs.getString("email"), password, login, rs.getString("matricule"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return secretaire;
	}

}
