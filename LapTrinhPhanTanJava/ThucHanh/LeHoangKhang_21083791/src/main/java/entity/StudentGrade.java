package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class StudentGrade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EnrollmentID")
	private int enrollmentID;
	@Column(name = "Grade")
	private double grade;
	
	@ManyToOne
	@JoinColumn(name = "StudentID")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "CourseID")
	private Course course;
	
}
