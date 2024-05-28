package dao;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import entity.Position;

class CandidateDaoTest {
	
	static CandidateDao candidateDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		candidateDao = new CandidateDao();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		candidateDao = null;
	}

	
	@Test
	@Order(1)
	void testGetAll() {
		List<Position> positions = candidateDao.listPositions("Web Developer", 0, 20_000);
		positions.forEach(System.out::println);
	}
	
	@Test
	@Order(2)
	void testListCadidatesByCompanies() {
		candidateDao.listCadidatesByCompanies().forEach((k, v) -> System.out.println(k + " - " + v));
	}
	
	@Test
	@Order(3)
	void testListCandidatesWithLongestWorking() {
		candidateDao.listCandidatesWithLongestWorking().forEach((k, v) -> System.out.println(k + " - " + v));
	}
	
	@Test
	@Order(4)
	void listYearsOfExperienceByPosition() {
		candidateDao.listYearsOfExperienceByPosition("C114").forEach((k, v) -> System.out.println(k + " - " + v));
	}
	
	@Test
	@Order(5)
	void listCandidatesByPosition() {
		System.out.println("=================================================");
		candidateDao.listCadidatesAndCertificates().forEach((k, v) -> System.out.println(k + " - " + v));
		System.out.println("=================================================");
	}
	

}
