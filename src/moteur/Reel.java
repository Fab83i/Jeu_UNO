package moteur;

import java.util.ArrayList;
import java.util.Scanner;

public class Reel extends Joueur {

	private String prenom;

	// RECUPERE LE PRENOM DU JOUEUR
	public String getPrenom() {
		return prenom;
	}

	// DEFINIE LE PRENOM DU JOUEUR
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Reel(String prenom, int numeroJoueur) {
		super(numeroJoueur);
		this.prenom = prenom;
	}

	// PERMET AU JOUEUR DE POSER UNE CARTE LORSQUE C'EST POSSIBLE
	public void poser(Carte carte, Pile pile) {

		// CAS JOKER
		if (carte instanceof Joker) {

			// CHOIX DE LA COULEUR
			Scanner scanJoker = new Scanner(System.in);
			System.out.println("choisis ta couleur (entre 1 et 4) :");
			String choixCouleur = scanJoker.nextLine();
			switch (choixCouleur) {
			case "1":
				pile.ajouterPile(new Joker(Couleur.Rouge, 50, true));
				break;
			case "2":
				pile.ajouterPile(new Joker(Couleur.Bleu, 50, true));
				break;
			case "3":
				pile.ajouterPile(new Joker(Couleur.Jaune, 50, true));
				break;
			case "4":
				pile.ajouterPile(new Joker(Couleur.Vert, 50, true));
				break;
			}
			getCarteEnMain().remove(carte);
			return;
		}

		// CAS SUPERJOKER
		if (carte instanceof SuperJoker) {

			// CHOIX DE LA COULEUR
			Scanner scanSuperJoker = new Scanner(System.in);
			System.out.println("choisis ta couleur (entre 1 et 4) :");
			String choixCouleur = scanSuperJoker.nextLine();
			switch (choixCouleur) {
			case "1":
				pile.ajouterPile(new SuperJoker(Couleur.Rouge, 50, true));
				break;
			case "2":
				pile.ajouterPile(new SuperJoker(Couleur.Bleu, 50, true));
				break;
			case "3":
				pile.ajouterPile(new SuperJoker(Couleur.Jaune, 50, true));
				break;
			case "4":
				pile.ajouterPile(new SuperJoker(Couleur.Vert, 50, true));
				break;
			}
			getCarteEnMain().remove(carte);
			return;
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
		for (int x = 0; x < getCarteEnMain().size(); x++) {
			if (p.canPlayThisCard(getCarteEnMain().get(x)) == true) {
				carteJouable.add(getCarteEnMain().get(x));
			}
		}

		// PIOCHE SI AUCUNE CARTE N'EST JOUABLE
		if (carteJouable.size() == 0) {
			pioche(talon);
			return;
		}

		// AFFICHAGE DES CARTES EN MAIN
		System.out.println(" Vos cartes sont : ");
		for (int x = 0; x < getCarteEnMain().size(); x++) {
			if (getCarteEnMain().get(x) instanceof CarteClassique) {
				System.out.println(getCarteEnMain().get(x).getCouleur() + " " + getCarteEnMain().get(x).toString()
						+ " numero " + ((CarteClassique) getCarteEnMain().get(x)).getNumero());
			} else {
				System.out.println(getCarteEnMain().get(x).getCouleur() + " " + getCarteEnMain().get(x).toString());
			}
		}

		// AFFICHAGES DES CARTES JOUABLES
		System.out.println(carteJouable.toString());

		// CHOIX DE LA CARTE A POSER
		Scanner sc = new Scanner(System.in);

		System.out.println("Choisissez une carte : ");
		int choix = sc.nextInt();
		poser(carteJouable.get(choix), pile);

	}

}
