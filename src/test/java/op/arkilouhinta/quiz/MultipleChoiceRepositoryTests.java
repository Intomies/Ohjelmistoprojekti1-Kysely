package op.arkilouhinta.quiz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import op.arkilouhinta.quiz.domain.MultipleChoice;
import op.arkilouhinta.quiz.domain.MultipleChoiceRepository;
import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionRepository;
import op.arkilouhinta.quiz.domain.QuestionType;
import op.arkilouhinta.quiz.domain.Questionnaire;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MultipleChoiceRepositoryTests {
	
	@Autowired 
	private MultipleChoiceRepository repository;
	private QuestionType qt = new QuestionType("Text");
	private Questionnaire quiz = new Questionnaire("Test", "TTest");
	private Question question = new Question("Test", quiz, qt);
	
	@Test
	public void createNewQuestionAndThenDeleteItTest() {
		MultipleChoice mc = new MultipleChoice("Choice", question);
		repository.save(mc);
		assertThat(repository.findById(mc.getMultipleChoiceId())).isNotNull();
		repository.deleteById(mc.getMultipleChoiceId());
		assertThat(repository.findById(mc.getMultipleChoiceId())).isEmpty();
	}
	

}
