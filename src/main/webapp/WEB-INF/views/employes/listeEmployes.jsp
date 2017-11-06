<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

<h1>Liste des employés</h1>
<br />
<br />

<div class="col-md-offset-10 col-md-2">
		<a class="btn btn-default" href="<c:url value="/mvc/employes/creer"/>">Ajouter</a>
</div>

<table class="table table-responsive table-striped table-bordered">
    <thead>
        <tr>
            <th>Date/heure création</th>
            <th>Matricule</th>
            <th>Grade</th>
         </tr>
    </thead>
    <tbody>
       <c:forEach var="employe" items="${requestScope.employes}">
	        <tr>
	          	<td>${employe.dateCreation}</td>
	          	<td>${employe.matricule}</td>
	          	<td>${employe.grade}</td>
	        </tr>
        </c:forEach>
    </tbody>
</table>


<%@ include file="../footer.jsp"%>