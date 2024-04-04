package entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class OfficeAssignment {
	@Id
	@OneToOne
	@JoinColumn(name = "InstructorID")
	private Instructor instructor;
	@Column(name = "Location")
	private String location;
	@Column(name = "Timestamp")
	private Timestamp timestamp;
	
}
