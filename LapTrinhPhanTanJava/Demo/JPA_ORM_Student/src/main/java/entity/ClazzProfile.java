package entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "classe_profiles")
public class ClazzProfile {
	@Id
	@Column(name = "profile_id")
	private String id;
	
	@OneToOne
	@JoinColumn(name = "class_id", unique = true, nullable = false)
	private Clazz clazz;
	private LocalDate createDate;
	private String description;
	
}
