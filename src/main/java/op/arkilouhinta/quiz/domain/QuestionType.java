package op.arkilouhinta.quiz.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionTypeId;
	private String name;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="questionType")
	private List<Question> questions;
	
	public QuestionType(String questionName) {
		super();
		this.name = questionName;
	}
	
	
}
