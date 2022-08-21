package com.el.servlet;

import java.io.IOException;

import com.el.beans.BeanException;
import com.el.beans.Utilisateur;
import com.el.dao.DaoException;
import com.el.dao.DaoFactory;
import com.el.dao.UtilisateurDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*Notre contrôleur charge le DAO sans savoir 
 * si celui-ci stocke dans une base de données MySQL ou ailleurs. 
 * Il demande simplement d'aller stocker des données ou d'en récupérer :*/

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;

	public MyServlet() {
		super();
	}

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.utilisateurDao = daoFactory.getUtilisateurDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("utilisateurs", utilisateurDao.lister());
		} catch (DaoException e) {
			request.setAttribute("erreur", e.getMessage());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/vue.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setNom(request.getParameter("nom"));
			utilisateur.setPrenom(request.getParameter("prenom"));
			utilisateurDao.ajouter(utilisateur);
			request.setAttribute("utilisateurs", utilisateurDao.lister());

		} catch (Exception e) {
			request.setAttribute("erreur", e.getMessage());
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/vue.jsp").forward(request, response);
	}

}
