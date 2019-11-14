package op.arkilouhinta.quiz;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import op.arkilouhinta.quiz.domain.Questionnaire;
import op.arkilouhinta.quiz.domain.QuestionnaireRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionnaireRepositoryTests {
	
	@Autowired
	private QuestionnaireRepository repository;
	
	@Test
	public void findByNameReturnsQuestionnaireTest() {
		List<Questionnaire> quizzes = (List<Questionnaire>) repository.findAll();
		assertThat(repository.findByName(quizzes.get(0).getName())).isNotNull();
	}
	
	@Test
	public void createQuizAndThenDeleteItTest() {
		Questionnaire quiz = new Questionnaire("Test", "Testquest");
		repository.save(quiz);
		assertThat(repository.findById(quiz.getQuestionnaireId())).isNotNull();
		repository.deleteById(quiz.getQuestionnaireId());
		assertThat(repository.findById(quiz.getQuestionnaireId())).isEmpty();
	}


}
