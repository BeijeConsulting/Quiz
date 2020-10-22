package it.beije.quiz.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.beije.quiz.Utils;
import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Question;
import it.beije.quiz.model.Domanda;
import it.beije.quiz.model.Risposta;

@Service
public class FileService {

	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private BookService bookService;
	
	private List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		
		NodeList nodeList = element.getChildNodes();
        Node node = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
        	node = nodeList.item(i);
        	if (node.getNodeType() == Node.ELEMENT_NODE) {
        		childElements.add((Element)node);
        	}
        }
		
		return childElements;
	}
	
	private void readFileDomande(String pathFile) {
		
		int questionId = questionService.lastId();
		// int answerId = answerService.lastId();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        
	        Document document = builder.parse(new File(pathFile));
	        Element element = document.getDocumentElement();	      
	        
	        List<Element> questions = Utils.getChildElements(element);
	        List<Element> questionContent = null;
	        List<Element> answerContent = null;
	        for (Element q : questions) {
	        	
	        	questionId++;
	        	
	        	questionContent = Utils.getChildElements(q);
	        	
		        int bookId = bookService.getBookIdByTitle(q.getAttribute("book"));
		        	
		        int chapter = Integer.parseInt(q.getAttribute("chapter"));
		        int questionNumber = Integer.parseInt(q.getAttribute("question"));
		        
		        String text = questionContent.get(0).getTextContent();
		        String answerType = questionContent.get(1).getAttribute("type");
		        answerContent = Utils.getChildElements(questionContent.get(1));
		        String[] correctAnswer = questionContent.get(2).getTextContent().split(", ", - 1);
		        String explanation = questionContent.get(3).getTextContent();
		       
		        for (Element elementAnswer : answerContent) {
		        	Answer answer = new Answer();
		        	answer.setValue(elementAnswer.getAttribute("value"));
		        	answer.setText(elementAnswer.getTextContent());		 
		        	for(String c: correctAnswer) {
		        		if(c.equals(answer.getValue())) {
		        			answer.setCorrect(true);
		        		} else {
		        			answer.setCorrect(false);
		        		}
		        	}
		        	answer.setQuestionId(questionId);
		        	answerService.insert(answer);
		        }
		        
	        	Question question = new Question();
	        	question.setBookId(bookId);
	        	question.setChapter(chapter);
	        	question.setQuestion(questionNumber);
	        	question.setText(text);
	        	question.setAnswerType(answerType);
	        	question.setExplanation(explanation);
	        	
	        	questionService.insert(question);
	        }	        		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
