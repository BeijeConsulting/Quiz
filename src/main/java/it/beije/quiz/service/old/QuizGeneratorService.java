package it.beije.quiz.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Question;
import it.beije.quiz.repository.AnswerRepository;
import it.beije.quiz.repository.QuestionRepository;

import java.util.List;

@Service
public class QuizGeneratorService {
    @Autowired
    private TestService testService;
    @Autowired
    private QuestionRepository questionRepo;
    @Autowired
    private AnswerRepository answerRepo;

    // Todo rifare
//    public void createNewQuiz(HttpServletRequest request,
//                              HttpSession session){
//        // Creo il quiz
//        System.out.println("Creo nuovo quiz");
//        Test test = new Test();
//        // Imposta il nome. Se vuoto, crea un numero casuale e lo usa come nome
//        test.setName(request.getParameter("nomeQuiz") != null
//                ? request.getParameter("nomeQuiz")
//                : Integer.toString(new Random().nextInt()));
//        test.setUserId((Integer) session.getAttribute("userID"));
//        Integer idTest = testService.createTest(test);
//        session.setAttribute("idQuiz", idTest);
//
//        // Creo le domande per il quiz
//        System.out.println("Creo domande per quiz");
//        String shuffle = request.getParameter("shuffle");
//        String totDomandeString = request.getParameter("totDomande");
//        String[] questions = request.getParameterValues("questions");
//        List<Question> domande = new ArrayList<>();
//
//        for (String s : questions){
//            String[] divisi = s.split("-");
//            domande.addAll(getQuestions(Integer.parseInt(divisi[0]), Integer.parseInt(divisi[1])));
//        }
//        // Randomizzo le domande se richiesto dall'utente
//        if (shuffle != null && shuffle.equalsIgnoreCase("true")){
//            Collections.shuffle(domande);
//        }
//        // Se l'utente ha selezionato meno domande, qui ritorno solo quel numero max di domande
//        domande = domande.subList(0, Integer.parseInt(totDomandeString));
//        createQuestionsInDatabase(domande, session);
//    }

    private List<Question> getQuestions(Integer id_chapter){
    	return questionRepo.findByChapter(id_chapter);
    }
}