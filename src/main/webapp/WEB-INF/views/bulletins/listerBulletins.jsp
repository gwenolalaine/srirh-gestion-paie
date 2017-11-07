<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
  
<h1>Liste des bulletins</h1>
<br />
<br />
<div class="row">
<div class="col-md-offset-11 col-md-1">
		<a class="btn btn-primary" href="<c:url value="/mvc/bulletins/creer"/>">Ajouter</a>
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
	          	<td>${bulletin.dateDeCreationFormat}</td>
	          	<td>${bulletin.periode}</td>
	          	<td>${bulletin.remunerationEmploye.matricule}</td>
	          	<td>${bulletin.resultat.salaireBrut}</td>
	          	<td>${bulletin.resultat.netImposable}</td>
	          	<td>${bulletin.resultat.netAPayer}</td>
	          	<td><a href="<c:url value="/mvc/bulletins/visualiser/${bulletin.id}"/>">Visualiser</a></td>
	        </tr>
        </c:forEach>
    </tbody>
</table>
</div>


<%@ include file="../footer.jsp"%>