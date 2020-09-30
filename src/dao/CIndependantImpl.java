package dao;

import java.sql.ResultSet;

import model.ClientIndep;

public class CIndependantImpl implements IClientInde {
	BD bd = new BD();

	@Override
	public int insertIndependant(ClientIndep clIndep) {
		String sql = "INSERT INTO clients VALUES(null,?,?,?)";
		int ok1,ok=0;
		try {
			bd.initPrepare(sql);
			bd.getStmt().setString(1,clIndep.getTelephone());
			bd.getStmt().setString(2,clIndep.getEmail());
			bd.getStmt().setString(3,clIndep.getMatricule());
			
			bd.exUpdate();
			ok1 = bd.getLastInsertId(1);
			
			if(ok1!=0) {
				String sql2 = "INSERT INTO client_non_salarie VALUES(null,?,?,?,?,?,?)";
				
				try {
					bd.initPrepare(sql2);
					
					//set the values 
					bd.getStmt().setString(1, clIndep.getPrenom());
					bd.getStmt().setString(2, clIndep.getActiviteClient());
					bd.getStmt().setInt(3, ok1);
					bd.getStmt().setString(4, clIndep.getNom());
					bd.getStmt().setString(5, clIndep.getCni());
					bd.getStmt().setString(6, clIndep.getLocalisation());
					
					ok = bd.exUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ok;
		
	}

	@Override
	public String getMatricule() {
		String sql = "SELECT count(idClient) as num FROM clients "
				+ "WHERE SUBSTR(matricule,1,3)='BCI' ";
		String mat="";
		try {
			bd.initPrepare(sql);
			ResultSet rs = bd.exSelect();
			if(rs.next()) {
				mat+="BCI"+(rs.getInt("num")+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mat;
	}

}
