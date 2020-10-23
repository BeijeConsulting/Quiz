package it.beije.quiz.service;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Quiz;
import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.repository.DomandaRepository;
import it.beije.quiz.repository.RispostaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class QuizGeneratorService {
    @Autowired
    private QuizServiceNew quizServiceNew;
    @Autowired
    private DomandaRepository domandaRepository;
    @Autowired
    private RispostaDataRepository rispostaDataRepository;

    public void createNewQuiz(HttpServletRequest request,
                              HttpSession session){
        // Creo il quiz
        System.out.println("Creo nuovo quiz");
        Quiz quiz = new Quiz();
        // Imposta il nome. Se vuoto, crea un numero casuale e lo usa come nome
        quiz.setNomeQuiz(request.getParameter("nomeQuiz") != null
                ? request.getParameter("nomeQuiz")
                : Integer.toString(new Random().nextInt()));
        quiz.setIdUtente((Integer) session.getAttribute("userID"));
        Integer idQuiz = quizServiceNew.saveQuiz(quiz);
        session.setAttribute("idQuiz", idQuiz);

        // Creo le domande per il quiz
        System.out.println("Creo domande per quiz");
        String shuffle = request.getParameter("shuffle");
        String totDomandeString = request.getParameter("totDomande");
        String[] questions = request.getParameterValues("questions");
        List<Domanda> domande = new ArrayList<>();

        for (String s : questions){
            String[] divisi = s.split("-");
            domande.addAll(getDomande(Integer.parseInt(divisi[0]), Integer.parseInt(divisi[1])));
        }
        // Randomizzo le domande se richiesto dall'utente
        if (shuffle != null && shuffle.equalsIgnoreCase("true")){
            Collections.shuffle(domande);
        }
        // Se l'utente ha selezionato meno domande, qui ritorno solo quel numero max di domande
        domande = domande.subList(0, Integer.parseInt(totDomandeString));
        createQuestionsInDatabase(domande, session);
    }

    private List<Domanda> getDomande(Integer libro, Integer capitolo){
        return domandaRepository.findByBookIdAndChapter(libro, capitolo);
    }

    private void createQuestionsInDatabase(List<Domanda> domande, HttpSession session){
        for (Domanda d : domande){
            System.out.println("domanda: " + d);
            RisposteDate r = new RisposteDate();
            System.out.println(r);
            r.setIdDomanda(d.getId());
            r.setIdEsame((Integer) session.getAttribute("idQuiz"));
            r.setIdUtente((Integer) session.getAttribute("userID"));
            System.out.println(rispostaDataRepository.saveAndFlush(r).getRisposta());
        }
    }
}