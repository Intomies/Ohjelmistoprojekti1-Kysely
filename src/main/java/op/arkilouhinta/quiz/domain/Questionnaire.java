package op.arkilouhinta.quiz.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questionnaire {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionnaireId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionnaire")
	private List<Question> questionList;
	
	public Questionnaire() {
		super();
	}

	public Questionnaire(String name) {
		super();
		this.name = name;
	}

	public Questionnaire(long questionnaireId, String name, List<Question> questionList) {
		super();
		this.questionnaireId = questionnaireId;
		this.name = name;
		this.questionList = questionList;
	}
	
	public Questionnaire(String name, List<Question> questionList) {
		super();
		this.name = null;
		this.questionList = null;
	}

	public long getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "Questionnaire [questionnaireId=" + questionnaireId + ", name=" + name + "]";
	}
	
	
}
