package op.arkilouhinta.quiz.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionRepository;
import op.arkilouhinta.quiz.domain.Questionnaire;
import op.arkilouhinta.quiz.domain.QuestionnaireRepository;

@Controller
public class QuizController {

	@Autowired
	private QuestionnaireRepository quizRepo;

	@Autowired
	private QuestionRepository questionRepo;

	// Front page
	@GetMapping("/")
	public String index() {
		return "index";
	}

	// Show all questionnaires in Thymeleaf template
	@GetMapping("/questionnairelist")
	public String getQuestionnaires(Model model) {
		model.addAttribute("questionnaires", quizRepo.findAll());
		return "questionnairelist";
	}

	// Find all questions that are in question repository
	@GetMapping("/questionlist")
	public String getQuestions(Model model) {
		model.addAttribute("questions", questionRepo.findAll());
		return "questionlist";
	}

	// Empty form for adding a new questionnaire
	@GetMapping("/addquestionnaire")
	public String getEmptyQuizForm(Model model) {
		model.addAttribute("quiz", new Questionnaire());
		return "addquestionnaire";
	}

	// Add new quiz
	@PostMapping("/addquestionnaire")
	public String saveQuestionnaire(@ModelAttribute Questionnaire questionnaire) {
		quizRepo.save(questionnaire);
		return "questionnairelist";
	}

	// Empty form for adding a new question
	@GetMapping("/addquestion")
	public String getEmptyQuestionForm(Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("quizs", quizRepo.findAll());
		return "addquestion";
	}

	// Add new question
	@PostMapping("/addquestion")
	public String saveQuestion(Question question) {
		questionRepo.save(question);
		return "redirect:/questionlist";
	}

	// ---REST METHODS---

	// Restful get all questionnaires
	@GetMapping("/questionnaires")
	public @ResponseBody List<Questionnaire> getQuizsRest() {
		return (List<Questionnaire>) quizRepo.findAll();
	}

	// Restful get all questions
	@GetMapping("/questions")
	public @ResponseBody List<Question> getQuestionsRest() {
		return (List<Question>) questionRepo.findAll();
	}

	// Restful get questionnaire by id
	@GetMapping("questionnaire/{id}")
	public @ResponseBody Optional<Questionnaire> getQuizRest(@PathVariable("id") Long quizId) {
		return quizRepo.findById(quizId);
	}

	// Restful get question by id
	@GetMapping("question/{id}")
	public @ResponseBody Optional<Question> getQuestionRest(@PathVariable("id") Long questionId) {
		return questionRepo.findById(questionId);
	}

	// Restful save new questionnaire
	@PostMapping("/questionnaires")
	public @ResponseBody Questionnaire saveQuizRest(@RequestBody Questionnaire quiz) {
		return quizRepo.save(quiz);
	}

	// Restful save new question? How do we get {questionnaire id} into this method?

}
