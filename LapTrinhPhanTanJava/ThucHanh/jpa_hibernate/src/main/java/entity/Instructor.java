package entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Instructor extends Person {
	private String location;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp timestamp;
	@OneToOne(mappedBy = "instructor")
	private OfficeAssignment officeAssignment;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CourseInstructor", joinColumns = @JoinColumn(name = "instructorID"), inverseJoinColumns = @JoinColumn(name = "courseID"))
	private List<Course> courses;
}
