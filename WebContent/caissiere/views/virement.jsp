<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../layout/layout_caiss.jsp"></jsp:include>
<meta charset="UTF-8">
<title>VIREMENT | PAGE</title>
</head>
<body>
	<h1 style="text-align:center;">VIREMENT BANCAIRE </h1>
	<form action="" class="container" method="post">
	<div class="form-inline">
		<input type="text" placeholder="numero compte emetteur" class="form-control" required /><br/><br/>
		<input type="text" placeholder="numero compte destinataire" class="form-control" required />
	</div><br/><br/>
		<input type="number" placeholder="montant" class="form-control" required /><br/><br/>
		<input type="submit" class="btn btn-primary" value="ENVOYER" />
	</form>
</body>
</html>