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
    private Integer idUtente;

	@JsonProperty("name")
    @Column(name = "name")
    private String nomeQuiz;

    @Column(name = "passato")
    private boolean passed;

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

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }
}
