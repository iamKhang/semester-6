package dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import entity.Candidate;
import entity.Certificate;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CandidateDao {

	EntityManager em;

	public CandidateDao() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("onTapCuoiKi_JPAWithSocket_DeMau02_SQLServer");
		em = emf.createEntityManager();
	}

//	a) Liệt kê danh sách các vị trí công việc khi biết tên vị trí (tìm tương đối) và mức lương khoảng từ,
//	kết quả sắp xếp theo tên vị trí công việc.
//	+ listPositions(name: String, salaryFrom: double, salaryTo: double): List<Position>

	public List<Position> listPositions(String name, double salaryFrom, double salaryTo) {
		String query = "SELECT p " + "FROM Position p " + "WHERE p.name LIKE :name " + "AND p.salary >= :salaryFrom "
				+ "AND p.salary <= :salaryTo " + "ORDER BY p.name";
		return em.createQuery(query, Position.class).setParameter("name", "%" + name + "%")
				.setParameter("salaryFrom", salaryFrom).setParameter("salaryTo", salaryTo).getResultList();

	}
//	b) Liệt kê danh sách các ứng viên và số công ty mà các ứng viên này từng làm.
//	+ listCadidatesByCompanies() : Map<Candidate, Long>

	public Map<Candidate, Long> listCadidatesByCompanies() {
		String query = "SELECT c, COUNT(e.companyName) " + "FROM Candidate c " + "JOIN c.experiences e " + "GROUP BY c";
		List<Object[]> list = em.createQuery(query, Object[].class).getResultList();
		Map<Candidate, Long> map = new HashMap<>();
		for (Object[] objects : list) {
			map.put((Candidate) objects[0], (Long) objects[1]);
		}
		return map;
	}

//	c) Tìm danh sách các ứng viên đã làm việc trên một vị trí công việc nào đó có thời gian làm lâu nhất.
//	+ listCandidatesWithLongestWorking (): Map<Candidate, Position>

	public Map<Candidate, Position> listCandidatesWithLongestWorking() {
		// Khoảng thời gian làm lâu nhất là max(toDate - fromDate)
		String query = "SELECT e.candidate, e.position " + "FROM Experience e "
				+ "WHERE DATEDIFF(DAY, e.fromDate, e.toDate) = (SELECT MAX(DATEDIFF(DAY, e1.fromDate, e1.toDate)) FROM Experience e1)";
		List<Object[]> list = em.createQuery(query, Object[].class).getResultList();
		Map<Candidate, Position> map = new HashMap<>();
		for (Object[] objects : list) {
			map.put((Candidate) objects[0], (Position) objects[1]);
		}
		return map;
	}
//	d) Thêm một ứng viên mới. Trong đó mã số ứng viên phải bắt đầu là C, theo sau ít nhất là 3 ký số.
//	+ addCandidate(candidate: Candidate) : boolean

	public boolean addCandidate(Candidate candidate) {
		try {
			em.getTransaction().begin();
			em.persist(candidate);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}
//	e) Tính số năm làm việc trên một vị trí công việc nào đó khi biết mã số ứng viên.
//	+ listYearsOfExperienceByPosition(candidateID: String): Map<Position, Integer>

	public Map<Position, Integer> listYearsOfExperienceByPosition(String candidateID) {
		String query = "SELECT e.position, DATEDIFF(YEAR, e.fromDate, e.toDate) "
				+ "FROM Experience e "
				+ "WHERE e.candidate.id = :candidateID";
		List<Object[]> list = em.createQuery(query, Object[].class).setParameter("candidateID", candidateID)
				.getResultList();
		Map<Position, Integer> map = new HashMap<>();
		for (Object[] objects : list) {
			map.put((Position) objects[0], ((Long) objects[1]).intValue());
		}
		return map;
	}
//	f) Liệt kê danh sách các ứng viên và danh sách bằng cấp của từng ứng viên.
//	+ listCadidatesAndCertificates(): Map<Candidate, Set<Certificate >>

	public Map<Candidate, Set<Certificate>> listCadidatesAndCertificates() {
        List<Candidate> candidates = em.createQuery("SELECT c FROM Candidate c", Candidate.class).getResultList();
        Map<Candidate, Set<Certificate>> candidateCertificates = new HashMap<>();

        for (Candidate candidate : candidates) {
            candidateCertificates.put(candidate, new HashSet<>(candidate.getCertificates()));
        }

        return candidateCertificates;
    }

}
