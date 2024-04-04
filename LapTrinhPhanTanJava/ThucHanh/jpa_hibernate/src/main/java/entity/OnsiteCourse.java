package entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
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
public class OnsiteCourse extends Course {
	private String days;
	private String location;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime time;
}
