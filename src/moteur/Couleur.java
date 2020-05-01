package moteur;

public enum Couleur {
	
	Rouge (1),
	Bleu (2),
	Jaune (3),
	Vert (4),
	Noir (5);
	//Objets directement construits
	 
	   
	  private int valeur = 0;
	   
	  //Constructeur
	  Couleur(int valeur){
	    this.valeur = valeur;
	  }
	   
	  public String toString(){
	    return valeur+"";
	  }
	}
