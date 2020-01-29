package moteur;

import java.util.ArrayList;
import java.util.Scanner;


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
				System.out.println("C'est un " + ((CarteClassique) talon.getCards().get(x)).getNumero()+ " et la couleur est " + talon.getCards().get(x).getCouleur() );
			}
			else {
				System.out.println("C'est un "+talon.getCards().get(x).getClass().getSimpleName() +" et sa couleur est : " + talon.getCards().get(x).getCouleur() );
			}
		}

		System.out.println("Le nombre de carte est : " + talon.getCards().size());


		// création des joueurs reels

		joueur = new ArrayList<>();


		Scanner sc = new Scanner(System.in);

		System.out.println("Veuillez saisir le nombre de joueurs :");
		int nb = sc.nextInt();

		for (int i=0 ; i<nb ; i++) {
			
			
			Scanner pren = new Scanner(System.in);
			System.out.println("Veuillez saisir votre prénom : ");

			String prenom = pren.nextLine();

			System.out.println("Le prénom est "+ prenom);
			
			Scanner ag = new Scanner(System.in);
			System.out.println("Veuillez saisir votre age :");

			int age = ag.nextInt();

			System.out.println("L'age est : " + age);

			joueur.add(new Reel(prenom , age, i+1));
		}

		System.out.println("Le nombre de Joueurs est : " + joueur.size());



		//Distribution des cartes reelles

		for (Joueur j : joueur) {
			System.out.println("les cartes du joueur " + j.getNumeroJoueur() + " sont :");
			for (int x=0 ; x<7 ; x++) {
				j.pioche(talon);
				//System.out.println("la taille de cem "+j.getCarteEnMain().size());
				Carte carteTiree = j.getCarteEnMain().get(x);
				if (carteTiree instanceof CarteClassique) {
					System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString() + "numéro " + ((CarteClassique) carteTiree).getNumero() );
				}
				else {
					System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString() );
				}





			}

		}

		//Creation des joueurs virtuels et distribution

		joueur.add(new Virtuel(10));

		for (int x=0 ; x<7 ; x++) {

			joueur.get(joueur.size() - 1).pioche(talon);

		}

		// apparition de la première carte de la pile

		pile.ajouterPile(talon.carteAuPif());

		if (pile.getCards().get(pile.getCards().size()-1) instanceof CarteClassique) {
			System.out.println("la première pile est " + pile.getCards().get(pile.getCards().size()-1).toString() + pile.getCards().get(pile.getCards().size()-1).getCouleur() + " numéro " + ((CarteClassique) pile.getCards().get(pile.getCards().size()-1)).getNumero());
		}
		else {
			System.out.println("la première pile est " + pile.getCards().get(pile.getCards().size()-1).toString() + pile.getCards().get(pile.getCards().size()-1).getCouleur());
		}


		//while (fin ==false) {
		jouerReel(pile);


		//}

	}



	public void changerJoueur() {

		joueurEnCours = joueurEnCours + sens;

		if(joueurEnCours + sens > joueur.size()-1) {
			joueurEnCours = 0;
		}
		if(joueurEnCours + sens < 0) {
			joueurEnCours = joueur.size()-1;
		}


	}

	public void changerSens(){
		if (sens == 1) {
			sens = -1;
		}
		else {
			sens = 1;
		}
	}

	//Quand premiere pile SuperJoker --> carteJouable déconne

	public void jouerReel(Pile pile) {

		ArrayList<Carte> carteJouable; 
		carteJouable = new ArrayList<Carte>();
		int addition =0;
		int taillePile = pile.getCards().size();

		//SuperJoker
		if (pile.getCards().get(pile.getCards().size()-1) instanceof SuperJoker) {
			for (int a=0 ; a<4 ; a++) {
				joueur.get(joueurEnCours).pioche(talon);
			}
			changerJoueur();
			
			//affichage carteEnMain
			for (int x = 0 ; x<joueur.get(joueurEnCours).getCarteEnMain().size() ; x++) {
				Carte carteTiree = joueur.get(joueurEnCours).getCarteEnMain().get(x);
				if (carteTiree instanceof CarteClassique) {
					System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString() + "numéro " + ((CarteClassique) carteTiree).getNumero() );
				}
				else {
					System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString() );
				}
			}
			return;

		}
		//Passer
		if (pile.getCards().get(pile.getCards().size()-1) instanceof Passer) {
			changerJoueur();
			return;
		}
		//PlusDeux
		if (pile.getCards().get(pile.getCards().size()-1) instanceof PlusDeux) {
			for (int b = pile.getCards().size()-1 ; b>0 ; b--) {
				while(pile.getCards().get(b) instanceof PlusDeux) {
					addition++;
				}
			}
			for (int x = 0 ; x< joueur.get(joueurEnCours).getCarteEnMain().size() -1 ; x++) {
				if (joueur.get(joueurEnCours).getCarteEnMain().get(x) instanceof PlusDeux) {
					carteJouable.add(joueur.get(joueurEnCours).getCarteEnMain().get(x));
				}
			}
			if (carteJouable.size() == 0) {
				for (int c = 1 ; c< 2*addition ; c++ ) {
					joueur.get(joueurEnCours).pioche(talon);
				}
				changerJoueur();
				return;

			}

		}

		for (int d = 0 ; d <joueur.get(joueurEnCours).getCarteEnMain().size() -1 ; d++ ) {
			//meme couleur
			if (joueur.get(joueurEnCours).getCarteEnMain().get(d).getCouleur() == pile.getCards().get(pile.getCards().size()-1).getCouleur()) {
				carteJouable.add(joueur.get(joueurEnCours).getCarteEnMain().get(d));
			}
			//superJoker ou joker
			if (joueur.get(joueurEnCours).getCarteEnMain().get(d).getCouleur() == Couleur.Noir) {
				carteJouable.add(joueur.get(joueurEnCours).getCarteEnMain().get(d));
			}
			//meme chiffre
			if (pile.getCards().get(pile.getCards().size()-1) instanceof CarteClassique && joueur.get(joueurEnCours).getCarteEnMain().get(d) instanceof CarteClassique ) {
				if (((CarteClassique) joueur.get(joueurEnCours).getCarteEnMain().get(d)).getNumero() == ((CarteClassique) pile.getCards().get(pile.getCards().size()-1)).getNumero()) {
					carteJouable.add(joueur.get(joueurEnCours).getCarteEnMain().get(d));
				}
			}

		}
		//Rien ne correspond = tirage d'une carteAuPif
		if ( carteJouable.size() == 0) {
			joueur.get(joueurEnCours).pioche(talon);
			changerJoueur();
			
			//affichage carteEnMain
			for (int x = 0 ; x<joueur.get(joueurEnCours).getCarteEnMain().size() ; x++) {
				Carte carteTiree = joueur.get(joueurEnCours).getCarteEnMain().get(x);
				if (carteTiree instanceof CarteClassique) {
					System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString() + "numéro " + ((CarteClassique) carteTiree).getNumero() );
				}
				else {
					System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString() );
				}
			}
			return;
		}

		//Affichage de mes cartes jouables
		System.out.println("le nb de carteJouable est "+ carteJouable.size());
		System.out.println("Les carteJouable sont : ");
		for (int f=0 ; f<carteJouable.size() ; f++) {
			if(carteJouable.get(f) instanceof CarteClassique) {
				System.out.println(carteJouable.get(f) + "" + carteJouable.get(f).getCouleur() + "numéro " + ((CarteClassique) carteJouable.get(f)).getNumero());
			}
			else {
				System.out.println(carteJouable.get(f) + "" + carteJouable.get(f).getCouleur());
			}

		}
		
		//Choix de la carteSpeciale à jouer choisir couleur avant de poser à faire
		Scanner scanChoix = new Scanner(System.in);
		System.out.println("Veuillez choisir votre carte: ");
		int choix = scanChoix.nextInt();
		joueur.get(joueurEnCours).poser(carteJouable.get(choix), pile);
		
		if (pile.getCards().get(taillePile) instanceof Sens) {
			changerSens();
			
		}
		if (pile.getCards().get(taillePile) instanceof Passer) {
			changerJoueur();
			changerJoueur();
		}
		
		
		System.out.println("la couleur de la nouvelle pile est " + pile.getCards().get(pile.getCards().size()-1).getCouleur() + "le type " + pile.getCards().get(pile.getCards().size()-1).toString());
		
		for (int x = 0 ; x<joueur.get(joueurEnCours).getCarteEnMain().size() ; x++) {
			Carte carteTiree = joueur.get(joueurEnCours).getCarteEnMain().get(x);
			if (carteTiree instanceof CarteClassique) {
				System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString() + "numéro " + ((CarteClassique) carteTiree).getNumero() );
			}
			else {
				System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString() );
			}
		}
		
		



	}
	
	
	//Coder le choix des joueurs virtuels
	public void jouerVirtuel(Pile pile) {
		
		ArrayList<Carte> carteJouable; 
		carteJouable = new ArrayList<Carte>();
		int addition =0;
		int taillePile = pile.getCards().size();

		//SuperJoker
		if (pile.getCards().get(pile.getCards().size()-1) instanceof SuperJoker) {
			for (int a=0 ; a<4 ; a++) {
				joueur.get(joueurEnCours).pioche(talon);
			}
			changerJoueur();

		}
		//Passer
		if (pile.getCards().get(pile.getCards().size()-1) instanceof Passer) {
			changerJoueur();
		}
		//PlusDeux
		if (pile.getCards().get(pile.getCards().size()-1) instanceof PlusDeux) {
			for (int b = pile.getCards().size()-1 ; b>0 ; b--) {
				while(pile.getCards().get(b) instanceof PlusDeux) {
					addition++;
				}
			}
			for (int x = 0 ; x< joueur.get(joueurEnCours).getCarteEnMain().size() -1 ; x++) {
				if (joueur.get(joueurEnCours).getCarteEnMain().get(x) instanceof PlusDeux) {
					carteJouable.add(joueur.get(joueurEnCours).getCarteEnMain().get(x));
				}
			}
			if (carteJouable.size() == 0) {
				for (int c = 1 ; c< 2*addition ; c++ ) {
					joueur.get(joueurEnCours).pioche(talon);
				}
				changerJoueur();

			}

		}

		for (int d = 0 ; d <joueur.get(joueurEnCours).getCarteEnMain().size() -1 ; d++ ) {
			//meme couleur
			if (joueur.get(joueurEnCours).getCarteEnMain().get(d).getCouleur() == pile.getCards().get(pile.getCards().size()-1).getCouleur()) {
				carteJouable.add(joueur.get(joueurEnCours).getCarteEnMain().get(d));
			}
			//superJoker ou joker
			if (joueur.get(joueurEnCours).getCarteEnMain().get(d).getCouleur() == Couleur.Noir) {
				carteJouable.add(joueur.get(joueurEnCours).getCarteEnMain().get(d));
			}
			//meme chiffre
			if (pile.getCards().get(pile.getCards().size()-1) instanceof CarteClassique && joueur.get(joueurEnCours).getCarteEnMain().get(d) instanceof CarteClassique ) {
				if (((CarteClassique) joueur.get(joueurEnCours).getCarteEnMain().get(d)).getNumero() == ((CarteClassique) pile.getCards().get(pile.getCards().size()-1)).getNumero()) {
					carteJouable.add(joueur.get(joueurEnCours).getCarteEnMain().get(d));
				}
			}

		}
		//Rien ne correspond = tirage d'une carteAuPif
		if ( carteJouable.size() == 0) {
			joueur.get(joueurEnCours).pioche(talon);
			changerJoueur();
		}

		//Affichage de mes cartes jouables
		System.out.println("le nb de carteJouable est "+ carteJouable.size());
		System.out.println("Les carteJouable sont : ");
		for (int f=0 ; f<carteJouable.size() ; f++) {
			if(carteJouable.get(f) instanceof CarteClassique) {
				System.out.println(carteJouable.get(f) + "" + carteJouable.get(f).getCouleur() + "numéro " + ((CarteClassique) carteJouable.get(f)).getNumero());
			}
			else {
				System.out.println(carteJouable.get(f) + "" + carteJouable.get(f).getCouleur());
			}

		}
		
		//Choix de la carteSpeciale à jouer choisir couleur avant de poser à faire
		//Ajouter les points de cartes
		for (int x=0 ; x<carteJouable.size() ; x++) {
			
		}
		joueur.get(joueurEnCours).poser(carteJouable.get(choix), pile, carteJouable, choix);
		
		if (pile.getCards().get(taillePile) instanceof Sens) {
			changerSens();
			
		}
		if (pile.getCards().get(taillePile) instanceof Passer) {
			changerJoueur();
			changerJoueur();
		}
		
		
		System.out.println("la couleur de la nouvelle pile est " + pile.getCards().get(pile.getCards().size()-1).getCouleur());
		
		for (int x = 0 ; x<joueur.get(joueurEnCours).getCarteEnMain().size() ; x++) {
			Carte carteTiree = joueur.get(joueurEnCours).getCarteEnMain().get(x);
			if (carteTiree instanceof CarteClassique) {
				System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString() + "numéro " + ((CarteClassique) carteTiree).getNumero() );
			}
			else {
				System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString() );
			}
		}
		
	}






}







