package it.beije.quiz;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.quiz.Utils;
import it.beije.quiz.model.*;

/**
 * Servlet implementation class AggiungiDomandaServlet
 */
@WebServlet("/AggiungiDomandaServlet")
public class AggiungiDomandaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println(request.getParameter("param_testo"));
		String libro= request.getParameter("param_libro");
		int id=Integer.parseInt( request.getParameter("param_id"));
		int capitolo= Integer.parseInt(request.getParameter("param_capitolo"));
		int idDomanda=Integer.parseInt( request.getParameter("param_nDomanda"));
		String testo= request.getParameter("param_testo");
		String[] risposte= request.getParameter("param_risposte").split(",");
		String type= request.getParameter("param_type");
		String risposteEsatte= request.getParameter("param_risposteEsatte");
		String spiegazione= request.getParameter("param_spiegazione");

		
		List<Risposta> listRisposte= new ArrayList<Risposta>();
		Risposta ris= null;
		for(int i=0; i<risposte.length;i++) {
			ris= new Risposta();
			ris.setText(risposte[i]);
			ris.setValue(Character.toString((char)(65+i)));
			listRisposte.add(ris);
			System.out.println(ris.getValue());
		}
		
		Domanda domanda= new Domanda(id,libro,capitolo,idDomanda,testo,type,listRisposte,risposteEsatte,spiegazione);
		
		
		File fileXML=new File("C:\\Users\\Padawan14\\git\\Quiz\\QuizdomandeProva.xml");
//		response.sendRedirect("./aggiungiDomanda.jsp");
		Utils.aggiungiDomanda(domanda, fileXML);
		
		
		List <Domanda> listaDomande=Utils.readFileDomande(fileXML.getPath());
		StringBuilder visualDomande= new StringBuilder();
		
		for(Domanda d: listaDomande)
			visualDomande.append(d.toString());
		response.getWriter().append(visualDomande);
	}

}
