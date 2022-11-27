import java.sql.SQLException;
import java.util.ArrayList;

public interface IEtudiant {
	public void add(Etudiant E, IJournal j)throws SQLException;
	public boolean Exists(String email, IJournal j)throws SQLException;
	public boolean Exists(int mat, IJournal j)throws SQLException;
	public ArrayList<Etudiant> getEtudiants() throws SQLException;
}
