package dao;

import java.sql.*;

public class BD {
    // pour la connexion
    private Connection cnx;
    // pour les requetes select
    private ResultSet rs;
    // pour les requetes preparees
    private PreparedStatement pstm;
    // pour les requetes (Insert,Update,Delete)
    private int ok;

    private void getConnect(){
        //banque_peuple
        String url="jdbc:mysql://127.0.0.1:3306/banque_peuple";
        String user ="root";
        String pwd = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx= DriverManager.getConnection(url,user,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void initPrepare(String sql){
        try {
            getConnect();
            pstm=cnx.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ResultSet exSelect(){
        rs=null;
        try {
            rs=pstm.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }

    public int exUpdate(){
        try {
            ok=pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    public int getLastInsertId(int a) {
        int id=0;
        try {
        	//pstm is a PreparedStatement
            rs = pstm.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(a);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return id;
    }

    public void CloseConnect() {
        try {
            if (cnx != null)
                cnx.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public PreparedStatement getStmt() {
        return  pstm;
    }
}

