<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
	<style>
	.error {
		color: red;
	}
	</style>

</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/mvc/employes/lister"/>">Employes</a></li>
				<li><a href="<c:url value="/mvc/bulletins/lister"/>">Bulletins</a></li>
			</ul>
		</div>
	</nav>
	
<div class="container-fluid" id="content">