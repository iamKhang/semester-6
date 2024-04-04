package entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor()
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("Instructor")
public class Instructor extends Person{
	private String location;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HireDate")
	private Timestamp hireDate;
	@OneToOne(mappedBy = "instructor")
	private OfficeAssignment officeAssignment;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CourseInstructor", joinColumns = @JoinColumn(name = "PersonID"), inverseJoinColumns = @JoinColumn(name = "CourseID"))
	private List<Course> courses;


	public Instructor(String firstName, String lastName, String location, Timestamp hireDate) {
		super(firstName, lastName);
		this.location = location;
		this.hireDate = hireDate;
	}


	public Instructor(int id, String firstName, String lastName, String location, Timestamp hireDate) {
		super(id, firstName, lastName);
		this.location = location;
		this.hireDate = hireDate;
	}
	
	

	
	
}
