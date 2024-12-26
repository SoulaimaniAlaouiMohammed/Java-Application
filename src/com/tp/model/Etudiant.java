package com.tp.model;

import com.tp.dao.DB;

public class Etudiant {
	
	protected String cne = "";
	protected String nom = "";
	protected String prenom = "";
	protected String adresse = "";
	
	private DB co = new DB();
	
	public Etudiant (String cne, String nom, String prenom, String adr) {
		this.cne = cne;
		this.nom = nom;
		this.prenom = prenom;
		adresse = adr;
	}
	
	public String getCNE() {return cne;}
	public String getNom() {return nom;}
	public String getPrenom() {return prenom;}
	public String getAdresse() {return adresse;}
	
	public void inscrire (int num) {
		co.inscris(cne, num);
	}

}
