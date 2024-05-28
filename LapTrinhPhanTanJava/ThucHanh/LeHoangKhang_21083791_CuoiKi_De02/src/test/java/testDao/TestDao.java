package testDao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.CandidateDao;
import dao.impl.CandidateDaoImpl;
import entity.Candidate;
import entity.Certificate;
import entity.Position;

class TestDao {
	
	static CandidateDao dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao = new CandidateDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}


	

	
	@Test
	void testListPositions() {
		List<Position> list = dao.listPositions("Software Engineer", 10000, 20000);
//		assertEquals(1, list.size());
	}

	@Test
	void testListCadidatesByCompanies() {
		Map<Candidate, Long> map = dao.listCadidatesByCompanies();
//		assertEquals(7, map.size());
	}

	@Test
	void testListCandidatesWithLongestWorking() {
		Map<Candidate, Position> map = dao.listCandidatesWithLongestWorking();
//		assertEquals(1, map.size());
		
		
	}

//	@Test
//    void testAddCandidate() {
//          Candidate candidate = new Candidate("C113", "Lê Hoàng Khang", 2003, "Nam", "iamhoangkhang@icloud.com", "0383741660", "Đẹp trai");
//          boolean result = dao.addCandidate(candidate);
//          assertTrue(result);
//	}
	
	@Test
	void testListYearsOfExperienceByPosition() {
		Map<Position, Integer> map = dao.listYearsOfExperienceByPosition("C101");
		map.forEach((k, v) -> {
			System.out.println(k + " - " + v);
		});
	}
	
	@Test
	void testListCadidatesAndCertificates() {
		Map<Candidate, Set<Certificate>> map = dao.listCadidatesAndCertificates();
		Set<Certificate> set = map.get(new Candidate("C101"));
		assertEquals(3, set.size());
	}

}
