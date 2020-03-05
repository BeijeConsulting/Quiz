package it.beije.quiz.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;


@Service
public class QuizService {
	
	private static final String baseDirectory = "C:\\Users\\Padawan14\\git\\Quiz\\domande\\";
	private static List<Libro> listaLibriInXML = null;

	
	public String getBaseDirectory() {
		return baseDirectory;
	}

	public  List <Libro> getListaLibri(){
		if(listaLibriInXML==null)
			listaLibriInXML=Utils.caricaLibriDaIndexXML(baseDirectory+"index.xml");
		
		return listaLibriInXML;
	}


	public QuizService() {
		System.out.println("Creo istanza di QuizService");
	}

	private List<Domanda> domande = null;

	private void caricaDomande() {
		domande = new ArrayList<Domanda>();
		File f = new File(baseDirectory);
		String dir = "";
		for(File file : f.listFiles()) {
			if(file.isDirectory()) {
				dir = file.getName();
				for(File ff : file.listFiles()) {
					domande.addAll(Utils.readFileDomande(ff.getPath()));
				}
			} 
		}
	}

	public List<Domanda> getDomande() {
		if (domande == null) {
			caricaDomande();
		}

		return domande;
	}
	
	public Domanda aggiornaDomanda(Domanda dom) {
		caricaDomande();
		StringBuilder path = new StringBuilder();
		path.append(baseDirectory)
				.append(Utils.getDirectory(dom.getId()) + "\\domande_cap" + Utils.getCapitolo(dom.getId()) + ".xml");
		List <Domanda> nuoveDomande=new ArrayList<Domanda>();
		Domanda domandaAgg=null;
		for (Domanda doma : domande) {
			if (doma.getId().equals(dom.getId())) {
				nuoveDomande.add(dom);
				Utils.eliminaDomanda(doma, new File(path.toString()));
				Utils.aggiungiDomanda(dom, new File(path.toString()));
				domandaAgg=dom;
			} else {
				nuoveDomande.add(doma);
			}
			
		}
		domande=nuoveDomande;
		return domandaAgg;

		

	}	
	
		
		
	
	
}