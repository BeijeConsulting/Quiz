package it.beije.quiz.service;

import it.beije.quiz.Utils;
import it.beije.quiz.bean.User;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Quiz;
import it.beije.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

// Creato layer Service per togliere la logica dal Controller
@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    private Quiz quiz = null;

    private List<Domanda> domande = new ArrayList<>();
    private int totaleDomande;
    private int totaleRisposteCorrette;
    private LocalTime time = null;
    private final String PATH = "C:\\Code\\Quiz\\domande\\";
   // private final String PATH = "C:\\Users\\Padawan06\\git\\Quiz\\domande\\";
    
    /**
     * Verifica la correttezza delle risposta e ritorna i risultati da stampare nella pagina
     * @return La stringa preformattata per la pagina html
     */
    public String getResults(){
        StringBuilder results = new StringBuilder();
        for (Domanda d : domande) {
            boolean corretta = Utils.controllaRisposta(d.getRispostaEsatta(), d.getRispostaUtente());
            results.append("DOMANDA ")
                    .append(d.getId())
                    .append(" : la tua risposta : ")
                    .append(d.getRispostaUtente())
                    .append("<br><br>");
            if (corretta) {
                results.append("ESATTO!!! :)<br>");
                System.out.println("Risposta corretta.");
                totaleRisposteCorrette++;
            } else {
                results.append("La risposta esatta era ")
                        .append(d.getRispostaEsatta())
                        .append(" :(<br>");
            }
            results.append("<br><br>");
        }
        saveResultsToDatabase(results.toString());
        return results.toString();
    }

    public void createQuiz(HttpSession session, HttpServletRequest request){
        System.out.println("creo quiz");
        quiz = new Quiz();
        System.out.println("quiz id: " + quiz.getId());
        quiz.setNomeQuiz((String) request.getAttribute("quizName"));
        quiz.setIdUtente(((User)session.getAttribute("userBean")).getId());
        quizRepository.saveAndFlush(quiz);
        System.out.println("quiz id: " + quiz.getId());
    }

    private void saveResultsToDatabase(String results){
        System.out.println("Risp corrette: " + totaleRisposteCorrette);
        System.out.println("Risp totali: " + totaleDomande);
        double percentuale = totaleRisposteCorrette / (double)totaleDomande * 100;
        // fai % di risposte corrette
        System.out.println("Percentuale: " + percentuale);
        quiz.setPercentuale(percentuale);
        // setta il boolean passato o meno
        quiz.setPassed(percentuale >= 65);
        // brutto, ma salvo direttamente su db la stringa generata nel metodo result
        quiz.setResults(results);

        quizRepository.saveAndFlush(quiz);
    }

    /**
     * Carica la domanda per la singola pagina
     * @param index indice della domanda richiesta
     * @return la pagina corretta se la domanda è l'ultima o meno
     */
    public String caricaDomanda(Model model,
                                 int index) {
        System.out.println("Enter caricaDomanda method.");
        if (index < totaleDomande) {
            Domanda d = domande.get(index);
            String risposta = d.getRispostaUtente();
            if (risposta == null) {
                risposta = "";
            }
            model.addAttribute("index", index);
            model.addAttribute("testoDomanda",Utils.formattaTesto(d.getTesto()));
            model.addAttribute("rispUtente", risposta);
            model.addAttribute("answerType", d.getAnswerType());
            model.addAttribute("risposte",d.getRisposte());
            System.out.println("Exit caricaDomanda method with index<tot.");
            return "domanda";
        } else {
            System.out.println("Exit caricaDomanda method with riepilogo.");
            return "riepilogo";
        }
    }

    /**
     * Metodo per aggiornare il timer
     */
    public void setTimer(Model model) {
        System.out.println("Enter setTimer method.");
        if (time == null) {
            time = LocalTime.now();
        }
        LocalTime now = LocalTime.now();
        Duration diff = Duration.between(time, now);
        int secondi = 2 * 60 * totaleDomande;
        long hours = (secondi - diff.getSeconds())/3600;
        long minutes = (secondi - diff.getSeconds())/60 - hours* 60;
        long seconds = (secondi - diff.getSeconds()) - hours * 3600 - minutes * 60;

        model.addAttribute("totDomande", totaleDomande);
        model.addAttribute("ore", hours);
        model.addAttribute("minuti", minutes);
        model.addAttribute("secondi", seconds);
        System.out.println("Exit setTimer method.");
    }

    /**
     * Carica le domande all'avvio della pagina/server
     */
    public void loadDomande(Model model, String[] userSelection){
        for (String s : userSelection){
            domande.addAll(Utils.readFileDomande(PATH + s));
        }
        totaleDomande = domande.size();
        model.addAttribute("totDomande", totaleDomande);
    }

    /**
     * Salva le risposte date dall'utente per la domanda
     * @param request richiesta per ottenere i parametri contenenti le risposte
     * @param index domanda a cui si è risposto
     */
    public void saveRisposte(HttpServletRequest request,
                             int index){
        Enumeration<String> enums = request.getParameterNames();
        StringBuilder risposta = new StringBuilder();
        // Ciclo per cercare tutte le risposte dell'utente (per domande a risp multipla)
        while (enums.hasMoreElements()) {
            String name = enums.nextElement();
            // Se il parametro inviato inizia con rspt, è una risposta, quindi aggiungi alle risposte alla domanda
            if (name.startsWith("rspt_")) {
                risposta.append(request.getParameter(name));
            }
        }
        // Salva la lista di risposte sulla rispettiva domanda
        domande.get(index).setRispostaUtente(risposta.toString());
    }
}