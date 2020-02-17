package it.beije.quiz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.quiz.model.Domanda;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Domanda domanda = (Domanda)request.getAttribute("domanda");
		System.out.println(domanda.getId());
		System.out.println(domanda.getBook());
		System.out.println(domanda.getChapter());
		System.out.println(domanda.getQuestion());
		System.out.println(domanda.getTesto());
		
		response.sendRedirect("NewDomanda.jsp");
	}
	
	

}