package examination;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistics")
public class Statistics {

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int statis_id;
	
	private LocalDateTime data;

	
	public Statistics() {
		
	}
}
