package it.beije.quiz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.beije.quiz.model.RisposteDate;
import it.beije.quiz.service.RisposteDateService;

@Controller
public class HistoryController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RisposteDateService risposteDateService;
    
    
}
