<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../layout/layout_caiss.jsp"></jsp:include>
<meta charset="UTF-8">
<title>RETRAIT | PAGE</title>
</head>
<body>
	<h1 style="text-align:center;">RETRAIT BANCAIRE </h1>
	<form action="../../retrait_action.caiss" class="container" method="post">
		<input type="text" placeholder="numero compte" class="form-control" required /><br/><br/>
		<input type="number" placeholder="montant a retirer" class="form-control" required /><br/><br/>
		<input type="submit" class="btn btn-primary" value="ENVOYER" />
	</form>
</body>
</html>