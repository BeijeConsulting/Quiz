package it.beije.quiz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.quiz.Test;
import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;

/**
 * Servlet implementation class ServletQuiz
 */
@WebServlet("/servletQuiz")
public class ServletQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Domanda> lista= Utils.readFileDomande(Test.PATH);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletQuiz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int index = (int) request.getSession().getAttribute("index");
		if(index<=lista.size()) {
			request.getSession().setAttribute("domanda", lista.get(index));
			response.sendRedirect("rispondiAlleDomande.jsp");
		}
		else response.sendRedirect("revisione.jsp");
	}

}
