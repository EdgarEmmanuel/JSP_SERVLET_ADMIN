package dao;

import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

import model.CompteEpargne;

public class CompteEpargneImpl implements ICompteEpargne {
	private BD bd = new BD();

	@Override
	public String getNumAccount() {
		String val ="";
		String sql = "Select count(id_compte) as num from comptes  "
				+ "where SUBSTR(num_compte,1,2)='CE'";
		try {
			bd.initPrepare(sql);
			ResultSet rs = bd.exSelect();
			if(rs.next()) {
				val+="CE"+(rs.getInt("num")+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	@Override
	public int insertCompteEpargne(CompteEpargne ce) {
		int ok=0,ok1;
		String numeroCompte =getNumAccount();
		String sql = "INSERT INTO comptes VALUES(null,?,?,?,?,?,?)";
		try {
			bd.initPrepare(sql);
			bd.getStmt().setString(1,numeroCompte);
			bd.getStmt().setInt(2, ce.getCleRib());
			bd.getStmt().setInt(3, ce.getIdClient());
			bd.getStmt().setInt(4, ce.getIdREspoCompte());
			bd.getStmt().setString(5, ce.getDate());
			bd.getStmt().setInt(6, ce.getIdAgence());
			
			bd.exUpdate();
			ok1 = bd.getLastInsertId(1);
			
			if(ok1!=0) {
				String sql2 = "INSERT INTO compte_epargne VALUES(null,?,?)";
				try {
					bd.initPrepare(sql2);
					bd.getStmt().setInt(1, ok1);
					bd.getStmt().setInt(2, ce.getSolde());
					
					ok=bd.exUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ok;
	}

}
