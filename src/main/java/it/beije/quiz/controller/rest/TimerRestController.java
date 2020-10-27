package it.beije.quiz.controller.rest;

import it.beije.quiz.repository.AnswerRepository;
import it.beije.quiz.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TimerRestController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @Autowired
    private AnswerRepository answerRepository;

    /**
     * REST Get method to return the time in seconds available for a Quiz
     * @param quizId the id of the Quiz
     * @return the time in seconds
     */
    @GetMapping("/getQuizTimer/{quizId}")
    public long getSecondsForQuiz(@PathVariable Integer quizId){
        // get timer from db
        // if null
            log.debug("Requested Timer for Quiz ID: " + quizId);
            Integer domande = answerRepository.countByIdTest(quizId);
            return domande * 60 * 2L;
        // else
            // return timer from db
    }

    @PutMapping("/setQuizTimer/{quizId}")
    public void setQuizTimer(@PathVariable Integer quizId,
                             @RequestBody Long timer){
        // set timer on db
    }
}
