package entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class Student extends Person {
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EnrollmentDate")
	private LocalDateTime enrollmentDate;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<StudentGrade> studentGrades;

	public Student(int id, String firstName, String lastName, LocalDateTime enrollmentDate,
			List<StudentGrade> studentGrades) {
		super(id, firstName, lastName);
		this.enrollmentDate = enrollmentDate;
		this.studentGrades = studentGrades;
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		super.firstName = firstName;

	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		super.lastName = lastName;
	}

}
