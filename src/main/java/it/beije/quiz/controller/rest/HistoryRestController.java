package it.beije.quiz.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
public class HistoryRestController {

	@Autowired
	private ParticipateService participareService;
	@GetMapping("/exams/{userId}")
	public List<Participate> getUserExams(@PathVariable Integer userId) {
		return participateService.getAllByUserId(userId);
	}
	
}
