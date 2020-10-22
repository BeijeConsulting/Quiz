package it.beije.quiz.restcontroller;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.service.DomandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class StartRestController {

    @Autowired
    private DomandaService domandaService;

    @GetMapping("/getDomanda/{bookIDs}/{chapters}")
    public List<Domanda> getByBookAndChapter(@PathVariable String bookIDs,
                                             @PathVariable String chapters){

        String[] libri = bookIDs.split("-");
        String[] capitoli = chapters.split("-");

        return domandaService.getDomandeByBookAndChapter(bookID, chapter);
    }
}
