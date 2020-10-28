package it.beije.quiz.service.old;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.quiz.entity.Chapter;
import it.beije.quiz.repository.ChapterRepository;

@Service
public class ChapterService {

	@Autowired
	private ChapterRepository chapterRepo;

	public Chapter getChapter(Integer book, String cName) {
		Optional<Chapter> optChapter = chapterRepo.getByBookIdAndTitle(book, cName);
		return optChapter.isPresent() ? optChapter.get() : null;
	}

}
