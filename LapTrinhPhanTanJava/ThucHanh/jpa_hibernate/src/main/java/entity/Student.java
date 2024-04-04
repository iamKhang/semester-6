package entity;

import java.time.LocalDateTime;
import java.util.List;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Student extends Person {
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime enrollmentDate;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<StudentGrade> studentGrades;
}
