package op.arkilouhinta.quiz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String questionText;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="questionnaireId")
	private Questionnaire questionnaire;
	
	

	public Question() {
		super();
	}

	public Question(String question, Questionnaire questionnaire) {
		super();
		this.questionText = question;
		this.questionnaire = questionnaire;
	}
	
	public Question(Long questionId, String question, Questionnaire questionnaire) {
		super();
		this.questionId = questionId;
		this.questionText = question;
		this.questionnaire = questionnaire;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", questionnaire="
				+ this.getQuestionnaire() + "]";
	}
	
	
	
}
