package it.beije.quiz.model;

import javax.persistence.*;

@Entity
@Table(name = "esami")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_utente")
    private Long idUtente;

    @Column(name = "name")
    private String nomeQuiz;

    @Column(name = "results")
    private String results;

    @Column(name = "percentuale")
    private Double percentuale;

    @Column(name = "passato")
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

    public Double getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(Double percentuale) {
        this.percentuale = percentuale;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }
}
