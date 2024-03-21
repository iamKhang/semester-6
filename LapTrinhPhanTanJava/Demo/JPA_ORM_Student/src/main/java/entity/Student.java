package entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "students")
@Inheritance(strategy = InheritanceType.JOINED)
public class Student {
	@Id
	@Column(name="student_id")
	protected String id;
	@Column(columnDefinition = "nvarchar(100)", nullable = false)
	protected String name;
	@Column(unique = true, nullable = false)
	protected String email;
	protected LocalDate dob;
	
	@ElementCollection
	@CollectionTable(name="phones", joinColumns = @JoinColumn(name="student_id"))
	@Column(name="phone", nullable = false)
	protected Set<String> phones;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="class_id")
	protected Clazz clazz;
	
	@Embedded
	protected Address address;
	
	@Enumerated(EnumType.STRING)
	protected Gender gender;
	
//	protected List<Student> students;
	
	@ManyToOne
	@JoinColumn(name="manager_id")
	protected Student manager;
	
	public Student(String id, String name, String email, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
}
