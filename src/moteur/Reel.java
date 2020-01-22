package moteur;

import java.util.ArrayList;

public class Reel extends Joueur{
	
	
	private String prenom;
	private int age;
	
	
	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Reel( String prenom, int age) {
		
		this.prenom = prenom;
		this.age = age;
	}


	
	

}
