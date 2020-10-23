package it.beije.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Libro;
import it.beije.quiz.repository.DomandaRepository;

@Service
public class DomandaService {
	@Autowired
	DomandaRepository domandaRepository;
	
	@Transactional
	public Domanda insert(Domanda domanda) {
		return domandaRepository.saveAndFlush(domanda);
	}

	public List<Libro> getBooks() {
		 List<Domanda> domande = domandaRepository.findAll();
		 List<Libro> libri = new ArrayList<>();
		 String titoloLibro = "";
		 List<String> titoliSalvati = new ArrayList<String>();
		 Long id = (long) 1;
		 for (Domanda domanda : domande) {
			 titoloLibro = domanda.getBook();
			 if (!titoliSalvati.contains(titoloLibro)) {				 
				 Libro libro = new Libro();
				 libro.setId(id);
				 libro.setTitolo(titoloLibro);
				 libri.add(libro);
				 titoliSalvati.add(titoloLibro);
				 id++;
			 }
		 }
		 return libri;
	}
	
	public List<String> getBooksNames() {
		List<Domanda> domande = domandaRepository.findAll();
		List<String> libri = new ArrayList<String>();
		
		for(Domanda domanda : domande) {
			if(!libri.contains(domanda.getBook())) {
				libri.add(domanda.getBook());
			}
		}
		
		return libri;
	}
	
	public List<String> getBooksChapters(String book) {
		List<Domanda> domande = domandaRepository.findByBook(book);
		List<String> capitoli = new ArrayList<String>();
		
		for(Domanda domanda : domande) {
			if(!capitoli.contains("Capitolo " + domanda.getChapter().toString())) {
				capitoli.add("Capitolo " + domanda.getChapter().toString());
			}
		}
		
		return capitoli;
	}
}
