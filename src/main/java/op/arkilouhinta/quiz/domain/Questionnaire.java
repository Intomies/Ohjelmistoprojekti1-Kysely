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
public class Questionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionnaireId;
	private String name;
	private String questionnaireInfo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaire")
	private List<Question> questionList;
	
	public Questionnaire(String name, String questionnaireInfo) {
		super();
		this.name = name;
		this.questionnaireInfo = questionnaireInfo;
	}
}