
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EtudiantRepository implements IEtudiant {
	
	@Override
	public void add(Etudiant E, IJournal j) throws SQLException
	{
		
		DBConnection BD= DBConnection.getInstance();
		
		Connection connect= BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "INSERT INTO etudiant VALUES (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
			j.outPut_Msg("log : ajout dans la BD réussi de l'étudiant  du Matricule" + E.getMatricule());
			}else if (rs == 0){
				j.outPut_Msg("log : Echec de l'ajout dans la BD de l'étudiant  du Matricule" + E.getMatricule());
			}
		//connect.close();
	 }

    @Override
	public boolean Exists(String email, IJournal j) throws SQLException	
	{
		DBConnection BD= DBConnection.getInstance();
		Connection connect= BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "SELECT * FROM etudiant WHERE email='"+ email+"'";
		boolean rs = stmt.executeQuery(sql).next();
		
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
	public boolean Exists(int mat, IJournal j) throws SQLException	
	{
		DBConnection BD= DBConnection.getInstance();
		Connection connect= BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "SELECT * FROM etudiant WHERE matricule='"+ mat+"'";
		boolean rs = stmt.executeQuery(sql).next();
		
		if (rs){
			j.outPut_Msg("logBD--- :etudiant avec ce matricule existe déja dans la BD  " + mat);
			//connect.close();
			return true;
			}
		j.outPut_Msg("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
		//connect.close();
		return false;
	}

}
