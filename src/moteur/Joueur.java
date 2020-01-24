package moteur;

import java.util.ArrayList;

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
		pile.ajouterPile(carte);
		carteEnMain.remove(carte);
		
	}

	

	
	
	

}
