import java.sql.SQLException;
import java.sql.*;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        //Attention!!!!Il faut démarrer Wampserver pour que la connection marche
		EtudiantService serv=new EtudiantService();
		try {
			serv.inscription(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx", 1);
			
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/egybest","root","");
			//System.out.println("success");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
