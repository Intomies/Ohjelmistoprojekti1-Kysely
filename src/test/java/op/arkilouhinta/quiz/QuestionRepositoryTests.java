package op.arkilouhinta.quiz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionRepository;
import op.arkilouhinta.quiz.domain.Questionnaire;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionRepositoryTests {
	
	@Autowired 
	private QuestionRepository repository;
	private Questionnaire quiz = new Questionnaire("Test");
	
	@Test
	public void createNewQuestionandThenDeleteItTest() {
		Question question = new Question("Test", quiz);
		repository.save(question);
		assertThat(repository.findById(question.getQuestionId())).isNotNull();
		repository.deleteById(question.getQuestionId());
		assertThat(repository.findById(question.getQuestionId())).isEmpty();
	}

}
