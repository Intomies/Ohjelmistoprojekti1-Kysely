package op.arkilouhinta.quiz.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MultipleChoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long multipleChoiceId;
	
	private String choiceText;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="questionId")
	private Question question;
	
}
