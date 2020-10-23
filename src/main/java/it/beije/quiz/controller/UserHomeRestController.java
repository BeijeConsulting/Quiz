package it.beije.quiz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.beije.quiz.entity.QNA;
import it.beije.quiz.entity.Question;
import it.beije.quiz.entity.Result;
import it.beije.quiz.repository.AnswerRepository;
import it.beije.quiz.service.AnswerService;
import it.beije.quiz.service.QuestionService;
import it.beije.quiz.service.ResultService;


@RestController
public class UserHomeRestController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ResultService resultService;
	
//	@Autowired
//	private AnswerService answerService;
//	
//	/*
//	 * caricare tutte le domande scelte dall'utente in base a libro e capitolo
//	 */
//	@GetMapping("/load_quiz")
//	public String loadQuestionsBook(Model model, HttpServletRequest request, @PathVariable Integer id, @Param("questions") String[] questions) {
//		log.debug("lista di domande del capitolo del libro");
//		HttpSession session = request.getSession(false);
//		
//		Integer numberQuestions = new Integer(request.getParameter("numberQuestions"));
//		List<Question> domande = new ArrayList<Question>();
//		for(String s: questions) {
//			if(s.charAt(0)=='1') {
//				domande.addAll(questionService.loadQuestionsBookAndChapter(1, s.substring(2)));
//			}else if(s.charAt(0)=='2'){
//				domande.addAll(questionService.loadQuestionsBookAndChapter(2, s.substring(2)));
//			}
//			
//		}
//		
//		if(domande.size() > numberQuestions) {
//			Random r = new Random();
//			for(int i = 0; i < domande.size() - numberQuestions; i++) {
//				domande.remove(r.nextInt(domande.size()));
//			}
//			
//		}
//		
//		List<QNA> quiz = loadQuiz(domande);
//		
//		session.setAttribute("exam", quiz);
//		session.setAttribute("totDomande", quiz.size());
//		session.setAttribute("nameQuiz", request.getParameter("nomeQuiz"));
//
//		model.addAttribute("totDomande", quiz.size());
//		model.addAttribute("nameQuiz", request.getParameter("nomeQuiz"));
//		
//		return "test";
//	}
//	
//	private List<QNA> loadQuiz(List<Question> domande){
//		List<QNA> result = new ArrayList<QNA>();
//		for(Question q: domande) {
//			result.add(new QNA(q, answerService.getByQuestionId(q.getId()), null));
//		}
//		
//		return result;
//	}
	
	@GetMapping("/history")
	public List<Result> getUserHistory(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session==null) return null;
		else {
			System.out.println("user id: "+session.getAttribute("userId"));
			session.setAttribute("userId", new Integer(1));
			List<Result> history = resultService.findByUserId((Integer)session.getAttribute("userId"));
			return history;
		}
	}
	
	
	
}
