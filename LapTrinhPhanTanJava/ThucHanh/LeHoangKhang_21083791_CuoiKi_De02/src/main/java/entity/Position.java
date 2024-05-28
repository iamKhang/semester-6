package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "positions")
public class Position implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1345240819273007693L;
	@Id
	@Column(name = "position_id")
	private String id;
	private String name;
	private String description;
	private double salary;
	private int number;
	
	@OneToMany(mappedBy = "position")
	List<Candidate> appliedCandidates;
	
	@OneToMany(mappedBy = "position")
	List<Experience> experiences;

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", description=" + description + ", salary=" + salary
				+ ", number=" + number + "]";
	}
	
	
}
