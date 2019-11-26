package op.arkilouhinta.quiz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long answerId;
	private String answerText;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="question")
	private Question question;

	public Answer(String answerText, Question question) {
		super();
		this.answerText = answerText;
		this.question = question;
	}

}
