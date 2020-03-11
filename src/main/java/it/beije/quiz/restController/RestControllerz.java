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
	private static final String NEW_DOMANDA = "/creadomanda";
	private static final String NEW_LIBRO = "/inserisci/{libro}";
	private static final String NEW_LIBRO_CAPITOLO = "/inserisci/{libro}/{capitolo}";
	private static final String NEW_LIBRO_CAPITOLO_DOMANDA = "/inserisci/{libro}/{capitolo}/{domanda}";
	private static final String PUT_DOMANDE = "/aggiornadomande";
	private static final String DELETE_DOMANDE = "/eliminadomande";

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

	@RequestMapping(value = { NEW_DOMANDA }, method = RequestMethod.POST)
	public @ResponseBody Domanda inserisciLibroCapitoloDomanda(@RequestBody Domanda domanda,
			HttpServletResponse response) {

		List<Libro> listaLibri = quizService.leggiLibriInIndexXML();// metodo carica lista libri presenti;
		Libro newLibro = new Libro();
		String replace = domanda.getBook().replace("", "_");
		newLibro.setIdBook(replace);
		newLibro.setTitle(domanda.getBook());
		newLibro.setNameDir(replace);
		
		// setDir
		for (Libro l : listaLibri)
			if (l.getTitle().equals(domanda.getBook()))
				newLibro = l;
		newLibro = quizService.createLibro(newLibro);
		String dirDomanda = newLibro.getNameDir();
		System.out.println("dirDomanda:..........................:" + dirDomanda);
		StringBuilder path = new StringBuilder();

		String capitolo = Utils.isNumber(domanda.getChapter()) ? "domande_cap" + domanda.getChapter()
				: "domanda_" + domanda.getChapter();
		
		path.append(newLibro.getNameDir()).append("\\")
				.append(capitolo).append(".xml");
		System.out.println(path.toString());

		quizService.caricaDomande(newLibro, capitolo, domanda);

		return domanda;
	}

	// PUT_NEW_DOMANDA = "/aggiornadomande";
	// 08082020___GAB___method to update question. (finished).

	@RequestMapping(value = PUT_DOMANDE, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateListaDomande(HttpServletResponse response,
			@RequestBody Domanda... domandeJsonBody) {

		List<Domanda> listaGlobaleDomande = quizService.getDomande();

		for (Domanda domList : listaGlobaleDomande) { // Global Questions

			for (Domanda domJson : domandeJsonBody) { // JsonBody Question array.

				if (domJson.getId().equals(domList.getId())) {

					// Match. domList è la domanda da modificare nell'XML. d è la domanda che
					// prenderà il suo posto!!
					try {
						if (quizService.aggiornaDomandaInXML(domJson)) {
							return "File XML aggiornato Con successo ! ! !";
						}

					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(
								"qualcosa non va. (RestControllerz.class #==> aggiornaDomandaInXML(domList) <==#");
					}

				}
			}
		}

		return "File XML NON aggiornato !!!!!!!";
	}

	@RequestMapping(value = DELETE_DOMANDE, method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deleteListaDomande(HttpServletResponse response,
			@RequestBody String... idJsonBodyDomande) { // ["test_gabriele|1|1", ...]

		List<Domanda> listaGlobaleDomande = quizService.getDomande();

		for (Domanda domList : listaGlobaleDomande) { // Global Questions

			for (String domJson : idJsonBodyDomande) { // JsonBody Question array.

				if (domJson.equals(domList.getId())) {
					System.out.println("trovato match id domanda in json=" + domJson);
					System.out.println("id domanda in global list question:........." + domList);
					// Match. domList è la domanda da eliminare nell'XML.
					try {
						if (quizService.eliminaDomandaInXML(domList)) {
							return "File XML aggiornato Con successo ! ! ! (Operazione -- Eliminazione Elemento)";
						}

					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(
								"qualcosa non va. (RestControllerz.class #==> aggiornaDomandaInXML(domList) <==#");
					}

				}
			}
		}

		return "File XML NON aggiornato !!!!!!!";
	}

}