package op.arkilouhinta.quiz.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import op.arkilouhinta.quiz.domain.QuestionType;
import op.arkilouhinta.quiz.domain.QuestionTypeRepository;

@CrossOrigin
@Controller
public class QuestionTypeController {

	@Autowired
	private QuestionTypeRepository qtRepo;

	// ---REST METHODS---

	// GET-methods

	// Restful get all answers
	@GetMapping("/questiontypes")
	public @ResponseBody List<QuestionType> getQuestionTypesRest() {
		return (List<QuestionType>) qtRepo.findAll();
	}
}
