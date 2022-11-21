import java.sql.SQLException;

public interface IUniversite {
	public Universite GetById(int universityId,  IJournal j) throws SQLException;
}
