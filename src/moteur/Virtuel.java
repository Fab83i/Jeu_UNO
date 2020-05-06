package moteur;

import java.util.ArrayList;

import java.util.Scanner;

public class Virtuel extends Joueur{
	
	public Virtuel( int numeroJoueur) {
		super(numeroJoueur);
		
	}
	
	// METHODE PERMETTANT AU JOUEUR VIRTUEL DE JOUER LORSQU'IL PEUT
	public void jouer(Pile pile, Talon talon, Partie p) {
		Carte hautPile = pile.getCards().get(pile.getCards().size()-1);
		ArrayList<Carte> carteJouable;
		carteJouable = new ArrayList<Carte>();
		int choix = 0;
		
		// ANALYSE CARTE PILE
		if(hautPile instanceof CarteSpeciale && ((CarteSpeciale) hautPile).getEffect() == true) {
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
		
		// ANALYSE CARTEJOUABLE
		for (int x = 0 ; x<getCarteEnMain().size()-1; x++) {
			if(p.canPlayThisCard(getCarteEnMain().get(x)) == true) {
				carteJouable.add(getCarteEnMain().get(x));
			}
		}
		if (carteJouable.size() == 0) {
			pioche(talon);
			return;
		}
		System.out.println("VIRTUEL" + carteJouable.toString());
		
		// CHOIX DE LA CARTE A POSER
		for (int x = 0; x < carteJouable.size(); x++) {
			if (carteJouable.get(x).getPoints() > carteJouable.get(choix).getPoints()) {
				choix = x;
			}
		}
		poser(carteJouable.get(choix), pile);

		
	}

	@Override
	public void poser(Carte carte, Pile pile) {

		// CAS JOKER
		if (carte instanceof Joker) {

			// CHOIX DE LA COULEUR
			int choixCouleur = (int)Math.random() * 3 + 1;
			switch (choixCouleur) {
			case 1:
				pile.ajouterPile(new Joker(Couleur.Rouge, 50, true));
				break;
			case 2:
				pile.ajouterPile(new Joker(Couleur.Bleu, 50, true));
				break;
			case 3:
				pile.ajouterPile(new Joker(Couleur.Jaune, 50, true));
				break;
			case 4:
				pile.ajouterPile(new Joker(Couleur.Vert, 50, true));
				break;
			}
			getCarteEnMain().remove(carte);
			return;
		}

		// CAS SUPERJOKER
		if (carte instanceof SuperJoker) {

			// CHOIX DE LA COULEUR
			int choixCouleur = (int)Math.random() * 3 + 1;
			switch (choixCouleur) {
			case 1:
				pile.ajouterPile(new SuperJoker(Couleur.Rouge, 50, true));
				break;
			case 2:
				pile.ajouterPile(new SuperJoker(Couleur.Bleu, 50, true));
				break;
			case 3:
				pile.ajouterPile(new SuperJoker(Couleur.Jaune, 50, true));
				break;
			case 4:
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
	
	

}
