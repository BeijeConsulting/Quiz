package it.beije.quiz.model;

//import javax.persistence.Entity;
//
//@Entity
public class Quiz {
    private Integer id;
    private String nomeQuiz;
    private String results;
    private Integer percentuale;
    private boolean isPassed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeQuiz() {
        return nomeQuiz;
    }

    public void setNomeQuiz(String nomeQuiz) {
        this.nomeQuiz = nomeQuiz;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Integer getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(Integer percentuale) {
        this.percentuale = percentuale;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }
}
