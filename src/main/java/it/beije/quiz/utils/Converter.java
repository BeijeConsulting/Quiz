package it.beije.quiz.utils;

import it.beije.quiz.utils.XMLToDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Converter {
    private static final String PATH = "C:\\Code\\Quiz\\domande\\";
    private static final String MANNING = "oca_certification_guide_manning\\";
    private static final String OCA = "oca_manual\\";
    private static final String FILENAME = "domande_cap";

    @Autowired
    private XMLToDB xmlToDB;


    public void convertAll() {
        for (int i = 1; i < 7; i++) {
            System.out.println("Iterazione: " + i);
            System.out.println(PATH + OCA + FILENAME + i + ".xml");
            xmlToDB.xmlToDatabase(PATH + OCA + FILENAME + i + ".xml");
            System.out.println(PATH + MANNING + FILENAME + i + ".xml");
            xmlToDB.xmlToDatabase(PATH + MANNING + FILENAME + i + ".xml");
        }
        xmlToDB.xmlToDatabase(PATH + OCA + "domande_Assessment_Test" + ".xml");
        xmlToDB.xmlToDatabase(PATH + MANNING + FILENAME + "7" + ".xml");
    }
}