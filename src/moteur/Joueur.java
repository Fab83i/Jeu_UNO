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
	
	public void poser(Carte carte , Pile pile) {
		if (carte instanceof Joker||carte instanceof SuperJoker) {
			
			//choix de la couleur
			Scanner scancoul = new Scanner(System.in);
			System.out.println("choisis ta couleur :");
			String choixCouleur = scancoul.nextLine();
			
			if (choixCouleur == "rouge") {
				//pile.ajouterPile(new Joker(Couleur.Rouge, 50));
				carte.setCouleur(Couleur.Rouge);
			}
			if (choixCouleur == "bleu") {
				//pile.ajouterPile(new Joker(Couleur.Bleu, 50));
				carte.setCouleur(Couleur.Bleu);
				}
			if (choixCouleur == "jaune") {
				carte.setCouleur(Couleur.Jaune);
				//pile.ajouterPile(new Joker(Couleur.Jaune, 50));
				}
			if (choixCouleur == "vert") {
				carte.setCouleur(Couleur.Vert);
				//pile.ajouterPile(new Joker(Couleur.Vert, 50));
				}
			
		}
		carteEnMain.remove(carte);
		pile.ajouterPile(carte);
		
//		if (carte instanceof SuperJoker) {
//			//choix de la couleur
//			Scanner scancoule = new Scanner(System.in);
//			System.out.println("choisis ta couleur :");
//			String choixCouleur = scancoule.nextLine();
//			
//			if (choixCouleur == "rouge") {
//				pile.ajouterPile(new SuperJoker(Couleur.Rouge, 50));
//			}
//			if (choixCouleur == "bleu") {
//				pile.ajouterPile(new SuperJoker(Couleur.Bleu, 50));
//				}
//			if (choixCouleur == "jaune") {
//				pile.ajouterPile(new SuperJoker(Couleur.Jaune, 50));
//				}
//			if (choixCouleur == "vert") {
//				pile.ajouterPile(new SuperJoker(Couleur.Vert, 50));
//				}
//			carteEnMain.remove(carte);
//		}
		
		}
		
	
	
	
	
	}

	

	
	
	


