package it.beije.quiz.controller;

import it.beije.quiz.model.Quiz;
import it.beije.quiz.model.User;
import it.beije.quiz.service.QuizServiceNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class StartQuizController {
    @Autowired
    private QuizServiceNew quizServiceNew;

    @PostMapping("/startQuiz")
    public String startQuiz(HttpServletRequest request, HttpSession session){
        Quiz quiz = new Quiz();
        quiz.setNomeQuiz(request.getParameter("nomeQuiz"));
        quiz.setIdUtente(((User)session.getAttribute("userBean")).getId());
        Integer idQuiz = quizServiceNew.saveQuiz(quiz);
        session.setAttribute("idQuiz", idQuiz);
        return "domandaAjax";
    }
}
