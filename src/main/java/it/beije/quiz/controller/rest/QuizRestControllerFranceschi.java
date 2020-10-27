package it.beije.quiz.controller.rest;

import it.beije.quiz.repository.AnswerRepository;
import it.beije.quiz.repository.RispostaDataRepository;
import it.beije.quiz.service.QuizService;
import it.beije.quiz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuizRestControllerFranceschi {
    @Autowired
    private TestService testService;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/quiz/getPassed/{userId}")
    public Integer getPassedQuizByUser(@PathVariable Integer userId){
        return testService.countCorrectQuizByUser(userId);
    }

    @GetMapping("/quiz/getAll/{userId}")
    public Integer getAllQuizByUser(@PathVariable Integer userId){
        return testService.countQuizByUser(userId);
    }

    @GetMapping("/quiz/getTimer/{quizId}")
    public long getSecondsForExam(@PathVariable Integer quizId){
        Integer domande = answerRepository.countByIdTest(quizId);
        return domande * 60 * 2L;
    }
}
