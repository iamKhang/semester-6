package entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
public class Department {
	@Id
	private int id;
	private int administrator;
	private double budget;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime startDate;
	@OneToMany(mappedBy="department", fetch=FetchType.LAZY)
	private List<Course> courses;
}
