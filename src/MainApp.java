import java.sql.*;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        //Attention!!!!Il faut démarrer Wampserver pour que la connection marche
		
		EtudiantService serv=new EtudiantService();
		serv.setEtudRep(new EtudiantRepository());
		serv.setUnivRep(new UniversiteRepository());
		serv.setJournal(new MultiJourn());
		MultiJourn jTemp = (MultiJourn)serv.getJournal();
		jTemp.addJournal(new ScreenJourn());
		jTemp.addJournal(new FileJourn());
		jTemp.addJournal(new ScreenDetailJourn());
		serv.setJournal(jTemp);
		
		try {
			serv.inscription(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx", 1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
