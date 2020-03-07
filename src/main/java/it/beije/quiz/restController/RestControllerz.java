package it.beije.quiz.restController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private QuizService quizService;

	@RequestMapping(value = { "/domande", "/domande/{libro}", "/domande/{libro}/{capitolo}",
			"/domande/{libro}/{capitolo}/{question}" }, method = RequestMethod.GET)
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
	@RequestMapping(value = { "/inserisci/{libro}", "/inserisci/{libro}/{capitolo}",
			"/inserisci/{libro}/{capitolo}/{domanda}" }, method = RequestMethod.POST)
	public @ResponseBody Libro inserisciLibroCapitolo(@RequestBody Libro libro,
			@PathVariable(required = false) Integer capitolo, @RequestBody(required = false) Domanda domanda,
			HttpServletResponse response) {
		// System.out.println("entro....."); //Debug
		List<Libro> listaLibri = new ArrayList<Libro>();
		String path = QuizService.BASE_DIRECTORY;
		File file = null;
		System.out.println(libro.getNameDir());
		if (libro != null) {

			file = new File(path + "\\" + libro.getNameDir());

			try {
				file.mkdir(); // crea la directory specificata
				quizService.createLibro(libro);
				listaLibri = quizService.leggiLibriInIndexXML(); // aggiorno listaLibri
				// System.out.println(listaLibri); //Debug
			} catch (SecurityException e) {
				response.setStatus(406);
				e.printStackTrace();
			}

			if (capitolo != null) {

				file = new File(path + libro.getNameDir() + "\\domande_cap" + capitolo + ".xml");
				// System.out.println(file); // Debug
				if (file.exists()) {
					// System.out.println("il file esiste già..."); // Debug
				} else {
					try {
						file.createNewFile(); // crea a tutti gli effetti il file a cui sta puntando attualmente.
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (domanda != null) {

					if (domanda.getBook().equals(libro.getTitle())) { // controllo Match LIBRO--DOMANDA

						if (Integer.parseInt(domanda.getChapter()) == capitolo) { // controllo Match CAPITOLO--DOMANDA

							quizService.caricaDomande(libro, "domande_cap" + capitolo, domanda);
						}

					}
				}

			}
		}

		return libro;
	}

	// @RequestMapping(value = "/new", method = RequestMethod.POST)
	// public @ResponseBody Domanda setDomanda(@RequestBody Domanda domanda,
	// HttpServletResponse response)
	// throws JsonParseException, JsonMappingException, IOException {
	// List<Libro> listL = Utils.leggiLibriInIndexXML();
	// for (Libro l : listL)
	// if (domanda.getBook().equals(l.getTitle())) {
	// String fileName = isNumber(domanda.getChapter()) ? ("domande_cap_" +
	// domanda.getChapter())
	// : ("domande_" + domanda.getChapter());
	// Utils.caricaDomande(l, fileName, domanda);
	// Cont.close();
	// return domanda;
	// }
	// response.setStatus(204);
	// return null;
	// }
	//
	// @RequestMapping(value = "/get/{bookDir}/{chapter}/{id}", method =
	// RequestMethod.PUT)
	// public @ResponseBody Domanda editDomanda(@PathVariable String bookDir,
	// @PathVariable String chapter,
	// @PathVariable String idDomandaToEdit, @RequestBody Domanda newDomanda,
	// HttpServletResponse response) {
	// ArrayList<Domanda> lista = Cont.getInstance();
	// for (Domanda d : lista) {
	// if (idDomandaToEdit.equals(d.getId()))
	// // d.editXML(newDomanda, bookDir);
	//
	// //
	// C:\\Users\\Gabriele\\git\\Quiz\\domande\\oca_manual\\domande_Assessment_Test.xml
	// // per postna http://localhost:8080/quiz/oca_manual/domande_Assessment_Test
	// return d;
	// }
	// response.setStatus(204);
	// return null;
	// }
	//

}