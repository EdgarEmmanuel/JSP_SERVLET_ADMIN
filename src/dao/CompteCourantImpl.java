package dao;

import java.sql.ResultSet;

import model.CompteCourant;
import model.Operations;

public class CompteCourantImpl implements ICompteCourant {
	private BD bd = new BD();
	private IOperations io = new OperationsImpl();

	@Override
	public String getNumCompteCourant() {
		String sql = "SELECT count(comptes.id_compte) as "
				+ "num from comptes WHERE SUBSTR(comptes.num_compte,1,2)='CC'";
		String value="";
		try {
			bd.initPrepare(sql);
			ResultSet rs = bd.exSelect();
			if(rs.next()) {
				value+="CC"+(rs.getInt("num")+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public int insertC_Courant(CompteCourant compte_courant) {
		int ok=0,ok1;
		String mat = getNumCompteCourant();
		String sql = "INSERT INTO comptes VALUES(null,?,?,?,?,?,?)";
		try {
			bd.initPrepare(sql);
			
			//insert ine the table comptes
			bd.getStmt().setString(1,mat);
			bd.getStmt().setInt(2, compte_courant.getCleRib());
			bd.getStmt().setInt(3, compte_courant.getIdClient());
			bd.getStmt().setInt(4, compte_courant.getIdREspoCompte());
			bd.getStmt().setString(5, compte_courant.getDate());
			bd.getStmt().setInt(6, compte_courant.getIdAgence());
			
			bd.exUpdate();
			
			ok1 = bd.getLastInsertId(1);
			
			if(ok1!=0) {
				String sql2 = "INSERT INTO compte_courant VALUES (null,?,?,?,?,?,?)";
				try {
					bd.initPrepare(sql2);
					
					//insert in the table compte_courant
					bd.getStmt().setString(1, compte_courant.getAdresesEmployeur());
					bd.getStmt().setString(2, compte_courant.getNomEmployeur());
					bd.getStmt().setString(3, compte_courant.getRaisonSic());
					bd.getStmt().setInt(4, ok1);
					bd.getStmt().setInt(5, compte_courant.getSolde());
					bd.getStmt().setInt(6, 1);
					
					ok=bd.exUpdate();
					
					//insert in the table operation_comptes
					Operations operation = new Operations("DEPOT", compte_courant.getSolde(),
							compte_courant.getDate());
					operation.setId_Compte_desti(0);
					operation.setId_employe(compte_courant.getIdREspoCompte());
					operation.setIdCompte(ok1);
					
					io.insertOperations(operation);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	
	public int getSoldeCreation() {
		String sql = "SELECT montant from agios where id_agios=1";
		int val=0;
		try {
			bd.initPrepare(sql);
			ResultSet rs = bd.exSelect();
			if(rs.next()) {
				val = rs.getInt("montant");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	

}
