package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8542063349672952019L;
	@Id
	@Column(name = "candidate_id")
	private String id;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "year_of_birth")
	private int yearOfBirth;
	private String gender;
	private String email;
	private String phone;
	private String description;
	
	@OneToMany(mappedBy = "candidate")
	private List<Certificate> certificates;
	
	@OneToMany(mappedBy = "candidate")
	private List<Experience> experiences;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;

	public Candidate(String id, String fullName, int yearOfBirth, String gender, String email, String phone,
			String description) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", fullName=" + fullName + ", yearOfBirth=" + yearOfBirth + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + ", description=" + description + "]";
	}

	public Candidate(String id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
