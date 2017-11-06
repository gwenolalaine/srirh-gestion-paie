<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Bulletin de salaire</h1>

<c:set var="visite" value="${requestScope.bulletin}"></c:set>

<div class="col-md-4 offset-md-8">
	<h3>Période :</h3>
	<p>Du ${bulletin.periode.dateDebut} au ${bulletin.periode.dateFin}</p>
</div>

<div class="col-md-4">
	<h3>Entreprise</h3>
	${bulletin.remunerationEmploye.entreprise}
	${bulletin.remunerationEmploye.entreprise.numeroSiret}
</div>

<div class="col-md-4 offset-md-4">
	<h3>Matricule</h3>
	${bulletin.remunerationEmploye.matricule}
</div>

<h3>Salaire</h3>

<table class="table table-responsive table-striped table-bordered">
    <thead>
        <tr>
            <th>Rubriques</th>
            <th>Base</th>
            <th>Taux salarial</th>
            <th>Montant Salarial</th>
            <th>Taux Patronal</th>
            <th>Cot patronales</th>
         </tr>
    </thead>
    <tbody>
	    <tr>
	       <td>Salaire de base</td>
	       <td>Un truc avec résultat calcul rémuneration</td>
	    </tr>
	     <tr>
	       <td>Prime except</td>
	       <td></td>
	       <td></td>
	       <td>${bulletin.primeExceptionnelle }</td>
	       <td></td>
	       <td></td>
	    </tr>
	     <tr>
	    </tr>
	     <tr>
	       <td>Salaire brut</td>
	       <td>Un truc avec résultat calcul rémuneration</td>
	    </tr>
    </tbody>
</table>

<table class="table table-responsive table-striped table-bordered">
    <thead>
        <tr>
            <th>Rubriques</th>
            <th>Base</th>
            <th>Taux salarial</th>
            <th>Montant Salarial</th>
            <th>Taux Patronal</th>
            <th>Cot patronales</th>
         </tr>
    </thead>
    <tbody>
	    <tr>
	    <c:foreach var="cot" items="${remunerationEmploye.profilRemuneration.cotisationNonImposables}">
	       <td>${bulletin.remunerationEmploye.profilRemuneration.cotisationNonImposables.libelle}</td>
	     </c:foreach>
			ect
	    </tr>
    </tbody>
</table>

<h3>NET Imposable : XXXXXX</h3>
<table class="table table-responsive table-striped table-bordered">
    <thead>
        <tr>
            <th>Rubriques</th>
            <th>Base</th>
            <th>Taux salarial</th>
            <th>Montant Salarial</th>
            <th>Taux Patronal</th>
            <th>Cot patronales</th>
         </tr>
    </thead>
    <tbody>
	     <c:foreach var="cot" items="${remunerationEmploye.profilRemuneration.cotisationImposables}">
	       <td>${bulletin.remunerationEmploye.profilRemuneration.cotisationImposables.libelle}</td>
	     </c:foreach>
    </tbody>
</table>



<%@ include file="../footer.jsp" %>