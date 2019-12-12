package op.arkilouhinta.quiz;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import op.arkilouhinta.quiz.domain.Answer;
import op.arkilouhinta.quiz.domain.AnswerRepository;
import op.arkilouhinta.quiz.domain.AnswerSelection;
import op.arkilouhinta.quiz.domain.AnswerSelectionRepository;
import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionType;
import op.arkilouhinta.quiz.domain.Questionnaire;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnswerSelectionRepositoryTest {
	
	@Autowired
	private AnswerSelectionRepository repository;
	
	Questionnaire tquestionnaire = new Questionnaire("test1", "Test Questionnaire");
	QuestionType qt1 = new QuestionType("Text");
	Question q1 = new Question("Koulutusohjelma?", tquestionnaire, qt1);
	Answer a1 = new Answer("Digi", q1);
	
	@Test
	public void createAnswerAndDeleteIt() {
		AnswerSelection aS1 = new AnswerSelection("Digi",a1);
		repository.save(aS1);
		assertThat(repository.findById(aS1.getAnswerSelectionId())).isNotNull();
		
		repository.delete(aS1);
		assertThat(repository.findById(aS1.getAnswerSelectionId())).isEmpty();
		
	}
	

}
