package op.arkilouhinta.quiz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

<<<<<<< HEAD
=======
import op.arkilouhinta.quiz.domain.Questionnaire;
>>>>>>> 00807b1db684d845e6a496f1a2763b4ac0287120
import op.arkilouhinta.quiz.domain.QuestionnaireRepository;

@Controller
public class QuizController {
	
	@Autowired
	private QuestionnaireRepository repository;
	
	//Front page
	@GetMapping("/")
	public String index() {
		return "/";
	}
	
	//Show all quoestionnaires in Thymeleaf template
<<<<<<< HEAD
	@GetMapping("/questionnaires")
	public String questionnaires(Model model) {
		model.addAttribute("questionnaires", repository.findAll());
		return "questionnaires";
=======
	@GetMapping("quoestionnaires")
	public String questionnares(Model model) {
		model.addAttribute("quoeastionnaires", repository.findAll());
		return "questionnaires";
>>>>>>> 00807b1db684d845e6a496f1a2763b4ac0287120
	}
	
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String save(Questionnaire questionnaire) {
		repository.save(questionnaire);
		return "questionnaires:";
	}
	
	

}
