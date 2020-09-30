<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">

<title>COMPTE | PAGE </title>
<% if(session.getAttribute("idClient") == null ){response.sendRedirect("comptes/verifyMat.jsp");} %>
</head>
<body>
	<form class="container" action="../add.compte" style="width:600px;" method="post">
		    <div class="Moral">
            <h2>INFORMATIONS COMPTE DU CLIENT</h2>
            <input type="text" name="" placeholder="nom complet"
         value="<%=  session.getAttribute("nomClient") %>" class="form-control" id="prenom" readonly/><br/>
            <input type="text" name="" placeholder="cni" 
             value="<%=  session.getAttribute("idClient") %>" class="form-control" id="idClient" readonly/><br/>
        </div>
        <label for="" style="color:white;">TYPE COMPTE </label>
            <select name="typeCompte" id="type_m" class="form-control" required>
                <option value="">Choisir...</option>
                <option value="Epargne">Compte Epargne</option>
                <option value="Courant">Compte Courant</option>
                <option value="Bloque">Compte Bloque</option>
            </select><br/>
            <input type="text" name="raison" class="form-control" id="raison_social" placeholder="raison social"/><br/>
            <input type="number" name="cle_rib" class="form-control" id="cle_rib" min="1" max="97" placeholder="Cle RIB"/><br/>
            <input type="number" name="montant" class="form-control" id="montant" min="10000" placeholder="montant" /><br/>
            <input type="text" name="Name_entreprise" class="form-control" id="nom_Entreprise" placeholder="nom Entreprise" /><br/>
            <input type="text" name="adresse_Entreprise" class="form-control" id="Adresse_Entreprise" placeholder="Adresse Entreprise" /><br/>
           
            <label for="" style="color:white;">DATE DEBLOCAGE COMPTE </label>
        <input type="date" placeholder="date deblocage compte" class="form-control" id="date_deblocage" 
        name="dateDebloc"/> 
            
            <!-- pour la session avec la date , voir la page index.php(Ligne 16-18) -->
            <br/>
            <label for="" style="color:white;">DATE OUVERTURE COMPTE</label>
            <input type="date" name="dateOuvert" class="form-control" placeholder="date ouverture" id="date_m" /> 
            <div id="choix">
                <label for="">FRAIS OUVERTURE</label><input class="form-control"  type="checkbox" 
                name="souscription" value="souscri" id="frais"/>
            </div>
            <div id="choix2">
                <label for="">RETRAIT AGIOS TOUS LES 3 MOIS</label> 
                <input type="checkbox" class="form-control" name="agiosOBG" value="agios" id="fraisR"/>
            </div><br/>
    <div class="button_for_s" id="button">
        <button id="btn_create" class="btn btn-primary" name="btn" value="C_compte" >Valider</button>
          <button class="btn btn-danger">Annuler</button>
    </div>
	</form>
	
	
	
	
	
	
	<script type="text/javascript">
	class UI_Compte{
	    static getTypeCompte(){
	        document.querySelector("#type_m").addEventListener("change",()=>{
	            var valueOption = document.querySelector("#type_m").value;
	            switch(valueOption){
	                case 'Epargne': 
	                    UI_Compte.AccountEpargne();
	                    break;
	                case 'Courant': 
	                    UI_Compte.AccountCourant();
	                    break;
	                case 'Bloque':
	                    UI_Compte.AccountBloque();
	                    break;
	                default:
	                    UI_Compte.displayAll();
	                    break;
	            }
	        });
	    }
	    
	    static clearFieldCompte(){
	          document.querySelector("#raison_social").value="";
	        document.querySelector("#nom_Entreprise").value="";
	    document.querySelector("#Adresse_Entreprise").value="";
	        document.querySelector("#cle_rib").value="";
	        document.querySelector("#montant").value="";
	    }
	    
	    static displayAll(){
	        UI_Compte.clearFieldCompte();
	        document.querySelector("#raison_social").removeAttribute("disabled");
	        document.querySelector("#nom_Entreprise").removeAttribute("disabled");
	        document.querySelector("#date_deblocage").removeAttribute("disabled");
	        document.querySelector("#Adresse_Entreprise").removeAttribute("disabled");
	        document.querySelector("#date_deblocage").removeAttribute("disabled");
	        document.querySelector("#cle_rib").removeAttribute("disabled");
	        document.querySelector("#montant").removeAttribute("disabled");
	        document.querySelector("#date_m").removeAttribute("disabled");
	        document.querySelector("#choix").style.display='none';
	        document.querySelector("#choix2").style.display='none';
	        
	        //remove all the field required 
	         document.querySelector("#raison_social").removeAttribute("required");
	        document.querySelector("#nom_Entreprise").removeAttribute("required");
	        document.querySelector("#date_deblocage").removeAttribute("required");
	    document.querySelector("#Adresse_Entreprise").removeAttribute("required");
	        document.querySelector("#date_deblocage").removeAttribute("required");
	        document.querySelector("#cle_rib").removeAttribute("required");
	        document.querySelector("#montant").removeAttribute("required");
	        document.querySelector("#date_m").removeAttribute("required");
	        document.querySelector("#frais").removeAttribute("required");
	        document.querySelector("#fraisR").removeAttribute("required");
	    }
	    
	    static verifyAccountBloque(){
	        let cpt = 0;
	        if(cle_rib.value===""){
	           cpt+=1;
	        cle_rib.style.borderColor='#FA6D63';
	        }if(taux_agios.value===""){
	               cpt+=1;
	            taux_agios.style.borderColor='#FA6D63';
	        }if(date_deblocage.value===""){ 
	            cpt+=1;
	            date_deblocage.style.borderColor='#FA6D63';
	        }if(date_ouverture.value===""){
	            cpt+=1;
	            date_ouverture.style.borderColor='#FA6D63';
	            }
	        if(cpt!=0){
	            return 2;
	        }else{
	            return 1;
	        }
	    }
	    
	    static verifyAccountCourant(){
	         let cpt = 0;
	        let verify =0;
	        if(document.querySelector("#raison_social").value.trim()===""){
	           cpt+=1;
	        document.querySelector("#raison_social").style.borderColor='#FA6D63';
	        }if( document.querySelector("#taux_agios").value.trim()===""){
	               cpt+=1;
	             document.querySelector("#taux_agios").style.borderColor='#FA6D63';
	        }if(document.querySelector("#Adresse_Entreprise").value.trim()===""){ 
	            cpt+=1;
	        document.querySelector("#Adresse_Entreprise").style.borderColor='#FA6D63';
	        }if(document.querySelector("#nom_Entreprise").value.trim()===""){ 
	            cpt+=1;
	          document.querySelector("#nom_Entreprise").style.borderColor='#FA6D63';
	        }if(document.querySelector("#montant").value.trim()===""){ 
	            cpt+=1;
	           document.querySelector("#montant").style.borderColor='#FA6D63';
	        }if(document.querySelector("#cle_rib").value.trim()===""){ 
	            cpt+=1;
	           document.querySelector("#cle_rib").style.borderColor='#FA6D63';
	        }if(date_ouverture.value===""){
	            cpt+=1;
	            date_ouverture.style.borderColor='#FA6D63';
	            }
	        if(cpt!=0){
	            return 2;
	        }else{
	            return 1;
	        }
	    }
	    
	    static verifyAccountEpargne(){
	        let cpt = 0;
	        let verify =0;
	        if( document.querySelector("#taux_agios").value.trim()===""){
	               cpt+=1;
	             document.querySelector("#taux_agios").style.borderColor='#FA6D63';
	        }if(document.querySelector("#montant").value.trim()===""){ 
	            cpt+=1;
	           document.querySelector("#montant").style.borderColor='#FA6D63';
	        }if(document.querySelector("#cle_rib").value.trim()===""){ 
	            cpt+=1;
	           document.querySelector("#cle_rib").style.borderColor='#FA6D63';
	        }if(date_ouverture.value===""){
	            cpt+=1;
	            date_ouverture.style.borderColor='#FA6D63';
	            }
	        if(cpt!=0){
	            return 2;
	        }else{
	            return 1;
	        }
	    }
	    
	   static AccountBloque(){
	        UI_Compte.displayAll();
	        document.querySelector("#raison_social").setAttribute("disabled","");
	        document.querySelector("#nom_Entreprise").setAttribute("disabled","");
	        document.querySelector("#Adresse_Entreprise").setAttribute("disabled","");
	       
	       //for the required attribute 
	        document.querySelector("#date_deblocage").setAttribute("required","");
	        document.querySelector("#cle_rib").setAttribute("required","");
	        document.querySelector("#montant").setAttribute("required","");
	        document.querySelector("#date_m").setAttribute("required","");
	       document.querySelector("#frais").setAttribute("required","");
	       
	        
	        //atomate the field for frais compte 
	       document.querySelector("#choix").style.display='block';
	       document.querySelector("#choix2").style.display='none';
	    }
	    
	    static AccountEpargne(){
	        UI_Compte.displayAll();
	        document.querySelector("#raison_social").setAttribute("disabled","");
	        document.querySelector("#date_deblocage").setAttribute("disabled","");
	        document.querySelector("#Adresse_Entreprise").setAttribute("disabled","");
	        document.querySelector("#nom_Entreprise").setAttribute("disabled","");
	        
	        //remove the attribute reqired for specific fields 
	        document.querySelector("#cle_rib").setAttribute("required","");
	        document.querySelector("#montant").setAttribute("required","");
	        document.querySelector("#date_m").setAttribute("required","");
	        document.querySelector("#frais").setAttribute("required","");
	        
	        
	        //automate the field for frais compte 
	        document.querySelector("#choix").style.display='block';
	        document.querySelector("#choix2").style.display='none';
	    }
	    
	    static AccountCourant(){
	        UI_Compte.displayAll();
	        document.querySelector("#date_deblocage").setAttribute("disabled","");
	        
	        //remove the attribute required for specific fields
	         document.querySelector("#raison_social").setAttribute("required","");
	        document.querySelector("#nom_Entreprise").setAttribute("required","");
	    document.querySelector("#Adresse_Entreprise").setAttribute("required","");
	        document.querySelector("#cle_rib").setAttribute("required","");
	        document.querySelector("#montant").setAttribute("required","");
	        document.querySelector("#date_m").setAttribute("required","");
	        document.querySelector("#fraisR").setAttribute("required","");
	        
	        //automate field for frais compte 
	        document.querySelector("#choix").style.display='none';
	        document.querySelector("#choix2").style.display='block';
	    }
	}

	//get all the account
	UI_Compte.getTypeCompte();

	//hiddng the div 

	// var div = document.querySelector(".div");
	// setTimeout(()=>{
//	         document.querySelector("main").removeChild(div);
	// },5000)



		
	
	
	
	
	
	
	
	
	</script>
	
	
	
	
	
	
	
</body>
</html>