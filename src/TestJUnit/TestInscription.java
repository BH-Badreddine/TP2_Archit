package TestJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Journal.MultiJourn;
import Journal.ScreenJourn;
import Repository.EtudiantRepository;
import Repository.UniversiteRepository;
import Services.EtudiantService;

class TestInscription {
	
	EtudiantService serv;
	@BeforeEach
	void setUp() throws Exception {
		serv=new EtudiantService();
		serv.setEtudRep(new EtudiantRepository());
		serv.setUnivRep(new UniversiteRepository());
		serv.setJournal(new ScreenJourn());
	}

	@Test
	void test() throws SQLException {
		boolean response = serv.inscription(10, "Bengaid", "Badro", "test@gmail.com","*****", 1);
		assertEquals(true,response);
	}

}
