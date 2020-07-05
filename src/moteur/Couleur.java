package moteur;

public enum Couleur {
	
	Rouge (1, "red"),
	Bleu (2, "blue"),
	Jaune (3, "yellow"),
	Vert (4, "green"),
	Noir (5, "black");
	//OBJETS DIRECTEMENT CONSTRUITS
	 
	   
	  private int valeur = 0;
	  private String couleur;

	  //CONSTRUCTEUR
	  Couleur(int valeur, String couleur){
	    this.valeur = valeur;
	    this.couleur = couleur;
	  }
	   
	  public String toString(){
	    return couleur;
	  }
	}
