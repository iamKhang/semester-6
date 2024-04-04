package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CourseID")
	protected int id;
	@Column(name = "Credits")
	protected int credits;
	@Column(name = "Title")
	protected String title;
	
	@OneToMany(mappedBy = "course")
	private List<StudentGrade> studentGrades;
	
	
	@ManyToOne
	@JoinColumn(name = "DepartmentID")
	private Department department;
	
	@ManyToMany(mappedBy = "courses")
	private List<Instructor> instructors;
}
