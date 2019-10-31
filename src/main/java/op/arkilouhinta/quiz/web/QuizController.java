package op.arkilouhinta.quiz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import op.arkilouhinta.quiz.domain.Questionnaire;

import op.arkilouhinta.quiz.domain.QuestionnaireRepository;

@Controller
public class QuizController {
	
	@Autowired
	private QuestionnaireRepository repository;
	
	//Front page
	@GetMapping("/l")
	public String index() {
		return "index";
	}
	
	//Show all quoestionnaires in Thymeleaf template
	@GetMapping("/questionnaires")
	public String questionnaires(Model model) {
		model.addAttribute("questionnaires", repository.findAll());
		return "questionnaires";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String save(Questionnaire questionnaire) {
		repository.save(questionnaire);
		return "questionnaires:";
	}
	
	

}
