<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD | SALARIE</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body style="margin:0;">
<div style="font-size:24px;font-weight:bold;text-align:center;width:100%;background:skyblue;color:white;height:3rem;padding:20px 0px">
ADD SALARIE
<a class="btn btn-success" style="text-decoration:none;margin-left:100px;" href="../responsable/indexRespo.jsp">RETOUR</a>
</div>
	<main style="margin-top:20px;">
        <div> 
                <!-- form for adding Employee client  -->
                <form class="container" action="../addSalarie.da" method="post">
                    
                    <div class="salarie"> 
                        <input type="text" name="nom" placeholder="nom" class="form-control" id="nom" autocomplete="off" required /><br/>
                        <input type="text" name="prenom" placeholder="prenom" class="form-control" id="prenom" autocomplete="off" required /><br/>
                        <input type="text" name="adresseforCl" class="form-control" placeholder="Adresse Entreprise" id="addr_salarie" autocomplete="off" required /><br/>
                        <input type="text" name="telephone" class="form-control" placeholder="telephone" id="tele_salarie" autocomplete="off" required/><br/>
                        <input type="text" name="email" class="form-control" placeholder="email" id="email_salarie" autocomplete="off" required/><br/>
                  
                        <input type="text" name="profession" class="form-control" placeholder="profession" id="emploi_salarie" autocomplete="off" required/><br/>
                        <input type="text" name="nom_Entreprise" class="form-control" placeholder="nom entreprise" id="NameEnter_salarie" autocomplete="off" required/><br/>
                        <input type="text" name="cni" class="form-control" class="form control" placeholder="CNI" id="cni_salarie" autocomplete="off" required/><br/>
                    </div>
                    <div class="button_for_s" id="button">
                        <button class="btn btn-primary" id="btn_Csalarie" name="btn" value="cSalarie" >Valider</button ">
                          <button class="btn btn-danger" type="reset">Annuler</button>
                    </div>
                <!-- end of all the  -->
            </form>
        </div>
    </main>
	
	
	
	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</body>
</html>