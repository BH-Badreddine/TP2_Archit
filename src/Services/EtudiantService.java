package Services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Journal.IJournal;
import Journal.ScreenJourn;
import Pack.AbstractFactory;
import Pack.ConcreteCreator;
import Pack.IPackage;
import Repository.IEtudiant;
import Repository.IUniversite;

public class EtudiantService {
	
		private IEtudiant StudRep;
		private IUniversite UnivRep;
		private IJournal j;
		
		public void setEtudRep(IEtudiant StudRep) {
			this.StudRep = StudRep;
		}
		public void setUnivRep(IUniversite UnivRep) {
			this.UnivRep = UnivRep;
		}
		public void setJournal(IJournal j) {
			this.j = j;
		}
		public IJournal getJournal() {
			return this.j;
		}
		public IEtudiant getStudRep() {
			return this.StudRep;
		}
		
	public boolean inscription (int matricule, String nom, String prénom, String email,String pwd, int id_universite) throws SQLException	
	{
		
	    Etudiant stud = new Etudiant(matricule, nom, prénom, email,pwd,id_universite);
	    Universite univ= UnivRep.GetById(id_universite, j);
	    
	    j.outPut_Msg("Log: début de l'opération d'ajout de l'étudiant avec matricule "+matricule);
	    
	    AbstractFactory AF = new ConcreteCreator();
	    IPackage pack = AF.getPackage(univ.getPack());
	    stud.setNbLivreMensuel_Autorise(pack.getNbrLivreAutorise());
	     
		 StudRep.add(stud, j);
		 
		 j.outPut_Msg("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+matricule);
		 return true;
	    
		
	}
	
	public void ajouterBonus() throws SQLException {
		ArrayList<Etudiant> etudiants = StudRep.getEtudiants();
		
		for(Etudiant e : etudiants) {
			Universite univ = UnivRep.GetById(e.getId_universite(), new ScreenJourn());
			e.giveBonus(univ);
		}
	}
	
	

public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}
