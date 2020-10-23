package it.beije.quiz.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.Duration;
import java.time.LocalTime;

// Creato layer Service per togliere la logica dal Controller
@Service
public class QuizService {
    private int totaleDomande;
    private LocalTime time = null;

    // TODO questo metodo ora come ora è rotto. Serve? Si può fare tutto con Rest ;)
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
}