# javaee-jdbc-dao-lire-et-ecrire-dans-une-base-de-donnee

c'est un petit test de javaee pour lire et ecrire dans une base de donnee.

le model utilisateur se trouve dans le script.sql.

la base de donnee utilisé est : mysql

les bibliotheque utiliser sont:

mysql-connector-java-8.0.30 qui est le drive JDBC pour l'interaction du programme et de la base de donnne
-le packet jakarta: {jakarta.servlet.jsp.jstl-2.0.0 , jakarta.servlet.jsp.jstl-api-2.0.0} pour l'utilisation de la bibliotheque JSTL.

ici nous avons utiliser le model DAO (Data Access object) pour separer le SQL du model.
Cela facilite la maintenance et si on le souhaite d'implementer la meme interface pour plusieurs systeme de stockage different.

+ Le javabean Utilisateur.java contient notre model.
+ Le fichier MyServlet.java est notre servlet.
+ Le fichier vue.jsp est notre vue.
+ Le fichier DaoFactory.java gère la connection a la base.
+ Le fichier UtilisateurDao.java est notre interface et contient la déclaration de la methode ajouter() et lister().
+ Le fichier UtilisateurDaoImplementation.java implemente notre interface UtilisateurDao.
+ Le fichier BeanException.java gère les exceptions liés a la classe Utilisateur (ici seulement la methode setNom()).
+ Le fichier DaoException.java gère les exceptions liés a la classe UtilisateurDaoImplementation.