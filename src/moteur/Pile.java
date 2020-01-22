package moteur;

import java.util.ArrayList;

public class Pile {
	
	private ArrayList<Carte> cards;
	private Partie p;
	
	public Pile(Partie p) {
		cards = new ArrayList<>();
		this.p = p;
		
	}
	
	public void ajouterPile(Carte tirage) {
		cards.add(tirage);
		
	}
	
	public void remove(Carte tirage) {
		cards.remove(tirage);
	}

	public ArrayList<Carte> getCards() {
		return cards;
	}
	
	

}
