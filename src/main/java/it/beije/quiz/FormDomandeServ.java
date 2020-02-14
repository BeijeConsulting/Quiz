package it.beije.quiz;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;


/**
 * Servlet implementation class FormDomandeServ
 */
@WebServlet("/FormDomandeServ")
public class FormDomandeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormDomandeServ() {
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
		Domanda domanda = (Domanda) request.getSession().getAttribute("domanda");
		if (domanda == null) {
			
			String[] risposte= request.getParameter("risposte").split("-");
			List<Risposta> listaRisposte= new ArrayList<>();
			for(int i=0;i<risposte.length;i++)
			{
				Risposta r = new Risposta();		
				r.setText(risposte[i]);
				r.setValue(""+(char)('A'+i));
				listaRisposte.add(r);
			}
			
			try {
					domanda = new Domanda( Integer.parseInt(request.getParameter("id")), request.getParameter("book"), 
								  Integer.parseInt(request.getParameter("chapter")),
								  Integer.parseInt(request.getParameter("question")), request.getParameter("testo"), 
					              request.getParameter("answerType"), listaRisposte, request.getParameter("rispostaEsatta"),
					              request.getParameter("spiegazione"));
								  request.getSession().setAttribute("domanda", domanda);
			} catch(NumberFormatException e)
			{
				response.getWriter().append("parametri errati");
			}
		}
		List<Domanda> beanDomanda =new ArrayList<>();
		beanDomanda.add(domanda);
		try {
			writeContattiInFile(beanDomanda, "c:/work/domande.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append(domanda.toString());
	}
	
	
		public static void writeContattiInFile(List<Domanda> beanDomanda, String pathfile) throws Exception {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();

	        Document document = builder.newDocument();
	        Element docElement = document.createElement("domande");
	        document.appendChild(docElement);
	        
	        for (Domanda d : beanDomanda) {
	        	Element domanda = document.createElement("domanda");
	        	
	        	Element testo = document.createElement("testo");
	        	Element risposte = document.createElement("risposte");
	        	for(int i=0;i<d.getRisposte().size();i++)
	        	{
	        		Element risposta = document.createElement("risposta");
	        		risposta.setAttribute("value", d.getRisposte().get(i).getValue());
	        		risposta.setTextContent(d.getRisposte().get(i).getText());
	        		risposte.appendChild(risposta);
	        	}
	        	Element risposteEsatte = document.createElement("risposteEsatte");
	        	Element spiegazione = document.createElement("spiegazione");
	        	
	        	domanda.setAttribute("id", ""+d.getId());
	        	domanda.setAttribute("book", d.getBook());
	        	domanda.setAttribute("chapter", ""+d.getChapter());
	        	domanda.setAttribute("question", ""+d.getQuestion());
	        	risposte.setAttribute("type", d.getAnswerType());
	        
	        	
	        	
	        	
	        	testo.setTextContent(d.getTesto());
	        	risposteEsatte.setTextContent(d.getRispostaEsatta());
	        	spiegazione.setTextContent(d.getSpiegazione());
	        
	        	
	        	domanda.appendChild(testo);
	        	domanda.appendChild(risposte);
	        	domanda.appendChild(risposteEsatte);
	        	domanda.appendChild(spiegazione);

	        	docElement.appendChild(domanda);
	        }

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(pathfile));

			// Output to console for testing
			//StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");
		}
		
//		public static void main(String[] args) throws Exception {
//			List<Contatto> contatti = getContattiFromFile("xml/rubrica.xml");
//			writeContattiInFile(contatti, "xml/rubrica-copia.xml");
//		}

	
	}


