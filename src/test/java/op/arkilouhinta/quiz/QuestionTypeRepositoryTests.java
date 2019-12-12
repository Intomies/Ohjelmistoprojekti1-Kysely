package op.arkilouhinta.quiz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionRepository;
import op.arkilouhinta.quiz.domain.QuestionType;
import op.arkilouhinta.quiz.domain.QuestionTypeRepository;
import op.arkilouhinta.quiz.domain.Questionnaire;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionTypeRepositoryTests {

	@Autowired
	private QuestionTypeRepository repository;

	@Test
	public void createNewQuestionAndThenDeleteItTest() {
		QuestionType qt = new QuestionType("Text");
		repository.save(qt);
		assertThat(repository.findById(qt.getQuestionTypeId())).isNotNull();
		repository.deleteById(qt.getQuestionTypeId());
		assertThat(repository.findById(qt.getQuestionTypeId())).isEmpty();
	}

}
