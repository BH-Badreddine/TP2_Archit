package Repository;
import java.sql.SQLException;
import java.util.ArrayList;

import Journal.IJournal;
import Services.Etudiant;

public interface IEtudiant {
	public void add(Etudiant E, IJournal j);
	public boolean Exists(String email, IJournal j);
	public boolean Exists(int mat, IJournal j);
	public ArrayList<Etudiant> getEtudiants();
}
