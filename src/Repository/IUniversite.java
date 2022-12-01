package Repository;
import java.sql.SQLException;

import Journal.IJournal;
import Services.Universite;

public interface IUniversite {
	public Universite GetById(int universityId,  IJournal j) throws SQLException;
}
