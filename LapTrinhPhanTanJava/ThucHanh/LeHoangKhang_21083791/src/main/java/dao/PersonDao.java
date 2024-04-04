package dao;

import java.util.List;

import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonDao {
	
	EntityManagerFactory emf;
    EntityManager em;
    
	public PersonDao(String persistenceUnitName) {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();
	}
	
	public boolean addPerson(Person person) {
		try {
	        em.getTransaction().begin();
	        em.persist(person);
	        em.getTransaction().commit();
	        return true;
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public Person getPerson(int id) {
        return em.find(Person.class, id);
    }
	
	
	public List<Person> getPersionList() {
		return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
	}
	
	public boolean deletePerson(int id) {
		try {
			em.getTransaction().begin();
			Person person = em.find(Person.class, id);
			em.remove(person);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updatePerson(Person person) {
		try {
			em.getTransaction().begin();
			em.merge(person);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		}
	}
	
	public int countPerson() {
		return em.createQuery("SELECT p FROM Person p", Person.class).getResultList().size();
	}
	
	public boolean deletePersonByLastName(String lastName) {
	    try {
	        em.getTransaction().begin();
	        List<Person> persons = em.createQuery("SELECT p FROM Person p WHERE p.lastName = :lastName", Person.class)
	                .setParameter("lastName", lastName).getResultList();
	        for (Person person : persons) {
	            em.remove(person);
	        }
	        em.getTransaction().commit();
	        return true;
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public void close() {
		em.close();
		emf.close();
	}
	
	
}
