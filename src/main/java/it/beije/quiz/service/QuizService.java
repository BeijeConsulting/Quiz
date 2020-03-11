package it.beije.quiz.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;


@Service
public class QuizService {

	private static final String baseDirectory = "C:\\Users\\"+System.getProperty("user.name")+"\\git\\Quiz\\domande\\";
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
		for(File file : f.listFiles()) {
			if(file.isDirectory()) {
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
		StringBuilder path = new StringBuilder();
		path.append(baseDirectory)
		.append(Utils.getDirectory(dom.getId()) + "\\domande_cap" + Utils.getCapitolo(dom.getId()) + ".xml");
		Domanda domandaAgg=null;
		for (Domanda doma : domande) {
			if (doma.getId().equals(dom.getId())) {
				Utils.eliminaDomanda(doma, new File(path.toString()));
				Utils.aggiungiDomanda(dom, new File(path.toString()));
				domandaAgg=dom;
			} 	
		}		caricaDomande();

		return domandaAgg;



	}	
	public Domanda insertDomanda(Domanda domanda){
		caricaDomande();
		boolean vero = false;
		StringBuilder path = new StringBuilder();
		String dir=Utils.getDirectory(domanda.getId());

		for (Libro l : getListaLibri()) {
			if (dir.equals(l.getDir())) {
				vero = true;
				break;
			}
		}
		path.append(getBaseDirectory()).append(dir);
		File file = new File(path.toString());
		if (vero != true) {
			file.mkdir();
			Libro l = new Libro();
			l.setDir(dir);
			l.setIdBook(dir);
			l.setTitle(domanda.getBook());
			getListaLibri().add(l);
			try {
				Utils.scriviSuXML(getListaLibri(), baseDirectory+"index.xml");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		String pathdomanda = path.toString() + "\\" + "domande_cap" + domanda.getChapter() + ".xml";
		File file1 = new File(pathdomanda);
		Utils.aggiungiDomanda(domanda, file1);
		domande.add(domanda);
		return domanda;

	}
	public void elimina(Domanda d) {
		caricaDomande();
		StringBuilder path = new StringBuilder(
				baseDirectory + Utils.getDirectory(d.getId()) + "\\domande_cap" + d.getChapter()+ ".xml");
		String pathdomanda = path.toString();
		File file2 = new File(pathdomanda);
		Utils.eliminaDomanda(d, file2);
		caricaDomande();
	}		
}