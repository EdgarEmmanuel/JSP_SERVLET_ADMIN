package dao;

import java.sql.ResultSet;

import model.Agence;

public class AgenceImpl implements IAgence {
	BD bd = new BD();

	@Override
	public Agence getAgenceByIdResponsable(int id) {
		String sql = "SELECT idagencEmploye FROM employes WHERE idEmploye=?";
		Agence ag = null;
		try {
			bd.initPrepare(sql);
			bd.getStmt().setInt(1, id);
			ResultSet rs = bd.exSelect();
			if(rs.next()) {
				
				int idAgence = rs.getInt("idagencEmploye");
				
				String sql2 = "SELECT * FROM agences where id_agence=?";
				
				try {
					bd.initPrepare(sql2);
					bd.getStmt().setInt(1, idAgence);
					
					ResultSet rs2 = bd.exSelect();
					if(rs2.next()) {
						ag = new Agence();
						ag.setIdAgence(rs2.getInt("id_agence"));
						ag.setLocalisation(rs2.getString("adresse"));
						ag.setNumeroAgence(rs2.getString("numero_agence"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ag;
	}
	
	

}
