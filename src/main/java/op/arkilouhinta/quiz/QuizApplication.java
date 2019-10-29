package op.arkilouhinta.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionRepository;
import op.arkilouhinta.quiz.domain.Questionnaire;
import op.arkilouhinta.quiz.domain.QuestionnaireRepository;


@SpringBootApplication
public class QuizApplication {
	
	private static final Logger log = LoggerFactory.getLogger(QuizApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner quizDemo(QuestionnaireRepository questionnaireRepository, QuestionRepository questionRepository) { 
		return (args) -> {
			log.info("save 5 questions");
			
			//create new questionnaire
			Questionnaire questionnaire = new Questionnaire("test1");
			questionnaireRepository.save(questionnaire);
			
			// create questions
			Question q1 = new Question("Koulutusohjelma?", questionnaire);
			Question q2 = new Question("Ikä?", questionnaire);
			Question q3 = new Question("Miten parantaisit viihtyvyyttä yleisissä tiloissa?", questionnaire);
			Question q4 = new Question("Miten parantaisit viihtyvyyttä opiskelutiloissa?", questionnaire);
			Question q5 = new Question("Muuta lisättävää?", questionnaire);
			
			questionRepository.save(q1);
			questionRepository.save(q2);
			questionRepository.save(q3);
			questionRepository.save(q4);
			questionRepository.save(q5);
			
			
			log.info("fetch all questions");
			for (Question question : questionRepository.findAll()) {
				log.info(question.toString());
			}

		};
	}
}
