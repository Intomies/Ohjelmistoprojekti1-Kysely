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

import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.Questionnaire;
import op.arkilouhinta.quiz.domain.QuestionnaireRepository;

@CrossOrigin
@Controller
public class QuestionnaireController {

	@Autowired
	private QuestionnaireRepository quizRepo;


	// Show all questionnaires in Thymeleaf template
	@GetMapping("/questionnairelist")
	public String getQuestionnaires(Model model) {
		model.addAttribute("questionnaires", quizRepo.findAll());
		return "questionnairelist";
	}
	
	// Show all questions for selected questionnaire
	@GetMapping(value = "/questionnaire/{id}")
	public String findReservationById(@PathVariable("id") long questionnaireId, Questionnaire q, Model model) {
		model.addAttribute("questionnaire", quizRepo.findById(questionnaireId));
		List<Question> qList = q.getQuestionList();
		model.addAttribute("questions", qList);
		return "questionlist";
	}

	// Empty form for adding a new quiz
	@GetMapping("/addquestionnaire")
	public String getEmptyQuizForm(@ModelAttribute Questionnaire questionnaire) {
		return "addquestionnaire";
	}

	// Add new quiz
	@PostMapping("/addquestionnaire")
	public String saveQuestionnaire(Questionnaire questionnaire) {
		quizRepo.save(questionnaire);
		return "redirect:/questionnairelist";
	}

	// ---REST METHODS---

	// GET-methods

	// Restful get all questionnaires
	@GetMapping("/questionnaires")
	public @ResponseBody List<Questionnaire> getQuizsRest() {
		return (List<Questionnaire>) quizRepo.findAll();
	}

	// Restful get questionnaire by id
	@GetMapping("questionnaires/{id}")
	public @ResponseBody Optional<Questionnaire> getQuizRest(@PathVariable("id") Long quizId) {
		return quizRepo.findById(quizId);
	}

	// POST-methods

	// Restful save new questionnaire
	@PostMapping("/questionnaires")
	public @ResponseBody Questionnaire saveQuizRest(@RequestBody Questionnaire quiz) {
		return quizRepo.save(quiz);
	}

}
