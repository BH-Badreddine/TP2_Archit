
public class MainAppMvc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EtudiantService serv = new EtudiantService();
		serv.setEtudRep(new EtudiantRepository());
		serv.setUnivRep(new UniversiteRepository());
		serv.setJournal(new ScreenJourn());
		
		IViewInscription view = new ViewInscription();
		view.DisplayForm();
		
		ControleurInscription ctrl = new ControleurInscription(view, serv);
		
		
		
	}

}
