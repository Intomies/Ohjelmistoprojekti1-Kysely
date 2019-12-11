package op.arkilouhinta.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class QuizApplication {
	
	private static final Logger log = LoggerFactory.getLogger(QuizApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}
	
	
}
