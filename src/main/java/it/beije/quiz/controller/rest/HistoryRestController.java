//package it.beije.quiz.controller.rest;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import it.beije.quiz.entity.Partecipate;
//import it.beije.quiz.service.PartecipateService;
//
//@RestController
//@RequestMapping("/history")
//public class HistoryRestController {
//
//	@Autowired
//	private PartecipateService partecipateService;
//
//	@GetMapping("/exams/{userId}")
//	public List<Partecipate> getUserExams(@PathVariable Integer userId) {
//		return partecipateService.getAllByUserId(userId);
//	}
//
//	//TODO Should return all questions of given Partecipate of given User
////	@GetMapping("/exam/")
////	public
//
//}
