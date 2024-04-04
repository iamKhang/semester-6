package entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course {
	@Id
	@Column(name = "courseID")
	protected int id;
	protected String title;
	protected int creadits;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
	private List<Instructor> instructors;
}
