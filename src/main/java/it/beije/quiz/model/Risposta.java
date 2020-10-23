package it.beije.quiz.model;

import javax.persistence.*;

@Entity
@Table(name = "risposte")
public class Risposta {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "id_domanda")
    private Integer idDomanda;

    @Column
    private String letter;

    @Column
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDomanda() {
        return idDomanda;
    }

    public void setIdDomanda(Integer idDomanda) {
        this.idDomanda = idDomanda;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
