package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AgenceImpl;
import dao.BD;
import dao.CIndependantImpl;
import dao.ClientMoralImpl;
import dao.ClientSImpl;
import dao.IAgence;
import dao.IClientInde;
import dao.IClientMoral;
import dao.IClientS;
import dao.ISecretaire;
import dao.SecretaireImpl;
import metier.IRespoCompte;
import metier.RespImpl;
import model.Agence;
import model.ClientIndep;
import model.ClientMoral;
import model.ClientS;
import model.RespoCompte;
import model.Secretaire;

@WebServlet(urlPatterns = {"*.da"})
public class ControllerProj extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BD bd;
	IRespoCompte irc;
	IAgence iagence;
	IClientInde iclINde;
	IClientMoral icm;
	private ISecretaire isecretaire;
	
	@Override
	public void init() throws ServletException {
		bd = new BD();
		irc= new RespImpl();
		iagence = new AgenceImpl(); 
		iclINde = new CIndependantImpl();
		icm = new ClientMoralImpl();
		isecretaire = new SecretaireImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("path :"+req.getServletPath());
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
	
	public void redirect(int value,HttpSession ses,HttpServletResponse resp) throws IOException {
		if(value!=0) {
			ses.setAttribute("message", "INSERTION REUSSIE");
		}else {
			ses.setAttribute("message", "ERREUR D'INSERTION");
		}
		
		resp.sendRedirect("mess.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession ses = req.getSession();
		
		RequestDispatcher rd;
		PrintWriter pr = resp.getWriter();
		
		if(req.getServletPath().equalsIgnoreCase("/test.da")) {
			//fetch the content from the form
			String personne = req.getParameter("type");
			String login = req.getParameter("login");
			String pwd = req.getParameter("password");
			String btn = req.getParameter("btn");
			
			
			switch(personne){
			case "responsable":
				RespoCompte responsable = irc.getRespoByLog(login, pwd);
				if(responsable == null){
					
					rd = req.getRequestDispatcher("index.jsp");
					rd.forward(req, resp);
					
				}else{
					
					//get the informations about Agence 
					Agence ag = iagence.getAgenceByIdResponsable(responsable.getIdEmploye());					
					
					//set the id of the Agence 
					ses.setAttribute("idAgence", ag.getIdAgence());
					
					//set the name of the agence 
					ses.setAttribute("nameAgence", ag.getNumeroAgence());
					
					//set the id of the Employe
					ses.setAttribute("idEmploye", responsable.getIdEmploye());
					
					//set the complete name of the respoCompte 
					ses.setAttribute("NomCompletRespo", responsable.getNom()+" "+
					responsable.getPrenom());
					
					//set the matricule of the Responsable 
					ses.setAttribute("matriculeResp", responsable.getMatricule());				
					
					//redirection
					resp.sendRedirect("responsable/indexRespo.jsp");
				}
				break;
				
			case "administrateur":
				pr.print("administrateur ");
				break;
			case "caissiere":
				Secretaire sc = isecretaire.findByLoginAndPassword(login, pwd);
				if(sc!=null) {
					
				}else {
					
				}
				break;
			}
			
			
		}else if(req.getServletPath().equalsIgnoreCase("/addSalarie.da")) {
			pr.print("AddSalarie");
			
			
			//fech  all the data from the form 
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String telephone= req.getParameter("telephone");
			String email = req.getParameter("email");
			String adresseEntreprise = req.getParameter("adresseforCl");
			String cni = req.getParameter("cni");
			String nomEntreprise = req.getParameter("nom_Entreprise");
			String profession = req.getParameter("profession");
			
			//instantiate the client Salarie 
			
			ClientS cls = new ClientS(email,telephone, nom, prenom, nomEntreprise, adresseEntreprise, cni,
					profession);
			
			//insert the client 
			IClientS ic = new ClientSImpl();
			int ok = ic.insertSalarie(cls);
			
			if(ok!=0) {
				req.setAttribute("mess", "OPERATION REUSSIE");
			}else {
				req.setAttribute("mess", "OPERATION NON REUSSIE ");
			}
			
			
			//redirection
			req.getRequestDispatcher("mess.jsp").forward(req, resp);
			
			
		}else if(req.getServletPath().equalsIgnoreCase("/decon.da")) {
			
			//pr.print("logout button");
			ses.invalidate();
			resp.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
			resp.sendRedirect("index.jsp");
			
		}else if(req.getServletPath().equalsIgnoreCase("/addInde.da")) {
			
			//=============== FOR INSERT CLIENT INDEPENDANT ===============
			
			//fetch the data from the form 
			String nomI = req.getParameter("nom");
			String prenomI = req.getParameter("prenom");
			String activite = req.getParameter("activite");
			String localisation = req.getParameter("localisation");
			String cni = req.getParameter("cni");
			String telephone = req.getParameter("telephone");
			String email = req.getParameter("email");
			String mat=new CIndependantImpl().getMatricule();
			
			//instantiate the class client independant 
			ClientIndep cli = new ClientIndep(email, telephone, nomI, prenomI, localisation, cni, 
					activite,mat);
			
			//insert in the database 
			int ok = iclINde.insertIndependant(cli);
			
			
			//insert ans redirection 
			redirect(ok,ses,resp);
			
			
			
		}else if(req.getServletPath().equalsIgnoreCase("/moral.da")) {
			//insert client moral 
			pr.println("add client moral ");
			
			String nomEntr = req.getParameter("nom");
			String adreseEntre = req.getParameter("adresse");
			String telephone = req.getParameter("telephone");
			String email = req.getParameter("email");
			String typeEntreprise  = req.getParameter("type");
			String activiteEntreprise =req.getParameter("activite");
			int ninea = Integer.parseInt(req.getParameter("ninea"));
			String mat= new ClientMoralImpl().getMatricule();
			
			
			//instantiate the client_moral 
			ClientMoral clm = new ClientMoral(email, telephone, nomEntr,
					adreseEntre,
					typeEntreprise, ninea, activiteEntreprise,mat);
			
			
			//insert in the database 
			int ok = icm.insertClientMoral(clm);
			
			//redirect with the mess 
			redirect(ok,ses,resp);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
