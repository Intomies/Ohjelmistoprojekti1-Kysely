package op.arkilouhinta.quiz.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answer {
	
	private long answerId;
	private String answerText;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="question")
	private Question question;

	public Answer(String answerText, Question question) {
		super();
		this.answerText = answerText;
		this.question = question;
	}

}
