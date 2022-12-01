package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DBConnection;
import Journal.IJournal;
import Pack.TypePackage;
import Services.Universite;

public class UniversiteRepository implements IUniversite {
	
	@Override
	public Universite GetById(int universityId, IJournal j) {
		
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
		j.outPut_Msg("LogBD : début recherche de id université dans la base de donnée");
		
		String sql = "SELECT * FROM universite WHERE id_universite="+ universityId;
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		TypePackage p = null;
		try {
			p = TypePackage.valueOf(rs.getString(3));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Universite u = null;
		try {
			u = new Universite (rs.getInt(1),rs.getString(2),p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		j.outPut_Msg("LogBD : université récupérée");
		
		//connect.close();
		return u;	
	
		
	}	
	
}
