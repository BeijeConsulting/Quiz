package it.beije.quiz.utils;

import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;
import it.beije.quiz.service.DomandaService;
import it.beije.quiz.service.RispostaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class XMLToDB {
    @Autowired
    private DomandaService domandaService;

    @Autowired
    private RispostaService rispostaService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void xmlToDatabase(String pathFile) {
        log.info(domandaService == null ? "è null" : "non è null");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(pathFile));
            Element element = document.getDocumentElement();

            List<Element> domande = getChildElements(element);

            List<Element> contenutoDomanda;
            List<Element> elementiRisposta;
            Element rispostePossibili = null;

            for (Element domanda : domande) {
                log.info("Saving domanda");
                contenutoDomanda = getChildElements(domanda);
                String book = domanda.getAttribute("book");
                int chapter = Integer.parseInt(domanda.getAttribute("chapter"));
                int question = Integer.parseInt(domanda.getAttribute("question"));
                String testo = contenutoDomanda.get(0).getTextContent();
                String answerType = rispostePossibili != null ? rispostePossibili.getAttribute("type") : null;
                String rispostaEsatta = contenutoDomanda.get(2).getTextContent();
                String spiegazione = contenutoDomanda.get(3).getTextContent();

                Domanda d = new Domanda(
                        book, chapter, question, testo, answerType,
                        rispostaEsatta, spiegazione);
                log.info("Domanda: " + d.toString());
                d = domandaService.save(d);

                //caricare le risposte possibili
                rispostePossibili = contenutoDomanda.get(1);
                elementiRisposta = getChildElements(rispostePossibili);
                for (Element risposta : elementiRisposta) {
                    Risposta r = new Risposta();
                    r.setLetter(risposta.getAttribute("value"));
                    r.setText(risposta.getTextContent());
                    r.setIdDomanda(d.getId());
                    log.info("Saving risposta: " + r + " for Domanda: " + d.getId());
                    rispostaService.save(r);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo util per la lettura di file XML
     * @param element Elemento da cui estrarre gli elementi child
     * @return List di elements figli dell'element parametro
     */
    private static List<Element> getChildElements(Element element) {
        List<Element> childElements = new ArrayList<>();
        NodeList nodeList = element.getChildNodes();
        Node node = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                childElements.add((Element)node);
            }
        }
        return childElements;
    }
}
