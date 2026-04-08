package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		controlPrendreEtal.verifierIdentite(nomVendeur);
		
	}

	private void installerVendeur(String nomVendeur) {
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
	    int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");

	    int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);

	    if (numeroEtal != -1) {
	        System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n" + numeroEtal);
	    }

}
}