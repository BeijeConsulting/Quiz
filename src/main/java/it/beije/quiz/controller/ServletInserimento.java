package it.beije.quiz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.quiz.Test;
import it.beije.quiz.Utils;
import it.beije.quiz.model.*;


@WebServlet("/servletInserimento")
public class ServletInserimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String PATH = Test.PATH;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rispEsatta = request.getParameter("rispostaEsatta").trim().replace(",", "").replace(" ", "");
		
		ArrayList<Risposta> risposte = new ArrayList<>();
		String[] arr = request.getParameter("strRisposte").split("\n");
		
		char i='A';
		for(int j=0; j<arr.length; j++) {
			if(!arr[j].equals("")){
				Risposta r = new Risposta();
				r.setValue((char)i+"");
				r.setText(arr[j]);
				risposte.add(r);
				i++;
			}
		}
		
		List<Domanda> domandePresenti = Utils.readFileDomande(PATH);
		
		Domanda dom = new Domanda(domandePresenti.get(domandePresenti.size()-1).getId()+1, request.getParameter("book"), 
				 Integer.parseInt(request.getParameter("chapter")), Integer.parseInt(request.getParameter("question")),
				 request.getParameter("testo"), (rispEsatta.length()==1? "radio" : "checkbox"), risposte, rispEsatta.toUpperCase(), request.getParameter("spiegazione"));
		
		try {
			Utils.writeFileDomande(dom, PATH);
			response.getWriter().append("Aggiornato");
		}catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append("Errore durante il salvataggio");
		}
	}

}