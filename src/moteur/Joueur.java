package moteur;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Joueur {
	
	
	private ArrayList<Carte> carteEnMain = new ArrayList<>();
	private int numeroJoueur;
	
	

	public Joueur(ArrayList<Carte> carteEnMain, int numeroJoueur) {
		
		this.carteEnMain = carteEnMain;
		this.numeroJoueur = numeroJoueur;
	}
	
	

	public Joueur(int numeroJoueur) {
		super();
		this.numeroJoueur = numeroJoueur;
	}



	public int getNumeroJoueur() {
		return numeroJoueur;
	}

	public void setNumeroJoueur(int numeroJoueur) {
		this.numeroJoueur = numeroJoueur;
	}

	public ArrayList<Carte> getCarteEnMain() {
		return carteEnMain;
	}

	public void setCarteEnMain(ArrayList<Carte> carteEnMain) {
		this.carteEnMain = carteEnMain;
	}
	

	
	

	public void pioche (Talon talon) {
		
		Carte carte = talon.carteAuPif();
		carteEnMain.add(carte);
		
		talon.getCards().remove(carte);
	}
	
	public void poser(Carte carte , Pile pile , ArrayList<Carte> carteJouable, int choix) {
		if (carte instanceof Joker || carte instanceof SuperJoker) {
			
			//choix de la couleur
			Scanner scancoul = new Scanner(System.in);
			System.out.println("choisis ta couleur :");
			String choixCouleur = scancoul.nextLine();
			
			if (choixCouleur == "rouge") {
				carteJouable.get(choix).setCouleur(Couleur.Rouge);
			}
			if (choixCouleur == "bleu") {
				carteJouable.get(choix).setCouleur(Couleur.Bleu);
			}
			if (choixCouleur == "jaune") {
				carteJouable.get(choix).setCouleur(Couleur.Jaune);
			}
			if (choixCouleur == "vert") {
				carteJouable.get(choix).setCouleur(Couleur.Vert);
			}
		}
		pile.ajouterPile(carte);
		carteEnMain.remove(carte);
		
	}

	

	
	
	

}
