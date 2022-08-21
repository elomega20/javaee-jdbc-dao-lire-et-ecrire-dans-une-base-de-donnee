package com.el.dao;

import java.util.List;

import com.el.beans.Utilisateur;

/*On utilise une interface pour définir 
 * les méthodes d'accès aux données des utilisateurs, 
 * indépendamment de la méthode de stockage. On indique 
 * juste des noms de méthodes ici.*/

public interface UtilisateurDao {
	void ajouter(Utilisateur utilisateur) throws DaoException;
	List<Utilisateur> lister() throws DaoException;
}
