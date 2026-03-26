package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue Villageois" + nomVisiteur );
					System.out.println("Quelle est votre force?");
					int force = Clavier.entrerEntier("");
					controlEmmenager.ajouterGaulois(nomVisiteur,force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {

		    System.out.println("Bienvenue druide " + nomVisiteur);

		    System.out.println("Quelle est votre force ?");
		    int force = Clavier.entrerEntier("");

		    System.out.println("Quelle est la force de potion la plus faible que vous produisez ?");
		    int effetMin = Clavier.entrerEntier("");

		    int effetMax;
		    do {
		        System.out.println("Quelle est la force de potion la plus forte que vous produisez ?");
		        effetMax = Clavier.entrerEntier("");

		        if (effetMax < effetMin) {
		            System.out.println("Attention,vous vous etes trompés de min et max");
		        }

		    } while (effetMax < effetMin);

		    controlEmmenager.ajouterDruide(nomVisiteur, force, effetMin, effetMax);
		}
	}
