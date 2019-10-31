package op.arkilouhinta.quiz.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String question;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="id")
	private Questionnaire questionnaire;

	public Question(String question, Questionnaire questionnaire) {
		super();
		this.question = question;
		this.questionnaire = questionnaire;
	}
	
}
