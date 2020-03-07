package it.beije.quiz.restController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.Utils;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.service.QuizService;

@RestController
public class RestControllerz {

	private static final String GET_DOMANDE = "/domande";
	private static final String GET_DOMANDE_LIBRO = "/domande/{libro}";
	private static final String GET_DOMANDE_LIBRO_CAPITOLO = "/domande/{libro}/{capitolo}";
	private static final String GET_DOMANDA = "/domande/{libro}/{capitolo}/{question}";
	private static final String NEW_LIBRO = "/inserisci/{libro}";
	private static final String NEW_LIBRO_CAPITOLO = "/inserisci/{libro}/{capitolo}";
	private static final String NEW_LIBRO_CAPITOLO_DOMANDA = "/inserisci/{libro}/{capitolo}/{domanda}";
	// private static final String PUT_LIBRO = "/modifica/{libro}";
	// private static final String PUT_CAPITOLO = "/modifica/{libro}/{capitolo}";
	private static final String PUT_DOMANDA = "/updatedomanda/{id}";

	@Autowired
	private QuizService quizService;

	@RequestMapping(value = { GET_DOMANDE, GET_DOMANDE_LIBRO, GET_DOMANDE_LIBRO_CAPITOLO,
			GET_DOMANDA }, method = RequestMethod.GET)
	public @ResponseBody List<Domanda> getDomande(@PathVariable(required = false) String libro,
			@PathVariable(required = false) String capitolo, @PathVariable(required = false) String question) {

		List<Domanda> listaDomande = quizService.getDomande();

		if (libro != null) {
			listaDomande = QuizService.domandeLibro(listaDomande, libro);
			System.out.println("n° domande nel libro:" + listaDomande.size()); // Debug

			if (capitolo != null) {
				listaDomande = QuizService.domandeCapitolo(listaDomande, capitolo);
				System.out.println("n° domande del capitolo:" + listaDomande.size()); // Debug

				if (question != null) {
					listaDomande = QuizService.domandeQuestion(listaDomande, question);
					System.out.println("domanda:" + listaDomande.get(0)); // Debug

				}
			}
		}
		return listaDomande;
	}

	// 5032020_GAB_metodo che inserisce un nuovo libro e volendo un nuovo
	// capitolo(vuoto) e volenda una nuova domanda.
	@RequestMapping(value = { NEW_LIBRO, NEW_LIBRO_CAPITOLO, NEW_LIBRO_CAPITOLO_DOMANDA }, method = RequestMethod.POST)
	public @ResponseBody Libro inserisciLibroCapitoloDomanda(@PathVariable String libro,
			@PathVariable(required = false) String capitolo, @RequestBody(required = false) Domanda domanda,
			HttpServletResponse response) {

		List<Libro> listaLibri = new ArrayList<Libro>();
		String path = QuizService.BASE_DIRECTORY;
		File file = null;
		Libro libroz = new Libro();
		String fileName = "";

		if (libro != null) {
			try {
				libroz = quizService.parseLib(libro);
				System.out.println(libroz);
				file = new File(path + libroz.getNameDir());
				System.out.println(file);
				file.mkdir();
			} catch (SecurityException e) {
				response.setStatus(406);
				e.printStackTrace();
			}

			if (capitolo != null) {

				fileName = Utils.isNumber(capitolo) ? "domande_cap" + capitolo : "domande_" + capitolo;
				System.out.println(fileName);
				file = new File(path + libroz.getNameDir() + "\\" + fileName + ".xml");
				System.out.println("riga 93:" + file);
				// System.out.println(file); // Debug
				if (file.exists()) {
					System.out.println("il file esiste già..."); // Debug
				} else {
					try {
						file.createNewFile(); // crea a tutti gli effetti il file a cui sta puntando attualmente.
						FileWriter writer = new FileWriter(file);
						writer.append("<?xml version=\"1.0\" ?>\n");
						writer.append("<domande>\n\n");
						writer.append("</domande>");
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (domanda != null) {
					// System.out.println("domanda non è nulla");

					if (domanda.getBook().equals(libroz.getTitle())) { // controllo Match LIBRO--DOMANDA

						if (domanda.getChapter().equals(capitolo)) { // controllo Match CAPITOLO--DOMANDA
							System.out.println("2......:" + file.getPath());
							try {
								quizService.writeDomandeXML(domanda, file.getPath());
							} catch (Exception e) {
								e.printStackTrace();
								System.out.println(":!...Error...!:");
							}
						}

					}
				}

			}
		}

		return libroz;
	}

	
	
	// 07032020___GAB___method to update quetion. (not finished).
	@RequestMapping(value = { PUT_DOMANDA }, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean aggiornaDomanda(@RequestBody Domanda domanda, @PathVariable String id) {
		System.out.println("entro");
		String idUnivocoDomanda = domanda.getId();
		System.out.println("aggiornaDomanda RestControllerz:..........:" + idUnivocoDomanda);

		System.out.println("Directory della domanda...............:" + Utils.getDirectoryFromDomanda(domanda));

		String pathCapitolo = Utils.isNumber(domanda.getChapter()) ? "domande_cap" + domanda.getChapter()
				: "domande_" + domanda.getChapter();
		System.out.println(pathCapitolo);

		List<Domanda> listaDomande = quizService.getDomande();
		QuizService.domandeLibro(listaDomande, domanda.getBook());
		System.out.println("numeroDomandeDopoScrematuraPerLibro:...............:" + listaDomande.size());
		QuizService.domandeCapitolo(listaDomande, pathCapitolo);
		System.out.println("numeroDomandeDopoScrematuraPerCapitolo:...............:" + listaDomande.size());
		QuizService.domandeQuestion(listaDomande, String.valueOf(domanda.getQuestion()));
		System.out.println("numeroDomandeDopoScrematuraPerDomanda:...............:" + listaDomande.size());

		for (Domanda dom : listaDomande) {
			if (dom.getId().equals(idUnivocoDomanda)) {
				// MATCH DOMANDA DA MODIFICARE.....
				try {
					quizService.aggiornaDomandaInXML(domanda);

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("!-###--presa eccezione aggiornaDomanda ResControllerz Class--###-!");
				}
			}
		}

		return false;
	}

}