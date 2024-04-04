package entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DepartmentID")
	private int id;
	@Column(name = "Administrator")
	private int administartor;
	@Column(name = "Budget")
	private double budget;
	@Column(name = "Name")
	private String name;
	@Column(name = "StartDate")
	private LocalDateTime startDate;
	
	@OneToMany(mappedBy = "department")
	private List<Course> courses;
}
