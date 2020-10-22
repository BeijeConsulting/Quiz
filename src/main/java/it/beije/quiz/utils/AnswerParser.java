package it.beije.quiz.utils;

import java.util.ArrayList;
import java.util.List;

public class AnswerParser {
    // Prende le risposte nel formato del database e le converte in un array di risposte
    public static String[] parseRisposte(String risposteDB){
        return risposteDB.split("/");
    }

    public static List<String> getAnswersLetters(String[] risposte){
        List<String> letters = new ArrayList<>();
        for (String s : risposte){
            letters.add(Character.toString(s.charAt(0)));
        }
        return letters;
    }

    public static List<String> getAnswers(String[] risposte){
        List<String> answers = new ArrayList<>();
        for (String s : risposte){
            answers.add(s.substring(1));
        }
        return answers;
    }
}