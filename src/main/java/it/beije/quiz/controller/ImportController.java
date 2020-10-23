package it.beije.quiz.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.quiz.database.imp.DatabaseXmlImport;

@Controller
public class ImportController {

	@Autowired
	private DatabaseXmlImport dbImportService;
	@Autowired
	ServletContext context;

	@RequestMapping(value = "/import" , method= RequestMethod.GET)
	public String imp() {
		String path = context.getRealPath("/resources/domande");
		System.out.println(path);
		dbImportService.importFromXml(path);
		return "import";
	}
}
