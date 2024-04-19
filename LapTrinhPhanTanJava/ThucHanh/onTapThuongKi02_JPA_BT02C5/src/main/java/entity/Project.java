package entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "project")
public class Project {
	@Id
	@Column(name = "project_id")
	private String id;
	@Column(name = "project_name")
	private String name;
	private double budget;

	@ManyToMany
	   @JoinTable(
	            name = "staff_project",
	            joinColumns = @JoinColumn(name = "project_id"),
	            inverseJoinColumns = @JoinColumn(name = "staff_id")
	    )
	private Set<Staff> staffs;
}
