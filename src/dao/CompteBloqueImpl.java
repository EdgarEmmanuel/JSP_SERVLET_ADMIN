package dao;

import java.sql.ResultSet;

import model.CompteBloque;

public class CompteBloqueImpl implements ICompteBloque {
	private BD bd = new BD();
	private IOperations ioperation = new OperationsImpl();

	@Override
	public String getMatricule() {
		String mat ="";
		String sql = "SELECT count(id_compte) as num "
				+ "FROM comptes where num_compte like '%CB%'";
		try {
			bd.initPrepare(sql);
			ResultSet rs = bd.exSelect();
			if(rs.next()) {
				mat+="CB"+(rs.getInt("num")+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mat;
	}

	@Override
	public int insertCompteBloque(CompteBloque compte_bloque) {
		int ok=0 , ok1,ok2=0;
		String sql = "INSERT INTO comptes VALUES(null,?,?,?,?,?,?)";
		String mat = getMatricule();
		try {
			bd.initPrepare(sql);
			
			bd.getStmt().setString(1,mat);
			bd.getStmt().setInt(2, compte_bloque.getCleRib());
			bd.getStmt().setInt(3, compte_bloque.getIdClient());
			bd.getStmt().setInt(4, compte_bloque.getIdREspoCompte());
			bd.getStmt().setString(5, compte_bloque.getDate());
			bd.getStmt().setInt(6, compte_bloque.getIdAgence());
			
			bd.exUpdate();
			ok1 = bd.getLastInsertId(1);
			
			if(ok1!=0) {
				String sql2 = "INSERT INTO compte_bloque VALUES(?,null,?,?)";
				
				try {
					bd.initPrepare(sql2);
					bd.getStmt().setString(1, compte_bloque.getDateDeblocage());
					bd.getStmt().setInt(2, ok1);
					bd.getStmt().setInt(3, compte_bloque.getSolde());
					
					ok= bd.exUpdate();
					
					if(ok!=0) {
						String sql3 = "INSERT INTO operation_comptes VALUES(null,?,?,?,?,?,?)";
						
						try {
							bd.initPrepare(sql3);
							bd.getStmt().setInt(1, compte_bloque.getIdREspoCompte());
							bd.getStmt().setInt(2, ok1);
							bd.getStmt().setString(3, "DEPOT");
							bd.getStmt().setInt(4, compte_bloque.getSolde());
							bd.getStmt().setString(5, compte_bloque.getDate());
							bd.getStmt().setInt(6, 0);
							
							ok2 = bd.exUpdate();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok2;
	}

	@Override
	public CompteBloque verifyIfCompteExist(String numCompte) {
		CompteBloque compte_bloque = null;
		String sql = "SELECT * FROM comptes c , compte_bloque cb "
				+ "where c.num_compte=? and c.id_compte = cb.id_compte";
		try {
			bd.initPrepare(sql);
			bd.getStmt().setString(1, numCompte);
			
			ResultSet rs = bd.exSelect();
			
			if(rs.next()) {
				//set the data for the account locked 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compte_bloque;
	}

}
