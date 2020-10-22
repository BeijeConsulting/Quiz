package it.beije.quiz.restcontroller;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.service.DomandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DomandaRestController {
    @Autowired
    private DomandaService domandaService;

    @GetMapping("/getDomanda/{id}")
    public Domanda getDomanda(@PathVariable Long id){
        return domandaService.getByID(id);
    }
}
