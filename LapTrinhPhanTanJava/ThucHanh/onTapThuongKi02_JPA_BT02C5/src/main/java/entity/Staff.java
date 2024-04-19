package entity;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "staffs")
public class Staff {
	@Id
	@Column(name = "staff_id")
	private long id;

	@Column(name = "staff_name")
	private String name;
	
	@ElementCollection
	@CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "staff_id"))
	private Set<String> phoneNumbers;
	
	@Column(name = "refers")
	private String references;
	
	private int age;
	
	@OneToOne(mappedBy = "staff")
	private Profile profile;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department department;
	
	@ManyToMany(mappedBy = "staffs")
	private Set<Project> projects;
}
