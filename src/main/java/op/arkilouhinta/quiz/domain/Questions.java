package op.arkilouhinta.quiz.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long questionId;
	@Getter @Setter private String Question;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "questions")
	private List<Questionaire> questionaires;
	
	
}
