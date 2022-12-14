package com.el.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.el.beans.BeanException;
import com.el.beans.Utilisateur;

/*L'implémentation réelle de ces méthodes 
 *(le code à l'intérieur) indiquera si on 
 *stocke en SQL dans MySQL, dans Oracle, 
 *dans des fichiers ou ailleurs*/

public class UtilisateurDaoImplementation implements UtilisateurDao {
	private DaoFactory daoFactory;

	UtilisateurDaoImplementation(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Utilisateur utilisateur) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?, ?);");
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());

			preparedStatement.executeUpdate();
			connexion.commit();
		} catch (SQLException e) {
			try {
				if (connexion != null) {
					connexion.rollback();
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					connexion.close();
				}
			} catch (SQLException e1) {
			}
			throw new DaoException("impossible de communiquer avec la base de données");
		} finally {
            try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e2) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}
	}

	@Override
	public List<Utilisateur> lister() throws DaoException {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT nom, prenom FROM noms;");

			while (resultat.next()) {
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");

				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);

				utilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			throw new DaoException("impossible de communiquer avec la base de données");
		} catch (BeanException e) {
			throw new DaoException("les données de la base sont invalides");
		} finally {
			try {
				if (resultat != null) {
					resultat.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {
				throw new DaoException("impossible de communiquer avec la base de données");
			}
		}

		return utilisateurs;
	}
}
