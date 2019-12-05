package op.arkilouhinta.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import op.arkilouhinta.quiz.domain.Answer;
import op.arkilouhinta.quiz.domain.AnswerRepository;
import op.arkilouhinta.quiz.domain.MultipleChoice;
import op.arkilouhinta.quiz.domain.MultipleChoiceRepository;
import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionRepository;
import op.arkilouhinta.quiz.domain.QuestionType;
import op.arkilouhinta.quiz.domain.QuestionTypeRepository;
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
			QuestionTypeRepository qtRepo, MultipleChoiceRepository mcRepo, AnswerRepository answerRepository) { 
		return (args) -> {
			log.info("save 5 questions");
			
			//create new questionnaire
			Questionnaire tquestionnaire = new Questionnaire("test1", "Test Questionnaire");
			questionnaireRepository.save(tquestionnaire);
			
			//Create question types
			QuestionType qt1 = new QuestionType("Text");
			QuestionType qt2 = new QuestionType("Dropdown");
			QuestionType qt3 = new QuestionType("Radio");
			QuestionType qt4 = new QuestionType("Checkbox");
			
			qtRepo.save(qt1);
			qtRepo.save(qt2);
			qtRepo.save(qt3);
			qtRepo.save(qt4);
			
			// create questions
			Question q1 = new Question("Koulutusohjelma?", tquestionnaire, qt1);
			Question q2 = new Question("Ikä?", tquestionnaire, qt1);
			Question q3 = new Question("Miten parantaisit viihtyvyyttä yleisissä tiloissa?", tquestionnaire, qt1);
			Question q4 = new Question("Miten parantaisit viihtyvyyttä opiskelutiloissa?", tquestionnaire, qt1);
			Question q5 = new Question("Muuta lisättävää?", tquestionnaire, qt1);
			Question q6 = new Question("Valitse lempijuomasi (yksi tai useampi)", tquestionnaire, qt4);
			Question q7 = new Question("Kumpi on mielestäsi parempi ohjelmointikieli?", tquestionnaire, qt3);
			Question q8 = new Question("Valitse mielestäsi paras karamelli:", tquestionnaire, qt2);
			
			questionRepository.save(q1);
			questionRepository.save(q2);
			questionRepository.save(q3);
			questionRepository.save(q4);
			questionRepository.save(q5);
			questionRepository.save(q6);
			questionRepository.save(q7);
			questionRepository.save(q8);
			
			//Create multiple choices for q6
			MultipleChoice mc1 = new MultipleChoice("Coca Cola", q6);
			MultipleChoice mc2 = new MultipleChoice("Fanta", q6);
			MultipleChoice mc3 = new MultipleChoice("Sprite", q6);
			MultipleChoice mc4 = new MultipleChoice("Java", q7);
			MultipleChoice mc5 = new MultipleChoice("Python", q7);
			MultipleChoice mc6 = new MultipleChoice("Dumle", q8);
			MultipleChoice mc7 = new MultipleChoice("Geisha", q8);
			MultipleChoice mc8 = new MultipleChoice("Vanhat Autot", q8);
			
			mcRepo.save(mc1);
			mcRepo.save(mc2);
			mcRepo.save(mc3);
			mcRepo.save(mc4);
			mcRepo.save(mc5);
			
			// Create answers
			Answer a1 = new Answer("Digi", q1);
			Answer a2 = new Answer("25", q2);
			Answer a3 = new Answer("Olisi mukava saada enemmän viherkasveja yleisiin tiloihin", q3);
			Answer a4 = new Answer("Opiskelutiloissa voisi olla pöytiä, minkä ääressä voisi tehdä töitä seisten", q4);
			Answer a5 = new Answer("Espresso saisi olla edullisempi kahvilassa", q5);
			Answer a6 = new Answer("Ohtu", q1);
			
			answerRepository.save(a1);
			answerRepository.save(a2);
			answerRepository.save(a3);
			answerRepository.save(a4);
			answerRepository.save(a5);
			answerRepository.save(a6);
			
			
			
			/*
			 * log.info("fetch all questions"); for (Questionnaire questionnaire :
			 * questionnaireRepository.findAll()) { log.info(questionnaire.toString()); }
			 */
		};
	}
}
