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
@Table(name = "parttime_students")
public class PartTimeStudent extends Student{
	
	private String supervisor;

	public PartTimeStudent(String id, String name, String email, LocalDate dob, String supervisor) {
		super(id, name, email, dob);
		this.supervisor = supervisor;
	}
}
