package jpa_hibernate;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Testing {

	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("JPA_ORM_Student MSSQL");
	}

}
