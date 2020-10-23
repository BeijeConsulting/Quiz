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
		 String ultimoTitolo = "";
		 Long id = (long) 1;
		 for (Domanda domanda : domande) {
			 titoloLibro = domanda.getBook();
			 if (!titoloLibro.equals(ultimoTitolo)) {				 
				 Libro libro = new Libro();
				 libro.setId(id);
				 libro.setTitolo(titoloLibro);
				 libri.add(libro);
				 ultimoTitolo = titoloLibro;
				 id++;
			 }
		 }
		 return libri;
	}
}
