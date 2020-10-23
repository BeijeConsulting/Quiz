package it.beije.quiz.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.entity.QNA;

@RequestMapping(value="/exam")
@RestController
public class ExamApiController {
	
	private QNA init(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session==null) return null;
		else {
			setTimer(session);
			List<QNA> exam = (List<QNA>)session.getAttribute("exam");
			return exam.get(0);
		}
	}

	private QNA next(QNA question, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session==null) return null;//ERRORE sessione scaduta
		else {
			
			List<QNA> exam = (List<QNA>)session.getAttribute("exam");
			int index = (Integer)session.getAttribute("index");
			int tot = (Integer)session.getAttribute("totDomande");
			exam.set(index, question); //Aggiorna la risposta corrente nella lista di sessione
			
			if(index<tot) {
				session.setAttribute("index", ++index);
				session.setAttribute("exam", exam);
				return exam.get(index);
				
			} else return null; //ERRORE oppure non fa fare next
		}
	}
	
	private QNA prev(QNA question, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session==null) return null; //ERRORE sessione scaduta
		else {
			
			List<QNA> exam = (List<QNA>)session.getAttribute("exam");
			int index = (Integer)session.getAttribute("index");
			int tot = (Integer)session.getAttribute("totDomande");
			exam.set(index, question);
			
			if(index<0) return null; //ERRORE oppure non fa andare indietro
			else {
				session.setAttribute("index", --index);
				session.setAttribute("exam", exam);
				return exam.get(index);
			}
		}
	}
	
	private QNA pick(Integer id ,QNA question , HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		List<QNA> exam = (List<QNA>)session.getAttribute("exam");
		int index = (Integer)session.getAttribute("index");
		int tot = (Integer)session.getAttribute("totDomande");
		if(id<0 || id > tot) throw new IllegalArgumentException();
		exam.set(index, question);
		session.setAttribute("index", id);
		session.setAttribute("exam", exam);
		return exam.get(index);
	}
	
	@PostMapping(value={"/question/{id}", "/question"})
	public QNA change(@RequestBody QNA question, HttpServletRequest request, @PathVariable Integer id) {
		HttpSession session = request.getSession(false);
		if(session==null) throw new IllegalArgumentException();
		int index = (Integer)session.getAttribute("index");
		if(id==0 || id==null) return init(request);
		else if(id==(index+1)) return next(question, request);
		else if(id==(index-1)) return prev(question, request);
		else return pick(id, question, request);
	}
	
	@PostMapping(value="/submit")
	public void submit(QNA question, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession(false);
		if(session==null) throw new IllegalArgumentException(); //ERRORE sessione scaduta
		else {
			int index = (Integer)session.getAttribute("index");
			List<QNA> exam = (List<QNA>)session.getAttribute("exam");
			exam.set(index, question);
			stopTimer(session);
		}
		response.sendRedirect("/result");
	}

	private void setTimer(HttpSession session) {
		LocalDateTime start = (LocalDateTime)session.getAttribute("start_time");
		int totalTime = 2*((Integer)session.getAttribute("totDomande"));
		if(start==null) {
			Duration d = Duration.ofMinutes(totalTime);
			start = LocalDateTime.now();
			session.setAttribute("start_time", start);
			session.setAttribute("max_time", start.plus(d));
		}
	}
	
	private void stopTimer(HttpSession session) {
		LocalDateTime finish = (LocalDateTime)session.getAttribute("finish_time");
		if(finish==null) session.setAttribute("finish_time", LocalDateTime.now());
	}
	
	@GetMapping(value="/timeup")
	public boolean timeUp(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		LocalDateTime start = (LocalDateTime)session.getAttribute("start_time");
		Duration d = Duration.between(start, LocalDateTime.now());
		if(d.toMinutes()>150) return true;
		return false;
	}
}
