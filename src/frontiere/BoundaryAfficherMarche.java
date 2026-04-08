package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infos = controlAfficherMarche.donnerInfosMarche();

	    if (infos.length == 0) {
	        System.out.println("Le marché est vide, revenez plus tard.");
	        return;
	    }

	    System.out.println(nomAcheteur + ", vous trouverez au marché :");

	    int i = 0;
	    while (i < infos.length) {
	        String vendeur = infos[i++];
	        String quantite = infos[i++];
	        String produit = infos[i++];

	        System.out.println("- " + vendeur + " qui vend " + quantite + " " + produit);
	    }


	}
}
