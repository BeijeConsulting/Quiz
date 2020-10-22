package it.beije.quiz.controller;

import it.beije.quiz.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Contoller per mappare url di debug e amministrazione
 */
@Controller
public class UtilsController {
    @Autowired
    private Converter converter;

    /**
     * Converte tutti gli XML e li inserisce nel database
     */
    @RequestMapping(value = "/converter", method = RequestMethod.GET)
    public String converter() {
        converter.convertAll();
        return "index";
    }
}
