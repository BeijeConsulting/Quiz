package it.beije.quiz.controller;

import it.beije.quiz.service.QuizGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class StartQuizController {
    @Autowired
    private QuizGeneratorService quizGeneratorService;

    @PostMapping("/startQuiz")
    public String startQuiz(HttpServletRequest request, HttpSession session){
        // TODO rimuovere è solo per debugging
        session.setAttribute("userID", 5);

        quizGeneratorService.createNewQuiz(request, session);
        return "domandaAjax";
    }
}
