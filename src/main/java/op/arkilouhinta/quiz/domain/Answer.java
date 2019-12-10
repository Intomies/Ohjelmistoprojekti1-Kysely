package op.arkilouhinta.quiz.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private Long answerId;
	//private String answerText;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="answer")
	private List<AnswerSelection> answers;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="question")
	private Question question;
	private String answerText;

	public Answer(String answerText, Question question) {
		super();
		this.answerText = answerText;
		this.question = question;
	}
	
	// For multiple choice questions 
	public Answer(MultipleChoice multipleChoice, Question question) {
		
	}

}
