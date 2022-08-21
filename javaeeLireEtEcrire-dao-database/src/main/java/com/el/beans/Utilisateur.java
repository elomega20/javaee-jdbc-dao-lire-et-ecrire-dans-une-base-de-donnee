package com.el.beans;

public class Utilisateur {
	private String nom;
	private String prenom;

	public String getNom() {
		return nom;
	}

	// si le nom est superieur a 10 caractere , on lence une exception
	public void setNom(String nom) throws BeanException {
		if(nom.length() > 10) {
			throw new BeanException("Le nom est trop grand ! (10 caracteres maximum)");
		}else {
			this.nom = nom;
		}	
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
