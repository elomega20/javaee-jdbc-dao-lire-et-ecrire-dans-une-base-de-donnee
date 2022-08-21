# javaee-jdbc-dao-lire-et-ecrire-dans-une-base-de-donnee

c'est un petit test de javaee pour lire et ecrire dans une base de donnee.

le model utilisateur se trouve dans le script.sql.

la base de donnee utilisé est : mysql

les bibliotheque utiliser sont:

mysql-connector-java-8.0.30 qui est le drive JDBC pour l'interaction du programme et de la base de donnne
-le packet jakarta: {jakarta.servlet.jsp.jstl-2.0.0 , jakarta.servlet.jsp.jstl-api-2.0.0} pour l'utilisation de la bibliotheque JSTL.

ici nous avons utiliser le model DAO (Data Access object) pour separer le SQL du model.
Cela facilite la maintenance et si on le souhaite d'implementer la meme interface pour plusieurs systeme de stockage different.