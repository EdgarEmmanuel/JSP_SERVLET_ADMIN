package dao;

import java.sql.ResultSet;

import model.ClientMoral;

public class ClientMoralImpl implements IClientMoral {
	private BD bd = new BD();
	
	public String getMatricule() {
		String sql = "SELECT count(idClient) as num FROM clients "
				+ "WHERE SUBSTR(matricule,1,3)='BCM' ";
		String mat="";
		try {
			bd.initPrepare(sql);
			ResultSet rs = bd.exSelect();
			if(rs.next()) {
				mat+="BCM"+(rs.getInt("num")+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mat;
	}

	@Override
	public int insertClientMoral(ClientMoral clm) {
		String sql="INSERT INTO clients VALUES(null,?,?,?)";
		int ok1,ok=0,okentr;
		try {
			bd.initPrepare(sql);
			
			//insert in the table clients 
			bd.getStmt().setString(1, clm.getTelephone());
			bd.getStmt().setString(2, clm.getEmail());
			bd.getStmt().setString(3, clm.getMatricule());
			bd.exUpdate();
			ok1=bd.getLastInsertId(1);
			
			
			//insert in te table for all entreprise moral 
			String sql_entre = "INSERT INTO entreprise_moral VALUES(null,?)";
			bd.initPrepare(sql_entre);
			bd.getStmt().setString(1, clm.getNomEntre());
			okentr=bd.exUpdate();		
			
			
			if(ok1!=0 && okentr!=0){
				String sql2 = "INSERT client_moral VALUES(null,?,?,?,?,?,?)";
				try {
					bd.initPrepare(sql2);
					bd.getStmt().setString(1, clm.getTypeEntreprise());
					bd.getStmt().setString(2,clm.getActivite());
					bd.getStmt().setInt(3, ok1);
					bd.getStmt().setString(4, clm.getNomEntre());
					bd.getStmt().setString(5, clm.getAdresseEntreprise());
					bd.getStmt().setInt(6, clm.getNinea());
					
					ok = bd.exUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

}
