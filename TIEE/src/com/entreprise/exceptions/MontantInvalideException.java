package com.entreprise.exceptions;

public class MontantInvalideException extends Exception {
	private double valeur;
	
	//Constructeur 
	public MontantInvalideException  (String champ,double valeur) {
		super(champ + "invalide :"+ valeur );
		this.valeur=valeur;
	}
	//Getter de la valeur
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

}
