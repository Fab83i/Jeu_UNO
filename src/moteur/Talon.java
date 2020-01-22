package moteur;

import java.util.ArrayList;

import moteur.Carte.Couleur;

public class Talon {
	
	private ArrayList<Carte> cards;
	private Partie p;

	
	
	public Talon(Partie p) {
		cards = new ArrayList<>();
		
		// Ajout des cartes classiques 1 à 9 en double
		for (int i=1 ; i<10 ; i++) {
			cards.add(new CarteClassique(Couleur.Rouge,i));
			cards.add(new CarteClassique(Couleur.Rouge,i));
			cards.add(new CarteClassique(Couleur.Vert,i));
			cards.add(new CarteClassique(Couleur.Vert,i));
			cards.add(new CarteClassique(Couleur.Bleu,i));
			cards.add(new CarteClassique(Couleur.Bleu,i));
			cards.add(new CarteClassique(Couleur.Jaune,i));
			cards.add(new CarteClassique(Couleur.Jaune,i));
			
			
		}
		
		// Ajout des 0 
		
		cards.add(new CarteClassique(Couleur.Bleu,0));
		cards.add(new CarteClassique(Couleur.Rouge,0));
		cards.add(new CarteClassique(Couleur.Jaune,0));
		cards.add(new CarteClassique(Couleur.Vert,0));

		
		
		// Ajout des cartes speciales
		for (int i=1 ; i<3 ; i++) {
			cards.add(new PlusDeux(Couleur.Rouge));
			cards.add(new PlusDeux(Couleur.Bleu));
			cards.add(new PlusDeux(Couleur.Vert));
			cards.add(new PlusDeux(Couleur.Jaune));
			
		}
		
		for (int i=1 ; i<5 ; i++) {
			cards.add(new Joker(Couleur.Noir));
			
				
		}
		
		for (int i=1 ; i<5 ; i++) {
			cards.add(new SuperJoker(Couleur.Noir));
		}
		
		for (int i=1 ; i<3 ; i++) {
			cards.add(new Passer(Couleur.Bleu));
			cards.add(new Passer(Couleur.Jaune));
			cards.add(new Passer(Couleur.Rouge));
			cards.add(new Passer(Couleur.Vert));
		}
		
		for (int i=1 ; i<3 ; i++) {
			cards.add(new Sens(Couleur.Bleu));
			cards.add(new Sens(Couleur.Jaune));
			cards.add(new Sens(Couleur.Rouge));
			cards.add(new Sens(Couleur.Vert));
		}
		
			
		
		
		
	}
	
	public Carte carteAuPif() {
		return cards.get((int) Math.random() * cards.size());
	}
	
	public void remove(Carte tirage) {
		cards.remove(tirage);
	}

	public ArrayList<Carte> getCards() {
		return cards;
	}

}
