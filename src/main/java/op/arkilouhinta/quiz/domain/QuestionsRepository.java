package op.arkilouhinta.quiz.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionsRepository extends CrudRepository<Questions, Long> {

	
	List<Questions> findByName(String name);
	
	
}
