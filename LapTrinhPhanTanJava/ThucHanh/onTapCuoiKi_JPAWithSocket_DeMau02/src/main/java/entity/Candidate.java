package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidates")
public class Candidate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9053157744006869050L;
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

	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;

	@OneToMany(mappedBy = "candidate")
	private List<Experience> experiences;

	public Candidate() {
		super();
	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
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

	
}
