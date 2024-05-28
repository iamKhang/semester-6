package entity;

import java.time.LocalDate;

import enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Approval {
	@ManyToOne
	@JoinColumn(name = "admin_name")
	private Admin admin;
	private Status status;
	@Column(name = "approval_date")
	private LocalDate approvalDate;
}
