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

	// RECUPERE LE NUMERO DU JOUEUR
	public int getNumeroJoueur() {
		return numeroJoueur;
	}

	// RECUPERE LES CARTES EN MAIN
	public ArrayList<Carte> getCarteEnMain() {
		return carteEnMain;
	}

	// PERMET DE PIOCHER UNE CARTE
	public void pioche(Talon talon) {

		Carte carte = talon.carteAuPif();
		carteEnMain.add(carte);
		talon.getCards().remove(carte);
	}

	// METHODE ABSTRAITE POUR POSER UNE CARTE. DEFINIE DANS REEL ET VIRTUEL.
	public abstract void poser(Carte carte, Pile pile);
	
	// METHODE ABSTRAITE POUR JOUER LORSQUE C'EST POSSIBLE. DEFINIE DANS REEL ET VIRTUEL.
	public abstract void jouer(Pile pile, Talon talon, Partie p);
		
			
		
	}


