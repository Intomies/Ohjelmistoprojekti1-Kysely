package op.arkilouhinta.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import op.arkilouhinta.quiz.domain.Answer;
import op.arkilouhinta.quiz.domain.AnswerRepository;
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
	public CommandLineRunner quizDemo(QuestionnaireRepository questionnaireRepository, QuestionRepository questionRepository,
			AnswerRepository answerRepository) { 
		return (args) -> {
			log.info("save 5 questions");
			
			//create new questionnaire
			Questionnaire tquestionnaire = new Questionnaire("test1");
			questionnaireRepository.save(tquestionnaire);
			
			// create questions
			Question q1 = new Question("Koulutusohjelma?", tquestionnaire);
			Question q2 = new Question("Ikä?", tquestionnaire);
			Question q3 = new Question("Miten parantaisit viihtyvyyttä yleisissä tiloissa?", tquestionnaire);
			Question q4 = new Question("Miten parantaisit viihtyvyyttä opiskelutiloissa?", tquestionnaire);
			Question q5 = new Question("Muuta lisättävää?", tquestionnaire);
			
			questionRepository.save(q1);
			questionRepository.save(q2);
			questionRepository.save(q3);
			questionRepository.save(q4);
			questionRepository.save(q5);
			
			// Create answers
			Answer a1 = new Answer("Digi", q1);
			Answer a2 = new Answer("25", q2);
			Answer a3 = new Answer("Olisi mukava saada enemmän viherkasveja yleisiin tiloihin", q3);
			Answer a4 = new Answer("Opiskelutiloissa voisi olla pöytiä, minkä ääressä voisi tehdä töitä seisten", q4);
			Answer a5 = new Answer("Espresso saisi olla edullisempi kahvilassa", q5);
			
			answerRepository.save(a1);
			answerRepository.save(a2);
			answerRepository.save(a3);
			answerRepository.save(a4);
			answerRepository.save(a5);
			
			
			
			/*
			 * log.info("fetch all questions"); for (Questionnaire questionnaire :
			 * questionnaireRepository.findAll()) { log.info(questionnaire.toString()); }
			 */
		};
	}
}
