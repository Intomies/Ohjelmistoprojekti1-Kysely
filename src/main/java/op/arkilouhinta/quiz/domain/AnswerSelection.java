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
public class AnswerSelection {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerSelectionId;
	private String answerText;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="answer")
	private Answer answer;
	
	public AnswerSelection(String answerText) {
		super();
		this.answerText = answerText;
	}
}
