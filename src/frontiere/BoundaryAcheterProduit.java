package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {

		    if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
		        System.out.println("Je suis désolée " + nomAcheteur
		                + " mais il faut être un habitant de notre village pour commercer ici.");
		        return;
		    }

		    String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");

		    Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);

		    if (vendeurs.length == 0) {
		        System.out.println("Désolé, personne ne vend ce produit au marché.");
		        return;
		    }

		    System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
		    for (int i = 0; i < vendeurs.length; i++) {
		        System.out.println((i + 1) + " - " + vendeurs[i]);
		    }

		    int choix = Clavier.entrerEntier("Votre choix :");
		    Gaulois nomVendeur = vendeurs[choix - 1];

		    Etal etal = controlAcheterProduit.choisirEtal(nomVendeur);

		    System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
		    System.out.println("Bonjour " + nomAcheteur);

		    int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");

		    int quantiteAvant = etal.getQuantite();
		    int quantiteVendue = etal.acheterProduit(quantite);

		    if (quantiteAvant == 0) {
		        System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit
		                + ", malheureusement il n'y en a plus !");
		    } else if (quantiteVendue < quantite && quantiteVendue == quantiteAvant) {
		        System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit
		                + ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteVendue
		                + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
		    } else {
		        System.out.println(nomAcheteur + " achète " + quantiteVendue + " " + produit + " à " + nomVendeur);
		    }
		
		
	}
}
