package op.arkilouhinta.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import op.arkilouhinta.quiz.domain.Answer;
import op.arkilouhinta.quiz.domain.AnswerRepository;
import op.arkilouhinta.quiz.domain.AnswerSelection;
import op.arkilouhinta.quiz.domain.AnswerSelectionRepository;
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
			QuestionTypeRepository qtRepo, MultipleChoiceRepository mcRepo, AnswerRepository answerRepository, AnswerSelectionRepository asRepo) { 
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
			
			questionRepository.save(q1);
			questionRepository.save(q2);
			questionRepository.save(q3);
			questionRepository.save(q4);
			questionRepository.save(q5);
			questionRepository.save(q6);
			
			//Create multiple choices for q6
			MultipleChoice mc1 = new MultipleChoice("Coca Cola", q6);
			MultipleChoice mc2 = new MultipleChoice("Fanta", q6);
			MultipleChoice mc3 = new MultipleChoice("Sprite", q6);
			
			mcRepo.save(mc1);
			mcRepo.save(mc2);
			mcRepo.save(mc3);
			
			// Create answers
			Answer a1 = new Answer("Digi", q1);
			Answer a2 = new Answer("25", q2);
			Answer a3 = new Answer("Olisi mukava saada enemmän viherkasveja yleisiin tiloihin", q3);
			Answer a4 = new Answer("Opiskelutiloissa voisi olla pöytiä, minkä ääressä voisi tehdä töitä seisten", q4);
			Answer a5 = new Answer("Espresso saisi olla edullisempi kahvilassa", q5);
			// Choose answer from selection
			Answer a6 = new Answer(q6);
			Answer a7 = new Answer("Ohtu", q1);
			
			answerRepository.save(a1);
			answerRepository.save(a2);
			answerRepository.save(a3);
			answerRepository.save(a4);
			answerRepository.save(a5);
			answerRepository.save(a6);
			answerRepository.save(a7);
			

			AnswerSelection as1 = new AnswerSelection(mc1.getChoiceText(), a6);
			AnswerSelection as2 = new AnswerSelection(mc2.getChoiceText(), a6);
			asRepo.save(as1);
			asRepo.save(as2);
			
		};
	}
}
