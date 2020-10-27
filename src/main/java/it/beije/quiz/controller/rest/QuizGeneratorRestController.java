package it.beije.quiz.controller.rest;

import it.beije.quiz.entity.Question;
import it.beije.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizGeneratorRestController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/getDomanda/{bookIDs}/{chapters}")
    public List<Question> getByBookAndChapter(@PathVariable String bookIDs,
                                              @PathVariable String chapters){
        String[] capitoli = chapters.split("-");
        List<Integer> nrChapters = new ArrayList<>();
        for (String s : capitoli){
            if (s != null)
                nrChapters.add(Integer.parseInt(s));
        }
        return questionService.getQuestionsFromMultipleChapters(nrChapters);
    }

    @GetMapping("/countQuestions/{chaptersString}")
    public Integer countByChapters(@PathVariable String chaptersString){
        String[] chapters = chaptersString.split(",");
        List<Integer> chaptersIds = new ArrayList<>();
        for (String s : chapters){
            if (s != null)
                chaptersIds.add(Integer.parseInt(s));
        }
        return questionService.countQuestionsFromMultipleChapters(chaptersIds);
    }
}
