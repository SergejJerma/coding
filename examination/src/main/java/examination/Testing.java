package examination;

import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "testing")
public class Testing {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testing_id;
	
	private int marks;
	private String result;
	private HashMap <Integer,Integer> allAns;
	
	@ManyToOne()
	@JoinColumn(name = "stud_id")
	private Student student;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "test_id")
	private Test test;

	
	public Testing(){
		
	}
	
	

	public Testing(int marks, String result, HashMap<Integer, Integer> allAns) {
		super();
		this.marks = marks;
		this.result = result;
		this.allAns = allAns;
	}



	public int getId() {
		return testing_id;
	}


	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public HashMap<Integer, Integer> getAllAns() {
		return allAns;
	}

	public void setAllAns(HashMap<Integer, Integer> allAns) {
		this.allAns = allAns;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	
}
