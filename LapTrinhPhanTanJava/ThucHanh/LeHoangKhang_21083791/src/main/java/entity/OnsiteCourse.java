package entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class OnsiteCourse extends Course{
	@Column(name = "Days")
	private String days;
	@Column(name = "Location")
	private String location;
	@Column(name = "Time")
	private LocalDateTime time;
}
