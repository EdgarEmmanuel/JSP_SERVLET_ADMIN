package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/caissiereIndex","*.caiss","*.da_caiss"})
public class CaissiereController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void init() throws ServletException {
		
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
	
	
	public void traitement_retrait(PrintWriter pr) {
		pr.print("action retrait");
	}
	
	public void action_depot(PrintWriter pr) {
		pr.print("action depot");
	}
	
	public void action_virement(PrintWriter pr) {
		pr.print("action virement");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pr = resp.getWriter();
		if(req.getServletPath().equalsIgnoreCase("/depot_action.caiss")) {
			action_depot(pr);
		}else if(req.getServletPath().equalsIgnoreCase("/retrait_action.caiss")){
			traitement_retrait(pr);
		}else if(req.getServletPath().equalsIgnoreCase("/retrait_action.caiss")) {
			action_virement(pr);
		}
	}

}
