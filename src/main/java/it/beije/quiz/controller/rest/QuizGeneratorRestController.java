package it.beije.quiz.controller.rest;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.service.DomandaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class QuizGeneratorRestController {
    @Autowired
    private DomandaService domandaService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/getDomanda/{bookIDs}/{chapters}")
    public List<Domanda> getByBookAndChapter(@PathVariable String bookIDs,
                                             @PathVariable String chapters){
        String[] libri = bookIDs.split("-");
        String[] capitoli = chapters.split("-");
        List<Integer> nrLibri = new ArrayList<>();
        for (String s : libri){
            if (s != null)
            nrLibri.add(Integer.parseInt(s));
        }
        List<Integer> nrChapters = new ArrayList<>();
        for (String s : capitoli){
            if (s != null)
                nrChapters.add(Integer.parseInt(s));
        }
        return domandaService.getDomandeByBookAndChapter(nrLibri, nrChapters);
    }

    @GetMapping("/countQuestions/{bookIDs}/{chapters}")
    public Integer countByBookAndChapter(@PathVariable String bookIDs,
                                             @PathVariable String chapters){
        log.info("Requested count for questions at this url:" + bookIDs + " " + chapters);
        String[] libri = bookIDs.split(",");
        String[] capitoli = chapters.split(",");

        Integer count = 0;

        List<Integer> nrLibri = new ArrayList<>();
        for (String s : libri){
            if (s != null)
                nrLibri.add(Integer.parseInt(s));
        }
        log.info("Number of the selected Books: " + nrLibri.toString());
        List<Integer> nrChapters = new ArrayList<>();
        for (String s : capitoli){
            if (s != null)
                nrChapters.add(Integer.parseInt(s));
        }

        for (int i = 0; i < nrChapters.size(); i++){
            count += domandaService.countDomandeSimple(nrLibri.get(i), nrChapters.get(i));
        }

        log.info("Number of the selected Chapters: " + nrChapters.toString());
        return count;
    }
}
