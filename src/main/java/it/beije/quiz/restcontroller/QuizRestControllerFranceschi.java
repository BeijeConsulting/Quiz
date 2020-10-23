package it.beije.quiz.restcontroller;

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

    @GetMapping("/quiz/getPassed/{userId}")
    public Integer getPassedQuizByUser(@PathVariable Integer userId){
        return quizServiceNew.getCorrectQuizByUser(userId);
    }

    @GetMapping("/quiz/getAll/{userId}")
    public Integer getAllQuizByUser(@PathVariable Integer userId){
        return quizServiceNew.getAllQuizByUser(userId);
    }
}
