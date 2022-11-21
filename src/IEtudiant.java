import java.sql.SQLException;

public interface IEtudiant {
	public void add(Etudiant E, IJournal j)throws SQLException;
	public boolean Exists(String email, IJournal j)throws SQLException;
	public boolean Exists(int mat, IJournal j)throws SQLException;
}
