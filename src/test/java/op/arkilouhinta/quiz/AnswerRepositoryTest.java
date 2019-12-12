package op.arkilouhinta.quiz;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import op.arkilouhinta.quiz.domain.Answer;
import op.arkilouhinta.quiz.domain.AnswerRepository;
import op.arkilouhinta.quiz.domain.Question;
import op.arkilouhinta.quiz.domain.QuestionType;
import op.arkilouhinta.quiz.domain.Questionnaire;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnswerRepositoryTest {
	
	@Autowired
	private AnswerRepository repository;
	
	Questionnaire tquestionnaire = new Questionnaire("test1", "Test Questionnaire");
	QuestionType qt1 = new QuestionType("Text");
	Question q1 = new Question("Koulutusohjelma?", tquestionnaire, qt1);
	
	@Test
	public void createAnswerAndDeleteIt() {
		Answer a1 = new Answer("Digi", q1);
		repository.save(a1);
		assertThat(repository.findById(a1.getAnswerId())).isNotNull();
		
		repository.delete(a1);
		assertThat(repository.findById(a1.getAnswerId())).isEmpty();
		
	}
	

}
