package moteur;

import java.util.ArrayList;
import java.util.Scanner;

public class Reel extends Joueur {

	private String prenom;

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Reel(String prenom, int numeroJoueur) {
		super(numeroJoueur);
		this.prenom = prenom;
	}
	
	public void poser(Carte carte, Pile pile) {

		// CAS JOKER
		if (carte instanceof Joker) {

			// CHOIX DE LA COULEUR
			Scanner scanJoker = new Scanner(System.in);
			System.out.println("choisis ta couleur :");
			String choixCouleur = scanJoker.nextLine();
			switch (choixCouleur) {
			case "rouge":
				pile.ajouterPile(new Joker(Couleur.Rouge, 50, true));
				break;
			case "bleu":
				pile.ajouterPile(new Joker(Couleur.Bleu, 50, true));
				break;
			case "jaune":
				pile.ajouterPile(new Joker(Couleur.Jaune, 50, true));
				break;
			case "vert":
				pile.ajouterPile(new Joker(Couleur.Vert, 50, true));
				break;
			}
			getCarteEnMain().remove(carte);
		}

		// CAS SUPERJOKER
		if (carte instanceof SuperJoker) {

			// CHOIX DE LA COULEUR
			Scanner scanSuperJoker = new Scanner(System.in);
			System.out.println("choisis ta couleur :");
			String choixCouleur = scanSuperJoker.nextLine();
			switch (choixCouleur) {
			case "rouge":
				pile.ajouterPile(new SuperJoker(Couleur.Rouge, 50, true));
				break;
			case "bleu":
				pile.ajouterPile(new SuperJoker(Couleur.Bleu, 50, true));
				break;
			case "jaune":
				pile.ajouterPile(new SuperJoker(Couleur.Jaune, 50, true));
				break;
			case "vert":
				pile.ajouterPile(new SuperJoker(Couleur.Vert, 50, true));
				break;
			}
			getCarteEnMain().remove(carte);
		}

		// CAS CARTE AUTRE
		else {
			pile.ajouterPile(carte);
			getCarteEnMain().remove(carte);
		}
	}

	public void jouer(Pile pile, Talon talon, Partie p) {
		Carte hautPile = pile.getCards().get(pile.getCards().size() - 1);
		ArrayList<Carte> carteJouable;
		carteJouable = new ArrayList<Carte>();
		

		// ANALYSE DE LA CARTE PILE
		if (hautPile instanceof CarteSpeciale && ((CarteSpeciale) hautPile).getEffect() == true) {
			if (hautPile instanceof Passer) {
				((Passer) hautPile).setEffect(false);
				return;

			}
			if (hautPile instanceof PlusDeux) {
				pioche(talon);
				pioche(talon);
				((PlusDeux) hautPile).setEffect(false);
				return;
			}
			if (hautPile instanceof SuperJoker) {
				pioche(talon);
				pioche(talon);
				pioche(talon);
				pioche(talon);
				((SuperJoker) hautPile).setEffect(false);
				return;
			}
			if (hautPile instanceof Sens) {
				p.changerSens();
				((Sens) hautPile).setEffect(false);
				return;
			}
		}
		
		// ANALYSE DES CARTES JOUABLES
		for (int x = 0; x < getCarteEnMain().size() - 1; x++) {
			if (p.canPlayThisCard(getCarteEnMain().get(x)) == true) {
				carteJouable.add(getCarteEnMain().get(x));
			}
		}

		if (carteJouable.size() == 0) {
			pioche(talon);
			return;
		}

		System.out.println(carteJouable.toString());
		
		// CHOIX DE LA CARTE A POSER
		Scanner sc = new Scanner(System.in);

		System.out.println("Choisissez une carte : ");
		int choix = sc.nextInt();
		poser(carteJouable.get(choix), pile);

	}

}
