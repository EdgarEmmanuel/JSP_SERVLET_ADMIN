package dao;

import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

import model.ClientS;

public class ClientSImpl implements IClientS {
	BD bd = new BD();
			
	
	public String  getMatS() {
		String sql = "SELECT count(idClient) FROM clients"
				+ " where SUBSTR(matricule,1,3)='BPS'";
		String mat ="";
		try {
			bd.initPrepare(sql);
			ResultSet rs = bd.exSelect();
			if(rs.next()) {
				mat+="BPS"+(rs.getInt(1)+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mat;
	}
	
	public int findClienytByMat(String matricule) {
		String sql = "SELECT idClient FROM clients WHERE matricule=?";
		int idClient=0;
		try {
			bd.initPrepare(sql);
			bd.getStmt().setString(1, matricule);
			
			ResultSet rs = bd.exSelect();
			
			if(rs.next()){
				idClient = rs.getInt("idClient");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return idClient;
	}

	@Override
	public int insertSalarie(ClientS clients) {
		int ok;
		int ok1=0;
		String sql = "INSERT INTO clients VALUES(null,?,?,?)";
		
		//set the matricule of the client 
		String mat = getMatS();
		try {
			bd.initPrepare(sql);
			bd.getStmt().setString(1, clients.getTelephone());
			bd.getStmt().setString(2, clients.getEmail());
			bd.getStmt().setString(3, mat);
			
			bd.exUpdate();
			ok=bd.getLastInsertId(1);
			
			if(ok!=0) {
				String sql2="INSERT INTO client_salarie VALUES(null,?,?,?,?,?,?,?)";
				
				try {
					bd.initPrepare(sql2);
					bd.getStmt().setString(1,clients.getPrenom() );
					bd.getStmt().setString(2,clients.getProfession() );
					bd.getStmt().setString(3,clients.getNom_entreprise() );
					bd.getStmt().setString(4,clients.getLocalisation() );
					bd.getStmt().setInt(5, ok);
					bd.getStmt().setString(6,clients.getNom() );
					bd.getStmt().setString(7,clients.getCni() );
					
					ok1 = bd.exUpdate();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok1;
	}

	@Override
	public ClientS findByIdClient(int id) {
		ClientS cls = null;
		String sql = "SELECT * FROM client_salarie cl , clients c "
				+ "WHERE c.idClient=cl.idClient and cl.idClient=?";
		try {
			bd.initPrepare(sql);
			bd.getStmt().setInt(1, id);
			ResultSet rs = bd.exSelect();
			
			if(rs.next()) {
				cls = new ClientS(rs.getString("email"), rs.getString("telephone"),
						rs.getString("nom"), 
						rs.getString("prenom"), rs.getString("nom_entreprise"),
						rs.getString("adresse_entreprise"), rs.getString("cni"),
						rs.getString("profession"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cls;
	}

}
