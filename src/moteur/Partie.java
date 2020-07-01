package moteur;

import java.util.ArrayList;
import java.util.Scanner;

// INTERFACE GRAPHIQUE

public class Partie {

	private ArrayList<Joueur> joueur;
	private Pile pile;
	private Talon talon;
	private int sens;
	private int joueurEnCours;
	private boolean fin;


	//METHODE POUR PASSER AU JOUEUR SUIVANT
	public void changerJoueur() {

		joueurEnCours = joueurEnCours + sens;

		if (joueurEnCours > joueur.size()-1) {
			joueurEnCours = 0;
		}
		else if (joueurEnCours< 0) {
			joueurEnCours = joueur.size() - 1;
		}

	}

	// METHODER CHANGER DE SENS 
	public void changerSens() {
		sens = - sens;
	}
	
	// METHODE CONDITION POUR JOUER UNE CARTE 
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

	// CONSTRUCTEUR DE PARTIE PERMETTANT LE JEU
	public Partie() {

		// INIT
		joueurEnCours = 0;
		sens = 1;
		fin = false;
		
		// CREATION TALON/PILE
		this.talon = new Talon();
		this.pile = new Pile();

		System.out.println("Le nombre de carte est : " + talon.getCards().size());

		// CREATION REEL
		joueur = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		// SELECTION DU NOMBRE DE JOUEURS REELS
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
		Carte premiere = talon.carteAuPif();
		if(premiere instanceof SuperJoker || premiere instanceof Joker) {
			premiere = talon.carteAuPif();
		}
		pile.ajouterPile(premiere);


		// DEROULEMENT DU JEU 
		while(fin == false) {
			System.out.println("**************** DEBUT D'UN NOUVEAU TOUR *******************");
			faireUnTour(this);
			changerJoueur();
		}
		
	}
	
	public void faireUnTour(Partie p) {
		
		
		// AFFICHAGE DU NOM JOUEUR
		if(joueur.get(joueurEnCours) instanceof Reel) {
			System.out.println("le joueur en cours est : "+ ((Reel) joueur.get(joueurEnCours)).getPrenom());
		}
		else {
			System.out.println("le joueur en cours est VIRTUEL : "+ joueur.get(joueurEnCours).getNumeroJoueur());
		}
		
		// AFFICHAGE DU NOMBRE DE CARTES EN MAIN
		System.out.println( "Le joueur a : "+joueur.get(joueurEnCours).getCarteEnMain().size()+ " cartes");
		
		// AFFICHAGE DE LA PREMIERE CARTE DE LA PILE 
		if (pile.getCards().get(pile.getCards().size() - 1) instanceof CarteClassique) {
			System.out.println("               la première carte de la pile est " + pile.getCards().get(pile.getCards().size() - 1).toString()
					+ pile.getCards().get(pile.getCards().size() - 1).getCouleur() + " numéro "
					+ ((CarteClassique) pile.getCards().get(pile.getCards().size() - 1)).getNumero());
		} else {
			System.out.println("               la première pile est " + pile.getCards().get(pile.getCards().size() - 1).toString()
					+ pile.getCards().get(pile.getCards().size() - 1).getCouleur());
		}
		
		
		// LE JOUEUR JOUE
		joueur.get(joueurEnCours).jouer(pile, talon, p);
		if(joueur.get(joueurEnCours).getCarteEnMain().size() ==0) {
			fin =true;
		}
	}

}
