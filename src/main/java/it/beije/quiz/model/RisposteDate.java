package it.beije.quiz.model;

import javax.persistence.*;

@Entity
@Table(name = "risposte_date")
public class RisposteDate {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "id_utente")
    private Integer idUtente;
    
    @Column(name = "id_domanda")
    private Long idDomanda;
    
    @Column(name = "id_esame")
    private Integer idEsame;

    @Column
    private String risposta;

    public RisposteDate() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getIdUtente() {
        return idUtente;
    }
    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }
    
    public Long getIdDomanda() {
        return idDomanda;
    }
    public void setIdDomanda(Long idDomanda) {
        this.idDomanda = idDomanda;
    }
    
    public Integer getIdEsame() {
        return idEsame;
    }
    public void setIdEsame(Integer idEsame) {
        this.idEsame = idEsame;
    }

    public String getLetter() {
        return risposta;
    }
    public void setLetter(String risposta) {
        this.risposta = risposta;
    }
}