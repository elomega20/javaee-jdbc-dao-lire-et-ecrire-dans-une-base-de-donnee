<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modelDao</title>
</head>
<body>
    
    <c:if test="${ !empty erreur}">
        <p style="color:red;">
            <c:out value="${ erreur }" />
        </p>
    </c:if>

	<form method="post" action="vue">
		<p>
			<label for="nom">Nom : </label> <input type="text" name="nom"
				id="nom" />
		</p>
		<p>
			<label for="prenom">Prenom : </label> <input type="text"
				name="prenom" id="prenom" />
		</p>

		<input type="submit" />
	</form>

	<ul>
		<c:forEach var="utilisateur" items="${ utilisateurs }">
			<li><c:out value="${ utilisateur.prenom }" /> <c:out
					value="${ utilisateur.nom }" /></li>
		</c:forEach>
	</ul>
</body>
</html>