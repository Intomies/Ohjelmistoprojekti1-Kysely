package op.arkilouhinta.quiz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	@GetMapping("/questionnaires")
	public String questionnaires(Model model) {
		model.addAttribute("questionnaires", repository.findAll());
		return "questionnaires";
	}
	
	
	

}