package it.beije.quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.quiz.model.*;


/**
 * Servlet implementation class insertDomanda
 */
@WebServlet("/InsertDomanda")
public class InsertDomanda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDomanda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("f at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Risposta> listaRisposte = new ArrayList<Risposta>();
		
		int domanda = Integer.parseInt(((String)request.getParameter("numDomanda")));
		int capitolo = Integer.parseInt(((String)request.getParameter("numCapitolo")));
		String book = (String)request.getParameter("bookName");
		String testo = (String)request.getParameter("testoDomanda");
		String answerType = (String)request.getParameter("typeQuestion");
		
		int i = 1;
		while((String)request.getParameter("risposta" + i) != null) {
			Risposta r = new Risposta();
			r.setValue((String)request.getParameter("valueRisposta" + i));
			r.setText((String)request.getParameter("risposta" + i));
			listaRisposte.add(r);
			i++;
		}
		
		String risposteCorrette = (String)request.getParameter("risposteEsatte");
		String spiegazione = (String)request.getParameter("spiegazione");
		
		Domanda d = new Domanda(domanda, book, capitolo, domanda, testo, answerType, listaRisposte, risposteCorrette, spiegazione);
		
		response.sendRedirect("confermainserimento.jsp");	

	}

}
