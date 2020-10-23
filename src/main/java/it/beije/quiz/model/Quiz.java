package it.beije.quiz.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "esami")
@JsonInclude(Include.NON_NULL)
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

	@JsonProperty("id_utente")
    @Column(name = "id_utente")
    private Long idUtente;

	@JsonProperty("name")
    @Column(name = "name")
    private String nomeQuiz;

    @Column(name = "results")
    private String results;

	@JsonProperty("passato")
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
