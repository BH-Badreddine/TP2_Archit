package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import InscriptionView.IViewInscription;
import Services.EtudiantService;

public class ControleurInscription {

	private IViewInscription viewInscription;
	private EtudiantService etudService;
	
	public IViewInscription getView() {
		return this.viewInscription;
	}

	public ControleurInscription(IViewInscription viewInscription,EtudiantService etudService) {

		this.viewInscription = viewInscription;
		this.etudService = etudService;

		this.viewInscription.addValiderListener(new ValiderListener());
		this.viewInscription.addAnnulerListener(new AnnulerListener());
	}


	public class ValiderListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			if(viewInscription.champsValides()) {
				
				if(etudService.inscription(Integer.valueOf(viewInscription.Get_Mat()), viewInscription.Get_Name(), viewInscription.Get_Prenom(), viewInscription.Get_email(),viewInscription.Get_pwd(), Integer.valueOf(viewInscription.Get_id_univ()))) {

					viewInscription.DisplayDialog("Inscription r�ussie !");
					viewInscription.Reset_Champs();

				}else {
					viewInscription.DisplayErreur("Inscription non r�ussie !");

				}
			}


		}

	}


	public class AnnulerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			viewInscription.Annuler_Inscription();

		}


	}

}