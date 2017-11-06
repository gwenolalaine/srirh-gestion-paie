<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

<h1>Liste des bulletins</h1>
<br />
<br />

<div class="offset-10 col-md-2">
		<a class="btn btn-default" href="<c:url value="/mvc/bulletins/creer"/>">Ajouter</a>
</div>
<table class="table table-responsive table-striped table-bordered">
    <thead>
        <tr>
            <th>Date/heure création</th>
            <th>Période</th>
            <th>Matricule</th>
            <th>Salaire brut</th>
            <th>Net imposable</th>
            <th>Net A payer</th>
            <th>Actions</th>
         </tr>
    </thead>
    <tbody>
       <c:forEach var="bulletin" items="${requestScope.bulletins}">
	        <tr>
	          	<td>${bulletin.dateCreation}</td>
	          	<td>${bulletin.periode}</td>
	          	<td>${bulletin.matricule}</td>
	          	<td>${bulletin.salaireBrut}</td>
	          	<td>${bulletin.netImposable}</td>
	          	<td>${bulletin.netAPayer}</td>
	          	<td>${bulletin.actionss}</td>
	        </tr>
        </c:forEach>
    </tbody>
</table>


<%@ include file="../footer.jsp"%>