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

		joueurEnCours = 1;
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


			//			System.out.println("Veuillez saisir votre prénom : ");
			//			
			//			String prenom = sc.nextLine();
			//			
			//			System.out.println("Le prénom est "+ prenom);
			//			
			//			System.out.println("Veuillez saisir votre age :");
			//			
			//			int age = sc.nextInt();
			//			
			//			System.out.println("L'age est : " + age);
			int age = 12;
			String prenom = "bender";

			joueur.add(new Reel(prenom , age, i+1));
			//	System.out.println(((Reel) joueur.get(i)).getAge());
		}

		System.out.println("Le nombre de Joueurs est : " + joueur.size());



		//Distribution des cartes reelles

		for (Joueur j : joueur) {
			System.out.println("les cartes du joueur " + j.getNumeroJoueur() + " sont :");
			for (int x=0 ; x<7 ; x++) {
				j.pioche(talon);
				//System.out.println("la taille de cem "+j.getCarteEnMain().size());
				Carte carteTiree = j.getCarteEnMain().get(x);
				System.out.println(carteTiree.getCouleur()+ " " +carteTiree.toString());




			}

		}

		//Creation des joueurs virtuels et distribution

		joueur.add(new Virtuel(10));

		for (int x=0 ; x<7 ; x++) {

			joueur.get(joueur.size() - 1).pioche(talon);

		}

		// apparition de la première carte de la pile

		pile.ajouterPile(talon.carteAuPif());
		
		System.out.println("la première pile est " + pile.getCards().get(pile.getCards().size()-1).toString() + pile.getCards().get(pile.getCards().size()-1).getCouleur());

		while (fin ==false) {
			jouerReel(pile);

		}





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

	//Recommencer cette méthode
	
	public void jouerReel(Pile pile) {

		ArrayList<Carte> carteJouable; 
		carteJouable = new ArrayList<Carte>();
		int addition =0;
		
		
		if (pile.getCards().get(pile.getCards().size()-1) instanceof SuperJoker) {
			for (int a=0 ; a<4 ; a++) {
				joueur.get(joueurEnCours).pioche(talon);
			}
			changerJoueur();
			
		}
		
		if (pile.getCards().get(pile.getCards().size()-1) instanceof Passer) {
			changerJoueur();
		}
		
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
			
		}




		




	}






}







