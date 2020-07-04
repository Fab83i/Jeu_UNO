package moteur;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import moteur.Couleur;

import javax.imageio.ImageIO;

public class Talon {

	private ArrayList<Carte> cards;

	public Talon() {
		cards = new ArrayList<>();

		// AJOUT DES CARTES CLASSIQUES 
		for (int i = 1; i < 10; i++) {

			cards.add(new CarteClassique(Couleur.Rouge, i, i));
			cards.add(new CarteClassique(Couleur.Rouge, i, i));
			cards.add(new CarteClassique(Couleur.Vert, i, i));
			cards.add(new CarteClassique(Couleur.Vert, i, i));
			cards.add(new CarteClassique(Couleur.Bleu, i, i));
			cards.add(new CarteClassique(Couleur.Bleu, i, i));
			cards.add(new CarteClassique(Couleur.Jaune, i, i));
			cards.add(new CarteClassique(Couleur.Jaune, i, i));

		}

		// AJOUT DES 0

		cards.add(new CarteClassique(Couleur.Bleu, 0, 0));
		cards.add(new CarteClassique(Couleur.Rouge, 0, 0));
		cards.add(new CarteClassique(Couleur.Jaune, 0, 0));
		cards.add(new CarteClassique(Couleur.Vert, 0, 0));

		// AJOUT CARTES SPECIALES
		for (int i = 1; i < 3; i++) {
			cards.add(new PlusDeux(Couleur.Rouge, 20, true));
			cards.add(new PlusDeux(Couleur.Bleu, 20, true));
			cards.add(new PlusDeux(Couleur.Vert, 20, true));
			cards.add(new PlusDeux(Couleur.Jaune, 20, true));

		}

		for (int i = 1; i < 5; i++) {
			cards.add(new Joker(Couleur.Noir, 50, true));
		}

		for (int i = 1; i < 5; i++) {
			cards.add(new SuperJoker(Couleur.Noir, 50, true));
		}

		for (int i = 1; i < 3; i++) {
			cards.add(new Passer(Couleur.Bleu, 20, true));
			cards.add(new Passer(Couleur.Jaune, 20, true));
			cards.add(new Passer(Couleur.Rouge, 20, true));
			cards.add(new Passer(Couleur.Vert, 20, true));
		}

		for (int i = 1; i < 3; i++) {
			cards.add(new Sens(Couleur.Bleu, 20, true));
			cards.add(new Sens(Couleur.Jaune, 20, true));
			cards.add(new Sens(Couleur.Rouge, 20, true));
			cards.add(new Sens(Couleur.Vert, 20, true));
		}

		// MELANGE DES CARTES DU TALON
		Collections.shuffle(cards);

	}

	// TIRAGE D'UNE CARTE
	public Carte carteAuPif() {
		return cards.get((int) Math.random() * cards.size());
	}

	// ENLEVEMENT D'UNE CARTE
	public void remove(Carte tirage) {
		cards.remove(tirage);
	}

	public ArrayList<Carte> getCards() {
		return cards;
	}

}
