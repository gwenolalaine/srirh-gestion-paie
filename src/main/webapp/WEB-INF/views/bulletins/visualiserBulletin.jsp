<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Bulletin de salaire</h1>

<c:set var="bulletin" value="${requestScope.bulletin}"></c:set>
<div class="row">
	<div class="col-md-4 col-md-offset-8 ">
		<h3>Période :</h3>
		<p>Du ${bulletin.periode.dateDebut} au ${bulletin.periode.dateFin}</p>
	</div>
	
	<div class="col-md-4">
		<h3>Entreprise</h3>
		${bulletin.remunerationEmploye.entreprise.denomination}
		${bulletin.remunerationEmploye.entreprise.siret}
	</div>
	
	<div class="col-md-4 col-md-offset-4">
		<h3>Matricule</h3>
		${bulletin.remunerationEmploye.matricule}
	</div>
</div>
<div class="row">
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
	       <td>${bulletin.remunerationEmploye.grade.nbHeuresBase}</td>
	       <td>${bulletin.remunerationEmploye.grade.tauxBase}</td>
	       <td>${bulletin.resultat.salaireDeBase}</td>
	       <td></td>
	       <td></td>
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
	    <td></td>
	    <td></td>
	    <td></td>
	    <td></td>
	    <td></td>
	    <td></td>
	     <tr>
	       <td>Salaire brut</td>
	       <td></td>
	       <td></td>
	       <td>${bulletin.resultat.salaireBrut}</td>
	       <td></td>
	       <td></td>
	    </tr>
    </tbody>
</table>

<h3>Cotisations</h3>
<c:set var="cotisationNI" value="${requestScope.cotisationsNI}"></c:set>
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
	    <c:forEach var="cot" items="${cotisationsNI}">
	       <tr>
	       		<td>${cot.libelle}</td>
	       		<td>${bulletin.resultat.salaireBrut}</td>
	       		<td>${cot.tauxSalarial }</td>
	       		<td>${cot.tauxSalarial * bulletin.resultat.salaireBrut}</td>
	       		<td>${cot.tauxPatronal}</td>
	       		<td>${cot.tauxPatronal * bulletin.resultat.salaireBrut}</td>
	       </tr>
	     </c:forEach>
	    </tr>
    </tbody>
</table>

<c:set var="cotisationI" value="${cotisationsI}"></c:set>
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
	     <c:forEach var="cot" items="${cotisationsI}">
	       <tr>
	       		<td>${cot.libelle}</td>
	       		<td>${bulletin.resultat.salaireBrut}</td>
	       		<td>${cot.tauxSalarial }</td>
	       		<td>${cot.tauxSalarial * bulletin.resultat.salaireBrut}</td>
	       		<td>${cot.tauxPatronal}</td>
	       		<td>${cot.tauxPatronal * bulletin.resultat.salaireBrut}</td>
	       </tr>
	     </c:forEach>
    </tbody>
</table>
</div>


<%@ include file="../footer.jsp" %>