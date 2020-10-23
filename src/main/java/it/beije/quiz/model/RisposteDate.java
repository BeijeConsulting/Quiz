package it.beije.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "risposte_date")
@JsonInclude(Include.NON_NULL)
public class RisposteDate {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

	@JsonProperty("id_utente")
    @Column(name = "id_utente")
    private Integer idUtente;
    
	@JsonProperty("id_domanda")
    @Column(name = "id_domanda")
    private Long idDomanda;
    
	@JsonProperty("id_esame")
    @Column(name = "id_esame")
    private Integer idEsame;

    @Column
    private String risposta;

    public RisposteDate() {}

	public RisposteDate(Integer id_utente, Long id_domanda, Integer id_esame,
			String risposta) {
		this.idUtente = id_utente;
		this.idDomanda= id_domanda;
		this.idEsame = id_esame;
		this.risposta = risposta;
	}
	

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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

    public String getRisposta() {
        return risposta;
    }
    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }
}