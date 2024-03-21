package entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "fulltime_students")
public class FullTimeStudent extends Student{
	
	private String faculty;
	private String department;
	public FullTimeStudent(String id, String name, String email, LocalDate dob, String faculty, String department) {
		super(id, name, email, dob);
		this.faculty = faculty;
		this.department = department;
	}
}
