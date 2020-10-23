package it.beije.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.quiz.entity.Book;
import it.beije.quiz.entity.Question;
import it.beije.quiz.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private BookService bookService;
	
	public Question load(Integer id) {
		Optional<Question> answer = questionRepository.findById(id);
		
		return answer.isPresent() ? answer.get() : null;
		
	}
	
	public Integer lastId() {
		
		Optional<Question> question = questionRepository.findTopByOrderByIdDesc();
		
		return question.isPresent() ? question.get().getId() : 0;
		
	}

	public void insert(Question question) {
		
		if(question == null) {
			throw new IllegalArgumentException("Question bean is null");
		}
		
		if(!"".equals(question.getExplanation())) {
			
			questionRepository.save(question);
			
		} else {
			throw new IllegalArgumentException("Question bean data is not valid");
		}
	}
	
	public List<Question> loadQuestionsBookAndChapter(Integer idBook, String chapter) {
		
		if(idBook == null) {
			throw new IllegalArgumentException("the id book can't be null");
		}
		
		Book book = bookService.load(idBook);
		if(book == null) {
			throw new IllegalArgumentException("there is no book with id "+idBook);
		}
		
		return questionRepository.findAllByBookIdAndChapter(idBook, chapter);
		
	}
	
	public void loadDomande(Model model, Integer idBook, String[] userSelection){
        List<Question> domande = new ArrayList<Question>();
		for (String s : userSelection){
            domande.addAll(loadQuestionsBookAndChapter(idBook, s));
        }
        int totaleDomande = domande.size();
        model.addAttribute("totDomande", totaleDomande);
    }
}
