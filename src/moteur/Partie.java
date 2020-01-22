package moteur;

import java.util.ArrayList;
import java.util.Scanner;

import moteur.Carte.Couleur;

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
	
	
	


	public Partie() {
		
		// initialisation
		
		joueurEnCours = 0;
		sens = 1;
		fin = false;
		
		// création Talon et pile
		
		this.talon = new Talon(this);
		this.pile = new Pile(this);
		
		
		//Test 108 cartes dans le Talon
		
		for (int x=0 ; x<talon.getCards().size() ; x++) {
			if (talon.getCards().get(x) instanceof CarteClassique) {
				System.out.println("C'est un " + ((CarteClassique) talon.getCards().get(x)).getNumero()+ " et la couleur est " + talon.getCards().get(x).couleur );
			}
			else {
				System.out.println("C'est un "+talon.getCards().get(x).getClass().getSimpleName() +" et sa couleur est : " + talon.getCards().get(x).couleur );
			}
		}
		
		System.out.println("Le nombre de carte est : " + talon.getCards().size());
		
		
		// création des joueurs reels
		
		joueur = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez saisir le nombre de joueurs :");
		int nb = sc.nextInt();

		for (int i=0 ; i<nb ; i++) {
				
		//	System.out.println("Veuillez saisir votre prénom :");
			
		//	String prenom = sc.nextLine();
			String prenom = "bob";
			
		//	System.out.println("Veuillez saisir votre age :");
			
			//int age = sc.nextInt();
			int age = 12;
			
			joueur.add(new Reel(prenom , age));
		}
		
		System.out.println("Le nombre de Joueurs est : " + joueur.size());
		
		
		
		//Distribution des cartes reelles
		
		for (Joueur j : joueur) {
			for (int x=0 ; x<8 ; x++) {
				j.pioche(talon);

			}
			System.out.println("les cartes du joueur " + joueurEnCours + " sont : " + j.getCarteEnMain());
		}
		
		//Creation des joueurs virtuels et distribution
		
		joueur.add(new Virtuel());
		
		for (int x=0 ; x<8 ; x++) {

		joueur.get(joueur.size() - 1).pioche(talon);
		
		}
		
		// apparition de la première carte de la pile
		
		pile.ajouterPile(talon.carteAuPif());
		
		while (fin ==false) {
			faireUnTour(pile);
			
		}
		
		
	
		
			
	}
	
	public int changerJoueur(int joueurEnCours) {
		joueurEnCours = joueurEnCours + 1;
		return joueurEnCours;
		
	}
	
	public void faireUnTour(Pile pile) {
		
		ArrayList<Carte> carteJouable; 
		carteJouable = new ArrayList<Carte>();
		
		//System.out.println(" mes cartes sont : " + joueur.get(joueurEnCours).getCarteEnMain());
		
		
		for ( int x = 0 ; x < joueur.get(joueurEnCours).getCarteEnMain().size() ; x++  ) {
			
			
			//Test pour carte speciale avec couleur ou noir
			
			if (joueur.get(joueurEnCours).getCarteEnMain().get(x)  instanceof CarteSpeciale) {
				
				if ( joueur.get(joueurEnCours).getCarteEnMain().get(x).getCouleur() == pile.getCards().get(pile.getCards().size() - 1).getCouleur() || joueur.get(joueurEnCours).getCarteEnMain().get(x).getCouleur() == Carte.Couleur.Noir ) {
					carteJouable.add(joueur.get(joueurEnCours).getCarteEnMain().get(x));
				}
				
			}
			
			// Test pour carte classique avec couleur, noir ou numero
			
			else if (joueur.get(joueurEnCours).getCarteEnMain().get(x)  instanceof CarteClassique) {
				if (joueur.get(joueurEnCours).getCarteEnMain().get(x).getCouleur() == pile.getCards().get(pile.getCards().size() - 1).getCouleur()   ||  joueur.get(joueurEnCours).getCarteEnMain().get(x).getCouleur() == Carte.Couleur.Noir || ((CarteClassique) joueur.get(joueurEnCours).getCarteEnMain().get(x)).getNumero() == ((CarteClassique) pile.getCards().get(pile.getCards().size() - 1)).getNumero() ) {
					carteJouable.add(joueur.get(joueurEnCours).getCarteEnMain().get(x));
			}
			}

		}
		
		if (carteJouable.size() == 0) {
			joueur.get(joueurEnCours).getCarteEnMain().add(talon.carteAuPif());
		}
		
		
		}
		
		
		
	
	
	
}
	
	

	
	
	

