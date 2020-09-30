<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD | INDEPENDANT</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body style="margin:0;">
<div style="font-size:24px;font-weight:bold;
text-align:center;width:100%;background:skyblue;
color:white;height:3rem;padding:20px 0px">
ADD INDEPENDANT CLIENT
<a class="btn btn-success" style="text-decoration:none;margin-left:100px;" href="../responsable/indexRespo.jsp">RETOUR</a>
</div>
	<main style="margin-top:20px;">
        <div>
                <!-- form for adding INdependant client  -->
                <form class="container" action="../addInde.da" method="post">
                    <input type="text" name="nom" class="form-control" placeholder="nom" id="nom_i" autocomplete="off" required/><br/>
                <input type="text" name="prenom" class="form-control" placeholder="prenom" id="prenom_i" autocomplete="off" required /><br/>
                <input type="text" name="localisation" class="form-control" placeholder="adresse" id="adresse_i" autocomplete="off" required /><br/>
                <input type="text" name="telephone" class="form-control" placeholder="telephone" id="telephone_i" autocomplete="off" required /><br/>
                <input type="email" name="email" class="form-control" placeholder="email" id="email_i" autocomplete="off" required/><br/>
                <input type="text" name="activite" class="form-control" placeholder="activite" id="activite_i" autocomplete="off" required /><br/>
                <input type="text" name="cni" class="form-control" placeholder="CNI" id="activite_i" autocomplete="off" required/><br/> 
                   
                <!-- end of all the  -->
                <input type="submit" name="addI" class="btn btn-primary" value="ENREGISTRER"/>
                <input type="reset"  class="btn btn-danger" value="ENREGISTRER"/>
            </form>
        </div>
    </main>
	
	
	
	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</body>
</html>