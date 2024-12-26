package com.tp.model;

public class Filiere {
	
	protected String nom = "";
	protected int nbetudiants = 0;
	
	public Filiere (String nom, int nbr) {
		this.nom = nom;
		nbetudiants = nbr;
	}
	
	public String getNom () {return nom;}
	public int getNbrEtudiants () {return nbetudiants;}

}
