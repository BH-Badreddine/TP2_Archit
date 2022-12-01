package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.DBConnection;
import Journal.IJournal;
import Services.Etudiant;

public class EtudiantRepository implements IEtudiant {
	
	@Override
	public void add(Etudiant E, IJournal j) 
	{
		
		DBConnection BD = null;
		try {
			BD = DBConnection.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection connect= BD.getConn();
		
		Statement stmt = null;
		try {
			stmt = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "INSERT INTO etudiant VALUES (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = 0;
		try {
			rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (rs == 1){
			j.outPut_Msg("log : ajout dans la BD réussi de l'étudiant  du Matricule" + E.getMatricule());
			}else if (rs == 0){
				j.outPut_Msg("log : Echec de l'ajout dans la BD de l'étudiant  du Matricule" + E.getMatricule());
			}
		//connect.close();
	 }

    @Override
	public boolean Exists(String email, IJournal j)
	{
		DBConnection BD = null;
		try {
			BD = DBConnection.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connect= BD.getConn();
		
		Statement stmt = null;
		try {
			stmt = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM etudiant WHERE email='"+ email+"'";
		boolean rs = false;
		try {
			rs = stmt.executeQuery(sql).next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (rs){
			j.outPut_Msg("logBD--- :email existe dans la BD  " + email);
			//connect.close();
			return true;
			}
		j.outPut_Msg("logBD--- : email n'existe pas " + email);	
		//connect.close();
		return false;
	}
	
    @Override
	public boolean Exists(int mat, IJournal j)	
	{
		DBConnection BD = null;
		try {
			BD = DBConnection.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connect= BD.getConn();
		
		Statement stmt = null;
		try {
			stmt = connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM etudiant WHERE matricule='"+ mat+"'";
		boolean rs = false;
		try {
			rs = stmt.executeQuery(sql).next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (rs){
			j.outPut_Msg("logBD--- :etudiant avec ce matricule existe déja dans la BD  " + mat);
			//connect.close();
			return true;
			}
		j.outPut_Msg("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
		//connect.close();
		return false;
	}
    
    //Retourner tous les étudiants inscris   : matricule, String nom, String prenom, String email,String pwd, int id_universite
    @Override
    public ArrayList<Etudiant> getEtudiants() {
    	
    	ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
    	
    	DBConnection BD = null;
		try {
			BD = DBConnection.getInstance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connect= BD.getConn();
		
		Statement stmt = null;
		try {
			stmt = connect.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "SELECT * FROM etudiant";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while(rs.next()) {
				Etudiant e = new Etudiant(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),null,rs.getInt(7));
				etudiants.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return etudiants;
    }

}
