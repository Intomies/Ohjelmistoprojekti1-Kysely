package op.arkilouhinta.quiz.domain;

import java.util.List;

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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Selection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long selectionId;
	private String option;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "multipleChoice")
	private MultipleChoice multipleChoice;

	public Selection(String option, MultipleChoice multipleChoice) {
		super();
		this.option = option;
		this.multipleChoice = multipleChoice;
	}

}
