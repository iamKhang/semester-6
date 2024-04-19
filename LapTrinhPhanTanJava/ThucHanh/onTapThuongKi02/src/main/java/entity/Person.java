package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Column(name = "first_name", columnDefinition = "NVARCHAR(50)", nullable = false)
	protected String firstName;
	@Column(name = "last_name", columnDefinition = "NVARCHAR(50)")
	protected String lastName;
	@Embedded
	protected Contact contact;
}
