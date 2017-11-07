<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../header.jsp"%>

<h1>Créer un bulletin de Salaire</h1>
<br />
<br />

<form class="form-horizontal col-sm-offset-1 col-sm-9  col-sm-offset-1" method="post" action="lister" id="ajout">
	<div class="form-group">
		<label class="col-sm-4" for="entreprise">Période :</label>
		<div class="col-sm-8">
			<select class="form-control" name="periode">
				<c:forEach items="${requestScope.periodes}" var="per">
					<option value="${per.id}">${per.dateDebut} - ${per.dateFin}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4" for="matricule">Matricule :</label>
		<div class="col-sm-8">
			<select class="form-control" name="matricule">
				<c:forEach items="${requestScope.employes}" var="emp">
					<option value="${emp.matricule}">${emp.matricule}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4" for="prime">Prime Exceptionnelle</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" name="prime" id="prime" required>
		</div>
	</div>
	
	<div class="col-sm-offset-10 col-sm-2">
		<button class="btn btn-default">Créer</button>
	</div>
</form>

<%@ include file="../footer.jsp"%>
