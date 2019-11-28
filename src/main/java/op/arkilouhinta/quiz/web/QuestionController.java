package op.arkilouhinta.quiz.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionRepository;
import op.arkilouhinta.quiz.domain.QuestionnaireRepository;

@CrossOrigin
@Controller
public class QuestionController {

	@Autowired
	private QuestionnaireRepository quizRepo;

	@Autowired
	private QuestionRepository questionRepo;

	// Find all questions that are in question repository
	@GetMapping("/questionlist")
	public String getQuestions(Model model) {
		model.addAttribute("questions", questionRepo.findAll());
		return "questionlist";
	}

	// Empty form for adding a new question
	@GetMapping("/addquestion")
	public String getEmptyQuestionForm(Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("quizs", quizRepo.findAll());
		return "addquestion";
	}

	// Save new question
	@PostMapping("/addquestion")
	public String saveQuestion(Question question) {
		questionRepo.save(question);
		return "redirect:/questionlist";
	}

	// ---REST METHODS---

	// GET-methods

	// Restful get all questions
	@GetMapping("/questions")
	public @ResponseBody List<Question> getQuestionsRest() {
		return (List<Question>) questionRepo.findAll();
	}

	// Restful get question by id
	@GetMapping("questions/{id}")
	public @ResponseBody Optional<Question> getQuestionRest(@PathVariable("id") Long questionId) {
		return questionRepo.findById(questionId);
	}

	// POST-methods

	// Restful save new question
	@PostMapping("/questions")
	public @ResponseBody Question saveQuestionRest(@RequestBody Question question) {
		return questionRepo.save(question);
	}

}
