package metier;

import java.sql.ResultSet;

import dao.BD;
import model.RespoCompte;

public class RespImpl implements IRespoCompte {
	BD bd = new BD();

	@Override
	public RespoCompte getRespoByLog(String log, String pass){
		String sql = "SELECT * FROM responsable_compte WHERE login=? and password=?";
		RespoCompte res = null;
		try {
			bd.initPrepare(sql);
			bd.getStmt().setString(1, log);
			bd.getStmt().setString(2, pass);
			ResultSet rs = bd.exSelect();
			if(rs.next()){
				
				//get the variable in the table respo_compte
				String pas = rs.getString("password");
				String mat = rs.getString("matricule");
				int idEmp = rs.getInt("idEmp");
				String login = rs.getString("login");
				
				String sql2 = "SELECT * FROM employes where idEmploye = ?";
				
				try {
					bd.initPrepare(sql2);
					bd.getStmt().setInt(1, idEmp);
					ResultSet rs2 = bd.exSelect();
					
					if(rs2.next()) {
						res = new RespoCompte(rs2.getString("nom"),
								rs2.getInt("idEmploye"),
								rs2.getString("prenom"),
								rs2.getString("adresse"), 
								rs2.getString("telephone"), 
								rs2.getString("email"), 
								login, pas, mat);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		//System.out.println(res);
		return res;
	}

}
