<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>

<h1>Ajouter un employé</h1>
<br />
<br />

<form class="form-horizontal col-sm-offset-1 col-sm-9  col-sm-offset-1" method="post" action="lister" id="ajout">
	<div class="form-group">
		<label class="col-sm-4" for="nom">Matricule :</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" name="matricule" id="nom" required>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-4" for="entreprise">Entreprise :</label>
		<div class="col-sm-8">
			<select class="form-control" name="entreprise" >
				<c:forEach items="${requestScope.entreprises}" var="ent">
					<option value="${ent.id}">${ent.denomination}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4" for="profil">Profil :</label>
		<div class="col-sm-8">
			<select class="form-control" name="profil">
				<c:forEach items="${requestScope.profils}" var="prof">
					<option value="${prof.id}">${prof.code}</option>
						
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-4" for="grade">Grade :</label>
		<div class="col-sm-8">
			<select class="form-control" name="grade">
				<c:forEach items="${requestScope.grades}" var="grad">
					<option value="${grad.id}">${grad.code}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="col-sm-offset-10 col-sm-2">
		<button class="btn btn-default">Ajouter</button>
	</div>
</form>

<%@ include file="../footer.jsp"%>
