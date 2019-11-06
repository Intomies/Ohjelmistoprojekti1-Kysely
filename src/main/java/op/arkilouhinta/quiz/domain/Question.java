package op.arkilouhinta.quiz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String questionText;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="questionnaireId")
	private Questionnaire questionnaire;
	
	public Question(String questionText, Questionnaire questionnaire) {
		super();
		this.questionText = questionText;
		this.questionnaire = questionnaire;
	}
}
