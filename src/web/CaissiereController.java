package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.operation_banque.CourantOperationImpl;
import dao.operation_banque.IOperation_Bancaire;
import helper.VerifyNumAccount;

@WebServlet({"/caissiereIndex","*.caiss","*.da_caiss"})
public class CaissiereController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IOperation_Bancaire ioperation;


	@Override
	public void init(){
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("base", "http://localhost:8081/addCompte_Proj/WebContent/");
		if(req.getServletPath().equalsIgnoreCase("/retrait.da_caiss")){
			resp.sendRedirect("caissiere/views/retrait.jsp");
		}else if(req.getServletPath().equalsIgnoreCase("/depot.da_caiss")){
			resp.sendRedirect("caissiere/views/depot.jsp");
		}else if(req.getServletPath().equalsIgnoreCase("/virement.da_caiss")) {
			resp.sendRedirect("caissiere/views/virement.jsp");
		}else{
			resp.sendRedirect("caissiere/views/index_caiss.jsp");
		}
	}
	
	
	public void traitement_retrait(PrintWriter pr,HttpServletRequest req, HttpServletResponse resp) {
		pr.print("action retrait");
	}
	
	public void action_depot(PrintWriter pr,HttpServletRequest req, HttpServletResponse resp) {
		String numeroCompte = req.getParameter("compte");
		int montantDepot = Integer.parseInt(req.getParameter("montant"));
		
		//si le compte existe avec ses deux premiers caracteres 
			int val = new VerifyNumAccount().getTheAccount(numeroCompte);
			
			
			//aller chercher dans la table correspondante 
			switch(val) {
				case 1:
					//verifier si compte existe 
					break;
				case 2:
					//verifier si compte epargne existe 
					break;
				case 3:
					//verifier si compte bloque existe 
					break;
				case 0:
					//throw an error  
					break;
			}
			
	}
	
	
	public void action_virement(PrintWriter pr,HttpServletRequest req, HttpServletResponse resp) {
		pr.print("action virement");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pr = resp.getWriter();
		if(req.getServletPath().equalsIgnoreCase("/depot_action.caiss")) {
			action_depot(pr,req,resp);
		}else if(req.getServletPath().equalsIgnoreCase("/retrait_action.caiss")){
			traitement_retrait(pr,req,resp);
		}else if(req.getServletPath().equalsIgnoreCase("/retrait_action.caiss")) {
			action_virement(pr,req,resp);
		}
	}

}
