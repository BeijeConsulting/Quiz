package it.beije.quiz.service;

import it.beije.quiz.model.Quiz;
import it.beije.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class QuizServiceNew {
    @Autowired
    private QuizRepository quizRepository;

    public Integer saveQuiz(Quiz q){
        return quizRepository.saveAndFlush(q).getId();
    }

    public void overwriteQuiz(Quiz newQuiz, Integer idOldQuiz){
        Quiz oldQuiz = quizRepository.findById(idOldQuiz).orElse(null);
        if (oldQuiz == null) throw new NoSuchElementException("No quiz with such ID");
        newQuiz.setId(idOldQuiz);
        quizRepository.saveAndFlush(newQuiz);
    }

    public Integer getCorrectQuizByUser(Integer userId){
        return quizRepository.countQuizByIdUtenteAndPassed(userId, true);
    }

    public Integer getAllQuizByUser(Integer userId){
        return quizRepository.countQuizByIdUtente(userId);
    }
}