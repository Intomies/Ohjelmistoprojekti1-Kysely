package op.arkilouhinta.quiz.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionnaireRepository extends CrudRepository<Questionnaire, Long> {

	List<Questionnaire> findByName(String name);
	Questionnaire findById(long id);
	
}
