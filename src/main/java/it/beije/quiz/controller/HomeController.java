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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.quiz.entity.QNA;
import it.beije.quiz.entity.Question;
import it.beije.quiz.service.AnswerService;
import it.beije.quiz.service.QuestionService;

@Controller
public class HomeController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@RequestMapping(value = "/newexam", method = RequestMethod.GET)
	public String index() {
		return "newexam";
	}

	/*
	 * caricare tutte le domande scelte dall'utente in base a libro e capitolo
	 */
	@RequestMapping(value = "/load_quiz", method = RequestMethod.POST)
	public String loadQuestionsBook(Model model, HttpServletRequest request, @Param("questions") String[] questions) {
		log.debug("lista di domande del capitolo del libro");
		HttpSession session = request.getSession(false);

		Integer numberQuestions = new Integer(request.getParameter("numberQuestions"));
		List<Question> domande = new ArrayList<Question>();
		for (String s : questions) {
			if (s.charAt(0) == '1') {
				System.out.println(s.substring(2));
				domande.addAll(questionService.loadQuestionsBookAndChapter(1, s.substring(2)));
			} else if (s.charAt(0) == '2') {
				domande.addAll(questionService.loadQuestionsBookAndChapter(2, s.substring(2)));
			}

		}

		// System.out.println(domande.size());
		// System.out.println(numberQuestions);
		if (numberQuestions <= 0 || numberQuestions >= domande.size()) {
			numberQuestions = 1;
		}

		Random r = new Random();
		System.out.println("prova");
		int num = domande.size() - numberQuestions;
		List<Question> tempQuiz = new ArrayList<Question>();
		for (int i = 0; i < numberQuestions; i++) {
			tempQuiz.add(domande.get(r.nextInt(domande.size())));
		}

		// System.out.println(domande.size());

		List<QNA> quiz = loadQuiz(tempQuiz);

		session.setAttribute("exam", quiz);
		session.setAttribute("totDomande", quiz.size());
		session.setAttribute("nameQuiz", request.getParameter("nomeQuiz"));

		model.addAttribute("totDomande", quiz.size());
		model.addAttribute("nameQuiz", request.getParameter("nomeQuiz"));

		return "test";
	}

	private List<QNA> loadQuiz(List<Question> domande) {
		List<QNA> result = new ArrayList<QNA>();
		for (Question q : domande) {
			result.add(new QNA(q, answerService.getByQuestionId(q.getId()), null));
		}

		return result;
	}
	

}
