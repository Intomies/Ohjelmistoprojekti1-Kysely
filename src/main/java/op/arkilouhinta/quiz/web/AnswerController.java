package op.arkilouhinta.quiz.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import op.arkilouhinta.quiz.domain.Answer;
import op.arkilouhinta.quiz.domain.AnswerRepository;
import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionRepository;
import op.arkilouhinta.quiz.domain.Questionnaire;
import op.arkilouhinta.quiz.domain.QuestionnaireRepository;

@CrossOrigin
@Controller
public class AnswerController {

	@Autowired
	private AnswerRepository answerRepo;


	// ---REST METHODS---

	//GET-methods
	

	// Restful get all answers
	@GetMapping("/answers")
	public @ResponseBody List<Answer> getAnswersRest() {
		return (List<Answer>) answerRepo.findAll();
	}
	
	// Restful get answer by id
	@GetMapping("answers/{id}")
	public @ResponseBody Optional<Answer> getAnswerRest(@PathVariable("id") Long answerId) {
		return answerRepo.findById(answerId);
	}
	
	//POST-methods

	// Restful add new answer
	@PostMapping("/answers")
	public @ResponseBody Answer saveAnswerRest(@RequestBody Answer answer) {
		return answerRepo.save(answer);
	}
	
}
