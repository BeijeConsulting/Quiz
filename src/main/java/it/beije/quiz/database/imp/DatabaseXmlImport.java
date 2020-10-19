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

import it.beije.quiz.Utils;
import it.beije.quiz.entity.Book;
import it.beije.quiz.entity.Chapter;
import it.beije.quiz.entity.Question;
import it.beije.quiz.model.Risposta;
import it.beije.quiz.repository.BookRepository;
import it.beije.quiz.repository.ChapterRepository;
import it.beije.quiz.repository.QuestionRepository;

@Service
public class DatabaseXmlImport {
	
	@Autowired
	private static BookRepository bookRepo;
	@Autowired
	private static ChapterRepository chapterRepo;
	@Autowired
	private static QuestionRepository questionRepo;
	
	@Transactional
	public void importFromXml(String path) {
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
					ch.setBook(b.getId());
					ch = chapterRepo.saveAndFlush(ch);
					File chapter = new File(bookDir, c);
					saveQuestions(chapter, ch.getId());
				}
			}
			
		}
	}

	@Transactional
	private void saveQuestions(File chapter, int chapter_id) {
		List<Question> questionList = new ArrayList<Question>();	
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();

	        // Load the input XML document, parse it and return an instance of the
	        // Document class.
	        Document document = builder.parse(chapter);
	        Element element = document.getDocumentElement();	        
	        List<Element> questions = Utils.getChildElements(element);        	        
	        List<Element> questionText = null;
	        List<Element> answerElements = null;
	        Element possibleAnswers = null;
	        for (Element q : questions) {
	        	questionText = Utils.getChildElements(q);
		        int id = Integer.parseInt(q.getAttribute("id"));
		        String testo = questionText.get(0).getTextContent();
		        
		        //caricare le risposte possibili
		        possibleAnswers = questionText.get(1);
		        String answerType = possibleAnswers.getAttribute("type");
		        answerElements = Utils.getChildElements(possibleAnswers);
		        List<Risposta> answers = new ArrayList<Risposta>();
		        for (Element answer : answerElements) {
		        	Risposta r = new Risposta();
		        	r.setValue(answer.getAttribute("value"));
		        	r.setText(answer.getTextContent());
		        	
		        	answers.add(r);
		        }
		        
		        String rispostaEsatta = questionText.get(2).getTextContent();
		        String spiegazione = questionText.get(3).getTextContent();
		        
	        	Question d = new Question(id, chapter_id, testo, answerType, answers, rispostaEsatta, spiegazione);
	        	questionList.add(d);
	        }	        		
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Question q : questionList) {
			questionRepo.save(q);
		}
		
	}

}
