package it.beije.quiz.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "risposte_date")
public class RisposteDate {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "id_utente")
    private Long idUtente;
    
    @Column(name = "id_domanda")
    private Long idDomanda;
    
    @Column(name = "id_esame")
    private Long idEsame;

    @Column
    private String risposta;
    

    public RisposteDate() {}

	public RisposteDate(Long id_utente, Long id_domanda, Long id_esame,
			String risposta) {
		this.idUtente = id_utente;
		this.idDomanda= id_domanda;
		this.idEsame = id_esame;
		this.risposta = risposta;
	}
	

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getIdUtente() {
        return idDomanda;
    }
    public void setIdUtente(Long idUtente) {
        this.idDomanda = idUtente;
    }
    
    public Long getIdDomanda() {
        return idDomanda;
    }
    public void setIdDomanda(Long idDomanda) {
        this.idDomanda = idDomanda;
    }
    
    public Long getIdEsame() {
        return idDomanda;
    }
    public void setIdEsame(Long idEsame) {
        this.idEsame = idEsame;
    }

    public String getRisposta() {
        return risposta;
    }
    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }
    
	public String toString() {
		StringBuilder builder = new StringBuilder("Risposta data [");
		builder.append(" id_utente : ").append(this.idUtente)	
			.append(" - id_domanda : ").append(this.idDomanda)	
			.append(" - id_esame : ").append(this.idEsame)	
			.append(" - risposta : ").append(this.risposta)	
			.append("]");
		return builder.toString();
	}
}