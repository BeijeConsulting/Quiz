package it.beije.quiz.controller;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import it.beije.quiz.Utils;
import it.beije.quiz.entity.Book;
import it.beije.quiz.service.BookService;
import it.beije.quiz.service.FileService;

@Controller
public class TestController {

	@Autowired
	private FileService fileService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/test/read-file")
	public String importFileToDatabse() {
		
		final String PATH_DIR = "/temp/domande";
		
		fileService.readFolderWithIndexXmlFile(PATH_DIR);
		
		System.out.println("Done!");
		
		return "login";
		
	}
	
}
