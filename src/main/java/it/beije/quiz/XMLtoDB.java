package it.beije.quiz;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.repository.DomandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XMLtoDB {
    private static final String PATH = "C:\\Code\\Quiz\\domande\\";
    private static final String MANNING = "oca_certification_guide_manning\\";
    private static final String OCA = "oca_manual\\";
    private static final String FILENAME = "domande_cap";
    // private final String PATH = "C:\\Users\\Padawan06\\git\\Quiz\\domande\\";

    @Autowired
    private DomandaRepository domandaRepository;


    public void convertAll() {
        List<Domanda> domande = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            System.out.println("Iterazione: " + i);
            System.out.println(PATH + OCA + FILENAME + i + ".xml");
            domande.addAll(Utils.readFileDomande(PATH + OCA + FILENAME + i + ".xml"));
            System.out.println(PATH + MANNING + FILENAME + i + ".xml");
            domande.addAll(Utils.readFileDomande(PATH + MANNING + FILENAME + i + ".xml"));
        }
        domande.addAll(Utils.readFileDomande(PATH + OCA + "domande_Assessment_Test" + ".xml"));
        domande.addAll(Utils.readFileDomande(PATH + MANNING + FILENAME + "7" + ".xml"));

        System.out.println("saving to db");
        for (Domanda d : domande) {
            System.out.println("saving " + d.getId());
            domandaRepository.saveAndFlush(d);
            System.out.println("saved");
        }
        System.out.println("saved to db");
    }
}