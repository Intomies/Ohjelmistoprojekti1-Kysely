package op.arkilouhinta.quiz.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SelectionRepository extends CrudRepository <Selection, Long> {
	
	List<Selection> findBySelectionId(Long id);
}
