package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientSImpl;
import dao.CompteBloqueImpl;
import dao.CompteCourantImpl;
import dao.CompteEpargneImpl;
import dao.IClientS;
import dao.ICompteBloque;
import dao.ICompteCourant;
import dao.ICompteEpargne;
import model.ClientS;
import model.CompteBloque;
import model.CompteCourant;
import model.CompteEpargne;

@WebServlet(urlPatterns = {"*.compte"})
public class CompteController extends HttpServlet {
	IClientS ics ;
	ICompteEpargne ice;
	ICompteCourant icourant;
	ICompteBloque ibloque;
	
	@Override
	public void init() throws ServletException {
		ics = new ClientSImpl();
		ice = new CompteEpargneImpl();
		icourant = new CompteCourantImpl();
		ibloque = new CompteBloqueImpl();
	}
	
	public void messandRedirect(String message,HttpSession ses 
			, HttpServletResponse resp) throws IOException {
		ses.setAttribute("message",message);
		resp.sendRedirect("mess.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pr = resp.getWriter();
		HttpSession ses = req.getSession();
		int j;
		if(req.getServletPath().equalsIgnoreCase("/mat.compte")){
			String mat = req.getParameter("matricule");
			
			if(mat.length()<4){
				
				 messandRedirect("LE MATRICULE EST INEXISTANT",ses , resp);				
				
			}else{
				
				//fetch the first three character of the matricule 
				String debutMat="";
				for(j=0;j<mat.length();j++) {
					if(j<3) {
						debutMat+=mat.charAt(j);
					}
				}
				
				
				if(!debutMat.equalsIgnoreCase("BPS") && !debutMat.equalsIgnoreCase("BCM")
						&& !debutMat.equalsIgnoreCase("BCI")) {
					
					messandRedirect("LE MATRICULE EST INEXISTANT",ses , resp);	
					
				}else{
					
					switch(debutMat) {
					case "BPS":
						int valbps = ics.findClienytByMat(mat);
						if(valbps==0) {
							messandRedirect("LE MATRICULE EST INEXISTANT",ses , resp);	
						}else {
							ClientS cls = ics.findByIdClient(valbps);
							if(cls!=null) {
								
								//set the session 
								ses.setAttribute("nomClient" ,cls.getNom()+" "+cls.getPrenom());
								
								//the id of the client
								ses.setAttribute("idClient", valbps);
								
								
								//redirection
								resp.sendRedirect("comptes/indexCompte.jsp");
							}else {
								messandRedirect("LE MATRICULE EST INEXISTANT",ses,resp);	
							}
						}
						break;
					case "BCI":
						int valbci = ics.findClienytByMat(mat);
						if(valbci==0) {
							messandRedirect("LE MATRICULE EST INEXISTANT",ses , resp);	
						}else {
							messandRedirect("LE MATRICULE EST DANS LA BASE",ses , resp);	
						}
						break;
					case "BCM":
						int valbcm = ics.findClienytByMat(mat);
						if(valbcm==0) {
							messandRedirect("LE MATRICULE EST INEXISTANT",ses , resp);	
						}else {
							messandRedirect("LE MATRICULE EST DANS LA BASE",ses , resp);	
						}
						break;
					}
					
				}	
			}
			
		}else if(req.getServletPath().equalsIgnoreCase("/add.compte")) {
			String typeCompte = req.getParameter("typeCompte");
			
			int id = (int)ses.getAttribute("idClient");
			int idRespo = (int)ses.getAttribute("idEmploye");
			
			switch(typeCompte) {
			case "Epargne":				
				int cle_rib = Integer.parseInt(req.getParameter("cle_rib"));
	            int numero_Agence  = (int)ses.getAttribute("idAgence");
	            String dateOuvert = req.getParameter("dateOuvert");
	             int montant = Integer.parseInt(req.getParameter("montant"));
	             
	             //create the compte_epargne class
	             CompteEpargne ce = new CompteEpargne( cle_rib, dateOuvert, montant);
	             ce.setIdAgence(numero_Agence);
	             ce.setIdClient(id);
	             ce.setIdREspoCompte(idRespo);
	             
	             //insert in the database 
	             int val =ice.insertCompteEpargne(ce);
	             
	             if(val!=0) {
	            	 messandRedirect("INSERTION EFFECTUEE AVEC SUCCESS !!!",ses , resp);	 
	             }else {
	            	 messandRedirect("ERREUR DURANT L'OPERATION ",ses , resp);	
	             }
	             
				break;
			case "Courant":
				//============== insert Compte Courant ===================
				
				//fetch the data from the form
				String nomEntreprise = req.getParameter("Name_entreprise");
				String adresEmployeur = req.getParameter("adresse_Entreprise");
				int cleRib = Integer.parseInt(req.getParameter("cle_rib"));
				int solde = Integer.parseInt(req.getParameter("montant"));
				String raison = req.getParameter("raison");
				
				//create the date
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String date = df.format(new Date());
				
				//retrieve the amount for create a courant 
				
				int final_solde = solde - icourant.getSoldeCreation();
				
				
				//create the compte_courant
				CompteCourant compte_courant = new CompteCourant(cleRib, date, nomEntreprise,
						adresEmployeur, raison, final_solde);
				
				//others stuff 
				compte_courant.setIdAgence((int)ses.getAttribute("idAgence"));
				compte_courant.setIdClient(id);
				compte_courant.setIdREspoCompte(idRespo);
				
				
				//insert in the database 
				int valeur = icourant.insertC_Courant(compte_courant);
				
				if(valeur!=0){
					messandRedirect("INSERTION EFFECTUEE ",ses , resp);
				}else{
					messandRedirect("ERREUR LORS DE L'OPERATION ",ses , resp);
				}
				
				
				break;
			case "Bloque":				
				//retrieve data from the form 
				int clerib = Integer.parseInt(req.getParameter("cle_rib"));
				String dateCreation = req.getParameter("dateOuvert");
				String dateDebloc = req.getParameter("");
				int soldeB = 0;
				
				int idClient = id ;
				int idRespoCompte = idRespo;
				
				//instantiate the account locked
				CompteBloque cb = new CompteBloque(clerib, dateCreation, dateDebloc,
						soldeB);
				cb.setIdAgence((int)ses.getAttribute("idAgence"));
				cb.setIdClient(idClient);
				cb.setIdREspoCompte(idRespoCompte);
				
				//insert in the database 
				int resultat = ibloque.insertCompteBloque(cb);
				
				//according to the result we redirect
				if(resultat!=0) {
					messandRedirect("INSERTION EFFECTUEE ",ses , resp);
				}else {
					messandRedirect("ERREUR DURANT L'OPERATION",ses , resp);
				}
				
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
	}
}
