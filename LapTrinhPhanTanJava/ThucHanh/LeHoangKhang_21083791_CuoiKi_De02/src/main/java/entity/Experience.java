package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "experiences")
public class Experience implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6772607189320510851L;

	@Id
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "from_date")
	private LocalDate fromDate;
	@Column(name = "to_date")
	private LocalDate toDate;
	private String description;
	@Override
	public String toString() {
		return "Experience [position=" + position + ", companyName=" + companyName + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", description=" + description + "]";
	}
	
	
	
}
