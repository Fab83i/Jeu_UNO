package moteur;

import java.util.ArrayList;
import java.util.Collections;

import moteur.Couleur;

public class Talon {
	
	private ArrayList<Carte> cards;
	private Partie p;

	
	
	public Talon(Partie p) {
		cards = new ArrayList<>();
		
		
		// Ajout des cartes classiques 1 à 9 en double
		for (int i=1 ; i<10 ; i++) {
			cards.add(new CarteClassique(Couleur.Rouge,i,i));
			cards.add(new CarteClassique(Couleur.Rouge,i,i));
			cards.add(new CarteClassique(Couleur.Vert,i,i));
			cards.add(new CarteClassique(Couleur.Vert,i,i));
			cards.add(new CarteClassique(Couleur.Bleu,i,i));
			cards.add(new CarteClassique(Couleur.Bleu,i,i));
			cards.add(new CarteClassique(Couleur.Jaune,i,i));
			cards.add(new CarteClassique(Couleur.Jaune,i,i));
			
			
		}
		
		// Ajout des 0 
		
		cards.add(new CarteClassique(Couleur.Bleu,0,0));
		cards.add(new CarteClassique(Couleur.Rouge,0,0));
		cards.add(new CarteClassique(Couleur.Jaune,0,0));
		cards.add(new CarteClassique(Couleur.Vert,0,0));

		
		
		// Ajout des cartes speciales
		for (int i=1 ; i<3 ; i++) {
			cards.add(new PlusDeux(Couleur.Rouge, 20));
			cards.add(new PlusDeux(Couleur.Bleu, 20));
			cards.add(new PlusDeux(Couleur.Vert, 20));
			cards.add(new PlusDeux(Couleur.Jaune, 20));
			
		}
		
		for (int i=1 ; i<5 ; i++) {
			cards.add(new Joker(Couleur.Noir, 50));		
		}
		
		for (int i=1 ; i<5 ; i++) {
			cards.add(new SuperJoker(Couleur.Noir, 50));
		}
		
		for (int i=1 ; i<3 ; i++) {
			cards.add(new Passer(Couleur.Bleu, 20));
			cards.add(new Passer(Couleur.Jaune, 20));
			cards.add(new Passer(Couleur.Rouge, 20));
			cards.add(new Passer(Couleur.Vert, 20));
		}
		
		for (int i=1 ; i<3 ; i++) {
			cards.add(new Sens(Couleur.Bleu, 20));
			cards.add(new Sens(Couleur.Jaune, 20));
			cards.add(new Sens(Couleur.Rouge, 20));
			cards.add(new Sens(Couleur.Vert, 20));
		}
		
		Collections.shuffle(cards);
		//System.out.println("taille talon "+ (int) (Math.random()* cards.size()) );
		
	}
	
	public Carte carteAuPif() {
		//System.out.println("nombre aleatoire "+(int) (Math.random() * cards.size()));
		return cards.get((int) Math.random() * cards.size());
	}
	
	public void remove(Carte tirage) {
		cards.remove(tirage);
	}

	public ArrayList<Carte> getCards() {
		return cards;
	}

}
