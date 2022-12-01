package Main;
import java.sql.*;

import Journal.FileJourn;
import Journal.MultiJourn;
import Journal.ScreenDetailJourn;
import Journal.ScreenJourn;
import Repository.EtudiantRepository;
import Repository.UniversiteRepository;
import Services.EtudiantService;

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
		
		int matricule = 2;
		String email = "guen@gmail.com";
		
		try {
			if (!serv.getStudRep().Exists(matricule,serv.getJournal()) && !serv.getStudRep().Exists(email, serv.getJournal()))
		    {
				serv.inscription(matricule, "Guendouziiiii", "wassila", email,"xxxx", 1);
		    }
			serv.ajouterBonus();
		    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
