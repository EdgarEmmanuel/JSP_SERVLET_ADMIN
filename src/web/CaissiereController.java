package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter pr = resp.getWriter();
		if(req.getServletPath().equalsIgnoreCase("/retrait.da_caiss")) {
			pr.print("<h1>RETRAIT</h1>");
		}else if(req.getServletPath().equalsIgnoreCase("/depot.da_caiss")){
			pr.print("<h1>DEPOT</h1>");
		}else{
			resp.sendRedirect("caissiere/views/index_caiss.jsp");
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
