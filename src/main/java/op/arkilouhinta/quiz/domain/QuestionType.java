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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionTypeId;
	private String typeName;
	private boolean multipleChoice;
	private boolean textQuestion;
	private boolean radioQuestion;
	private boolean checkBox;
	private List<String> optionList;
	
	@OneToMany
	@JsonBackReference
	@JoinColumn(name="questionId")
	private Question question;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
	private List<Answer> answerList;
	
	
	
}
