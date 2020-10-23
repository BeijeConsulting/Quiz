package it.beije.quiz.restcontroller;

import it.beije.quiz.repository.DomandaRepository;
import it.beije.quiz.repository.RispostaDataRepository;
import it.beije.quiz.service.QuizServiceNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class QuizRestControllerFranceschi {
    @Autowired
    private QuizServiceNew quizServiceNew;

    @Autowired
    private RispostaDataRepository rispostaDataRepository;

    @GetMapping("/quiz/getPassed/{userId}")
    public Integer getPassedQuizByUser(@PathVariable Integer userId){
        return quizServiceNew.getCorrectQuizByUser(userId);
    }

    @GetMapping("/quiz/getAll/{userId}")
    public Integer getAllQuizByUser(@PathVariable Integer userId){
        return quizServiceNew.getAllQuizByUser(userId);
    }

    @GetMapping("/quiz/getTimer/{quizId}")
    public long getSecondsForExam(@PathVariable Integer quizId){
        Integer domande = rispostaDataRepository.countByIdEsame(quizId);
        return domande * 60 * 2L;
    }
}
