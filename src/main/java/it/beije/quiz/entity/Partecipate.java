package it.beije.quiz.entity;

import javax.persistence.*;

@Entity
@Table(name = "partecipate")
public class Partecipate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partecipate_id")
    private Integer partecipateId;

    @Column(name = "user")
    private Integer userId;

    @Column(name = "quiz")
    private Integer quizId;

    @Column(name = "committed")
    private boolean committed;

    @Column(name = "timer")
    private Long timer;

    public Partecipate() {}
    
    public Integer getPartecipateId() {
		return partecipateId;
	}
	public void setPartecipateId(Integer partecipateId) {
		this.partecipateId = partecipateId;
	}
	public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getQuizId() {
        return quizId;
    }
    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }
    public boolean isCommitted() {
        return committed;
    }
    public void setCommitted(boolean committed) {
        this.committed = committed;
    }
    public Long getTimer() {
        return timer;
    }
    public void setTimer(Long timer) {
        this.timer = timer;
    }
}