package it.beije.quiz.controller.rest;

import it.beije.quiz.service.PartecipateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * REST Controller to handle all request regarding the Quiz Timer
 */
@RestController
@RequestMapping("/api")
public class TimerRestController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PartecipateService partecipateService;

//    @Autowired
//    private AnswerRepository answerRepository;

    /**
     * REST Get method to return the time in seconds available for a Quiz
     * @param session used to get the quiz id
     * @return the time in seconds
     */
    @GetMapping("/getQuizTimer")
    public long getSecondsForQuiz(HttpSession session){
        Integer quizId = (Integer) session.getAttribute("quizId");
        Long timer = partecipateService.getTimerFromDatabase(quizId);
        if (timer == null) {
            log.debug("Requested Timer for Quiz ID: " + quizId);
//            Integer domande = answerRepository.countByIdTest(quizId);
//            timer = domande * 60 * 2L;
            partecipateService.setTimerOnDatabase(quizId, timer);
        }
        return timer;
    }

    /**
     * Save the current timer onto the database. Used to avoid exploit client-side
     * @param timer the current timer to save
     */
    @PutMapping("/setQuizTimer")
    public void setQuizTimer(HttpSession session,
                             @RequestBody Long timer){
        // todo maybe call this once every 10 seconds and not every second?
        // set timer on db
        // todo finish
        Integer quizId = (Integer) session.getAttribute("quizId");

    }
}
