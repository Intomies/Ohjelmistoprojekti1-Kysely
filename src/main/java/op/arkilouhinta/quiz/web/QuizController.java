package op.arkilouhinta.quiz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionRepository;
import op.arkilouhinta.quiz.domain.Questionnaire;
import op.arkilouhinta.quiz.domain.QuestionnaireRepository;

@Controller
public class QuizController {
	
	@Autowired
	private QuestionnaireRepository quizRepo;
	
	@Autowired private QuestionRepository questionRepo;
	
	//Front page
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//Show all questionnaires in Thymeleaf template
	@GetMapping("/questionnairelist")
	public String getQuestionnaires(Model model) {
		model.addAttribute("questionnaires", quizRepo.findAll());
		return "questionnairelist";
	}
	
	//Find all questions that are in question repository
	@GetMapping("/questionlist")
	public String getQuestions(Model model) {
		model.addAttribute("questions", questionRepo.findAll());
		return "questionlist";
	}
	
	//Add new quiz
	@PostMapping("/addquestionnaire")
	public String saveQuestionnaire(@ModelAttribute Questionnaire questionnaire) {
		quizRepo.save(questionnaire);
		return "questionnairelist";
	}
	
	//Add new question
	@PostMapping("/addquestion")
	public String saveQuestion(Question question) {
		questionRepo.save(question);
		return "redirect:/questionlist";
	}
	
	//---REST METHODS---
	
	

}
