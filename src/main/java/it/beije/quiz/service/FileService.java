package it.beije.quiz.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.beije.quiz.Utils;
import it.beije.quiz.entity.Answer;
import it.beije.quiz.entity.Book;
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
	
	public List<Element> getChildElements(Element element) {
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
	
	public void readQuestionsXmlFile(String pathFile) {
		
		try {
			
			int questionId = questionService.lastId();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        
	        File xmlFile = new File(pathFile);
	        
	        if(!xmlFile.exists()) {
	        	throw new Exception("File xml for questions not exists.");
	        }
	        
	        Document document = builder.parse(xmlFile);
	        Element element = document.getDocumentElement();	      
	        
	        List<Element> questions = getChildElements(element);
	        List<Element> questionContent = null;
	        List<Element> answerContent = null;
	        for (Element q : questions) {
	        	questionId++;
	        	
	        	questionContent = getChildElements(q);
	        	
		        Integer bookId = bookService.getBookIdByTitle(q.getAttribute("book"));
		        
		        if(bookId == null) {
		        	bookId = -1;
		        }
		        
		        String chapter = q.getAttribute("chapter");
		        String questionNumber = q.getAttribute("question");
		        
		        String text = questionContent.get(0).getTextContent();
		        String answerType = questionContent.get(1).getAttribute("type");
		        answerContent = Utils.getChildElements(questionContent.get(1));
		        String[] correctAnswer = questionContent.get(2).getTextContent().split(", ", - 1);
		        String explanation;
		        try {
		        	explanation = questionContent.get(3).getTextContent();
		        } catch(Exception e) {
		        	explanation = null;
		        }
		       
		        Answer answer = new Answer();
		        JSONObject jsonObject = new JSONObject();
		        
		        for (Element elementAnswer : answerContent) {
		        	jsonObject.put(elementAnswer.getAttribute("value"), elementAnswer.getTextContent().toString());
		        }
		        
		        answer.setQuestionId(questionId);
		        answer.setOptions(jsonObject.toString());
		        
		        StringBuilder b = new StringBuilder();
		        for(String s : correctAnswer) {
		        	b.append(s);
		        }
		        
		        answer.setCorrects(b.toString());
		        
		        answerService.insert(answer);
		        
		        /*
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
		        */
		        
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
	
	public void readFolderWithIndexXmlFile(String pathFile) {
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        
	        File fileIndex = new File(pathFile + "/index.xml");
	        
	        if(!fileIndex.exists()) {
	        	throw new Exception("File index.xml not exists.");
	        }
	        
	        Document document = builder.parse(fileIndex);
	        Element element = document.getDocumentElement();	      
	        
	        List<Element> quizs = Utils.getChildElements(element);
	        for (Element q : quizs) {
	        	
	        	String title = q.getAttribute("title");
	        	String dir = q.getAttribute("dir");
	        	
	        	Integer bookId = bookService.getBookIdByTitle(title);
	        	
	        	if(bookId == null) {
	        		Book book = new Book();
		        	book.setTitle(title);
		        	bookService.insert(book);
	        	}
	        	
	        	File folder = new File(pathFile + "/" + dir);
	        	
	        	// readQuestionsXmlFile("/temp/domande/");
	        	
	        	for(File f: folder.listFiles()) {
	        	
	        		System.out.println(f.getAbsolutePath());
	        		readQuestionsXmlFile(f.getAbsolutePath());
	        	}
	        	
	        }	        		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
