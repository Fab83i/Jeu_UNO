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

// PERMET DE PIOCHER UNE CARTE

	public void pioche(Talon talon) {

		Carte carte = talon.carteAuPif();
		carteEnMain.add(carte);
		talon.getCards().remove(carte);
	}

	public abstract void poser(Carte carte, Pile pile);
	
	public abstract void jouer(Pile pile, Talon talon, Partie p);
		
			
		
	}


