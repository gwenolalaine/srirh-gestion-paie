<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

<a href="<c:url value="/*"/>"><i class= "icon icon-arrow-left" aria-hidden="true" style="font-size:100px color:black"></i></a>
<h1>Liste des employés</h1>
<br />
<br />

<div class="col-md-offset-11 col-md-1">
		<a class="btn btn-primary" href="<c:url value="/mvc/employes/creer"/>">Ajouter</a>
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
	          	<td><c:if test="${!empty employe.dateCreation}">${employe.dateCreation}</c:if></td>
	          	<td><c:if test="${!empty employe.matricule}">${employe.matricule}</c:if></td>
	          	<td><c:if test="${!empty employe.grade}">${employe.grade.code}</c:if></td>
	        </tr>
        </c:forEach>
    </tbody>
</table>


<%@ include file="../footer.jsp"%>