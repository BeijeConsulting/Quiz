package it.beije.quiz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Book;
import it.beije.quiz.entity.Chapter;
import it.beije.quiz.entity.Question;
import it.beije.quiz.entity.Test;
import it.beije.quiz.entity.User;
import it.beije.quiz.service.AnswerService;
import it.beije.quiz.service.BookService;
import it.beije.quiz.service.ChapterService;
import it.beije.quiz.service.QuestionService;
import it.beije.quiz.service.TestService;


@Controller
@SessionScope
public class QuizController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private TestService testService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	

	@RequestMapping(value="/gen_test", method= RequestMethod.POST )
	public String genTest(HttpServletRequest request, HttpSession session) {
		String sel = request.getParameter("book");
		String set = request.getParameter("chapter");
		String name = request.getParameter("name");
		int usr = ((User) session.getAttribute("user")).getId();
		String bookTitle = null;
		if(sel.equals("guide")) {
			bookTitle = "oca_certification_guide_manning";
		}else{
			bookTitle = "oca_manual";
		}
		Book b = bookService.getBook(bookTitle);
		Chapter c = chapterService.getChapter(b.getId(), set);
		List<Question> questions = questionService.getChapterQuestions(c.getId());
		Test t = testService.createTest(name, usr);
		session.setAttribute("test", t);
		List<Answer> answers = answerService.createAnswers(questions, t.getId());
		questionService.setAnswers(answers);
		questionService.setQuestions(questions);
		return "quiz_view"; //da cambiare con quello vero
	}

	
	@GetMapping(value="/testselect")
	public String testselect() {
		log.debug("Accipigna sta funzionando");
		return "testselect";
	}

}
