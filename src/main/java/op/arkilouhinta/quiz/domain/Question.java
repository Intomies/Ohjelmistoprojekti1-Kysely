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



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String questionText;
	private boolean isMultipleChoice;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="questionnaireId")
	private Questionnaire questionnaire;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
	private List<MultipleChoice> multipleChoiceList;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
	private List<Answer> answerList;
	
	public Question(String questionText, Questionnaire questionnaire) {
		super();
		this.questionText = questionText;
		this.questionnaire = questionnaire;
	}
}
