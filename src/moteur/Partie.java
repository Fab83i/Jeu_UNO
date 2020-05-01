package moteur;

import java.util.ArrayList;
import java.util.Scanner;

// REGLER LE PROBLEME DES JOKER ET SUPERJOKER (COULEUR ET APPARITION PREMIERE)
// INTERFACE GRAPHIQUE

public class Partie {

	private ArrayList<Joueur> joueur;
	private Pile pile;
	private Talon talon;
	private int sens;
	private int joueurEnCours;
	private boolean fin;

	public int getSens() {
		return sens;
	}

	public void setSens(int sens) {
		this.sens = sens;
	}

	public void changerJoueur() {

		joueurEnCours = joueurEnCours + sens;

		if (joueurEnCours > joueur.size()-1) {
			joueurEnCours = 0;
		}
		else if (joueurEnCours< 0) {
			joueurEnCours = joueur.size() - 1;
		}

	}

	public void changerSens() {
		sens = - sens;
	}
	
	public boolean canPlayThisCard( Carte carte) {
		Carte hautPile = pile.getCards().get(pile.getCards().size()-1);
		
		if (hautPile instanceof CarteClassique && carte instanceof CarteClassique) {
			if (((CarteClassique) carte).getNumero() == ((CarteClassique) hautPile).getNumero()) {
				return true;
			}	
		}
		if (hautPile.getCouleur() == carte.getCouleur()) {
			return true;
		}
		if (hautPile instanceof PlusDeux && carte instanceof PlusDeux){
			return true;
		}
		if(carte instanceof Joker || carte instanceof SuperJoker) {
			return true;
		}	
		
		return false;
		
	}

	public Partie() {

		// INIT
		joueurEnCours = 0;
		sens = 1;
		fin = false;
		
		// CREATION TALON/PILE
		this.talon = new Talon(this);
		this.pile = new Pile(this);

		System.out.println("Le nombre de carte est : " + talon.getCards().size());

		// CREATION REEL
		joueur = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("Veuillez saisir le nombre de joueurs :");
		int nb = sc.nextInt();
		for (int i = 0; i < nb; i++) {
			Scanner pren = new Scanner(System.in);
			System.out.println("Veuillez saisir votre prénom : ");
			String prenom = pren.nextLine();
			System.out.println("Le prénom est " + prenom);
			joueur.add(new Reel(prenom, i));
		}
		System.out.println("Le nombre de Joueurs est : " + joueur.size());

		// DISTRIBUTION CARTE REEL
		for (Joueur j : joueur) {
			System.out.println("les cartes du joueur " + j.getNumeroJoueur() + " sont :");
			for (int x = 0; x < 7; x++) {
				j.pioche(talon);
				Carte carteTiree = j.getCarteEnMain().get(x);
				if (carteTiree instanceof CarteClassique) {
					System.out.println(carteTiree.getCouleur() + " " + carteTiree.toString() + "numéro "
							+ ((CarteClassique) carteTiree).getNumero());
				} else {
					System.out.println(carteTiree.getCouleur() + " " + carteTiree.toString());
				}
			}
		}

		// CREATION VIRTUEL + DISTRIBUTION CARTES
		joueur.add(new Virtuel(joueur.size()-1));
		for (int x = 0; x < 7; x++) {
			joueur.get(joueur.size() - 1).pioche(talon);
		}

		// AFFICHAGE PREMIERE CARTE DE PILE
		pile.ajouterPile(talon.carteAuPif());

//		if (pile.getCards().get(pile.getCards().size() - 1) instanceof CarteClassique) {
//			System.out.println("la première pile est " + pile.getCards().get(pile.getCards().size() - 1).toString()
//					+ pile.getCards().get(pile.getCards().size() - 1).getCouleur() + " numéro "
//					+ ((CarteClassique) pile.getCards().get(pile.getCards().size() - 1)).getNumero());
//		} else {
//			System.out.println("la première pile est " + pile.getCards().get(pile.getCards().size() - 1).toString()
//					+ pile.getCards().get(pile.getCards().size() - 1).getCouleur());
//		}
		
		while(fin == false) {
			System.out.println("DEBUT D'UN NOUVEAU TOUR");
			faireUnTour(this);
			changerJoueur();
		}
		
	}
	
	public void faireUnTour(Partie p) {
		
		
		// AFFICHAGE DE LA CARTE PILE
		System.out.println("le joueur en cours est : "+ joueurEnCours);
		System.out.println( "Le joueur a : "+joueur.get(joueurEnCours).getCarteEnMain().size()+ " cartes");
		if (pile.getCards().get(pile.getCards().size() - 1) instanceof CarteClassique) {
			System.out.println("la première pile est " + pile.getCards().get(pile.getCards().size() - 1).toString()
					+ pile.getCards().get(pile.getCards().size() - 1).getCouleur() + " numéro "
					+ ((CarteClassique) pile.getCards().get(pile.getCards().size() - 1)).getNumero());
		} else {
			System.out.println("la première pile est " + pile.getCards().get(pile.getCards().size() - 1).toString()
					+ pile.getCards().get(pile.getCards().size() - 1).getCouleur());
		}
		
		
		// LE JOUEUR JOUE
		joueur.get(joueurEnCours).jouer(pile, talon, p);
		if(joueur.get(joueurEnCours).getCarteEnMain().size() ==0) {
			fin =true;
		}
	}

}
