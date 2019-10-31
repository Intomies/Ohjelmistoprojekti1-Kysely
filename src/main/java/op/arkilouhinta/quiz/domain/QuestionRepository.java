package op.arkilouhinta.quiz.domain;


import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	
	//List<Question> findByName(String name);
	
	
}
