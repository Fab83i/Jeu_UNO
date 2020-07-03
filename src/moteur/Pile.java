package moteur;

import java.util.ArrayList;

public class Pile {
	
	private ArrayList<Carte> cards;
	
	
	public Pile() {
		cards = new ArrayList<>();	
	}
	// AJOUTE LA CARTE JOUEE
	public void ajouterPile(Carte tirage) {
		cards.add(tirage);	
	}
	// PAS UTILE
	public void remove(Carte tirage) {
		cards.remove(tirage);
	}

	// DONNE LES ELEMENTS DE LA PILE
	public ArrayList<Carte> getCards() {
		return cards;
	}
	
	

}
