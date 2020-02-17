package it.beije.quiz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.LiveForm;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int id_domanda=0;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		LiveForm live =(LiveForm) request.getSession().getAttribute("liveForm");
		live.setNumeroRisposte(Integer.parseInt(request.getParameter("numeroRisposte")));
		live.setPrimoGiro(false);
		
		
		String book = request.getParameter("book");
		int chapter = Integer.parseInt(request.getParameter("chapter"));
		String testo = request.getParameter("testo");
		String answerType = request.getParameter("answerType");
		
		
		request.getSession().setAttribute("domanda", new Domanda(id_domanda++,book,chapter,id_domanda,testo,answerType));
		request.getSession().setAttribute("liveForm", live);
		response.sendRedirect("NewDomanda.jsp");
	}

		

}
=======
		// TODO Auto-generated method stub
		LiveForm live =(LiveForm) request.getSession().getAttribute("liveForm");
		live.setNumeroRisposte(Integer.parseInt(request.getParameter("numeroRisposte")));
		live.setPrimoGiro(false);
		
		
		String book = request.getParameter("book");
		int chapter = Integer.parseInt(request.getParameter("chapter"));
		String testo = request.getParameter("testo");
		String answerType = request.getParameter("answerType");
		
		
		request.getSession().setAttribute("domanda", new Domanda(id_domanda++,book,chapter,id_domanda,testo,answerType));
		request.getSession().setAttribute("liveForm", live);
		response.sendRedirect("NewDomanda.jsp");
	}

}
>>>>>>> refs/remotes/origin/padawan08
