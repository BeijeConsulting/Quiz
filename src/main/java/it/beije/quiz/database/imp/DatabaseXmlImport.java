package it.beije.quiz.database.imp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import it.beije.quiz.utils.Pair;
import it.beije.quiz.utils.Utils;
import it.beije.quiz.entity.Book;
import it.beije.quiz.entity.Chapter;
import it.beije.quiz.entity.Question;
import it.beije.quiz.entity.QuestionAnswer;
import it.beije.quiz.repository.BookRepository;
import it.beije.quiz.repository.ChapterRepository;
import it.beije.quiz.repository.QuestionAnswerRepository;
import it.beije.quiz.repository.QuestionRepository;

@Service
public class DatabaseXmlImport {
	
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private ChapterRepository chapterRepo;
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private QuestionAnswerRepository questionAnswerRepo;
	
	@Transactional
	private void importFromDirectory(String path) {
		File mainDir = new File(path);
		if(!mainDir.isDirectory()) {
			System.out.println("specified path doesn't lead to a dir");
		}else {
			String[] books = mainDir.list();
			for(String s : books) {
				Book b = new Book();
				b.setTitle(s);
				b = bookRepo.saveAndFlush(b);
				File bookDir = new File(mainDir, s);
				String[] chapters = bookDir.list();
				for(String c : chapters) {
					Chapter ch = new Chapter();
					ch.setTitle(c.replace("domande_", "").replace(".xml", ""));
					ch.setBookId(b.getId());
					ch = chapterRepo.saveAndFlush(ch);
					File chapter = new File(bookDir, c);
					saveQuestions(chapter, ch.getId());
				}
			}
		}
	}

	@Transactional
	private void saveQuestions(File chapter, int chapter_id) {	
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();

	        // Load the input XML document, parse it and return an instance of the
	        // Document class.
	        Document document = builder.parse(chapter);
	        Element element = document.getDocumentElement();	        
	        List<Element> questions = Utils.getChildElements(element);        	        
	        List<Element> questionElements = null;
	        List<Element> answerElements = null;
	        Element possibleAnswers = null;
	        for (Element q : questions) {
	        	questionElements = Utils.getChildElements(q);
		        String text = questionElements.get(0).getTextContent();
		        //caricare le risposte possibili
		        possibleAnswers = questionElements.get(1);
		        String answerType = possibleAnswers.getAttribute("type");
		        answerElements = Utils.getChildElements(possibleAnswers);
		        List<Pair<String, String>> answers = new ArrayList<>();
		        for (Element answer : answerElements) {
		        	Pair<String, String> r = new Pair<>(answer.getAttribute("value"), answer.getTextContent());
		        	answers.add(r);
		        }
		        String correctAnswer = questionElements.get(2).getTextContent();
		        String explanation = questionElements.get(3).getTextContent();
		        
	        	Question d = new Question(chapter_id, text, answerType, correctAnswer, explanation);
	        	questionRepo.saveAndFlush(d);
	        	
	        	for(Pair<String, String> p : answers) {
	        		QuestionAnswer ans = new QuestionAnswer(p.getFirst(), p.getLast());
	        		ans.setQuestion(d.getId());
	        		questionAnswerRepo.saveAndFlush(ans);
	        	}
	        }	        		
	        
		} catch (Exception e) {
			System.out.println("Capitolo non importato: " + chapter_id + "\nRivedere xml");;
		}
		
	}
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("correct usage: java DatabaseXmlImport <pathToBooks>");
			System.exit(0);
		}
		DatabaseXmlImport instance = new DatabaseXmlImport();
		instance.importFromDirectory(args[0]);
	}

}
