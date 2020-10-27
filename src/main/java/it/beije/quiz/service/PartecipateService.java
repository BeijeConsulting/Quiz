package it.beije.quiz.service;

import it.beije.quiz.entity.Partecipate;
import it.beije.quiz.repository.PartecipateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartecipateService {
    @Autowired
    private PartecipateRepository partecipateRepository;

    /**
     * Gets the timer of the quiz from the database
     * @param quizId The id of the Quiz
     * @return the timer in seconds or null if no timer has been set yet
     */
    public Long getTimerFromDatabase(Integer quizId){
        Partecipate p = partecipateRepository.findByQuizId(quizId).orElse(null);
        if (p != null){
            return p.getTimer();
        } else return null;
    }

    /**
     * Set the timer on the database. Used to avoid exploit client-side
     * @param quizId the id of the Quiz to update
     * @param timer the timer to set
     */
    public void setTimerOnDatabase(Integer quizId, Long timer){
        Partecipate p = partecipateRepository.findByQuizId(quizId).orElse(null);
        if (p != null){
            p.setTimer(timer);
            partecipateRepository.saveAndFlush(p);
        }
    }
}
