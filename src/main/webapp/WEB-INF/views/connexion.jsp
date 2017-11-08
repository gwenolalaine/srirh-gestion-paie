<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>

<h1>Connexion</h1>

<form method="post">
	<input name="username">
	<input name="password">
	<input type="submit" class="btn btn-primary" value="Se connecter">
	<sec:csrfInput/>
</form>

<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
<c:if test="${param.error !=null}">
	Erreur d'authentification
</c:if>

<%@ include file="footer.jsp"%>