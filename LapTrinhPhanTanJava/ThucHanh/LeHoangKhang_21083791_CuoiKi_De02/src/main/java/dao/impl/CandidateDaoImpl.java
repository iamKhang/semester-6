package dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.CandidateDao;
import entity.Candidate;
import entity.Certificate;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CandidateDaoImpl implements CandidateDao {

	private EntityManager em;

	public CandidateDaoImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeHoangKhang_21083791_CuoiKi_De02");
		em = emf.createEntityManager();
	}

	@Override
	/**
	 * Liệt kê danh sách các vị trí công việc khi biết tên vị trí (tìm tương đối) và
	 * mức lương khoảng từ, kết quả sắp xếp theo tên vị trí công việc.
	 */
	public List<Position> listPositions(String name, double salaryFrom, double salaryTo) {
		String query = "SELECT p FROM Position p "
				+ "WHERE p.name LIKE :name AND p.salary >= :salaryFrom AND p.salary <= :salaryTo";
		return em.createQuery(query, Position.class).setParameter("name", "%" + name + "%")
				.setParameter("salaryFrom", salaryFrom).setParameter("salaryTo", salaryTo).getResultList();
	}

	@Override
	/**
	 * Liệt kê danh sách các ứng viên và số công ty mà các ứng viên này từng làm.
	 */
	public Map<Candidate, Long> listCadidatesByCompanies() {
		String query = "SELECT c, COUNT(DISTINCT e.companyName) " + "FROM Candidate c JOIN c.experiences e "
				+ "GROUP BY c";
		List<Object[]> list = em.createQuery(query, Object[].class).getResultList();
		Map<Candidate, Long> map = new HashMap<>();
		for (Object[] objects : list) {
			map.put((Candidate) objects[0], (Long) objects[1]);
		}
		return map;
	}

	@Override
	/**
	 * Tìm danh sách các ứng viên đã làm việc trên một vị trí công việc nào đó có
	 * thời gian làm lâu nhất
	 */
	public Map<Candidate, Position> listCandidatesWithLongestWorking() {
		// Khoảng thời gian làm lâu nhất là max(toDate - fromDate)
		String query = "SELECT e.candidate, e.position " + "FROM Experience e "
				+ "WHERE DATEDIFF(DAY, e.fromDate, e.toDate) "
				+ "= (SELECT MAX(DATEDIFF(DAY, e1.fromDate, e1.toDate)) FROM Experience e1 WHERE e.candidate)";
		List<Object[]> list = em.createQuery(query, Object[].class).getResultList();
		Map<Candidate, Position> map = new HashMap<>();
		for (Object[] objects : list) {
			map.put((Candidate) objects[0], (Position) objects[1]);
		}
		return map;
	}

	@Override
	/**
	 * Thêm một ứng viên mới. Trong đó mã số ứng viên phải bắt đầu là C, theo sau ít
	 * nhất là 3 ký số
	 */
	public boolean addCandidate(Candidate candidate) {
		if (candidate.getId().matches("C\\d{3,}")) {
			try {
				em.getTransaction().begin();
				em.persist(candidate);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	@Override
	/**
	 * Tính số năm làm việc trên một vị trí công việc nào đó khi biết mã số ứng viên
	 */
	public Map<Position, Integer> listYearsOfExperienceByPosition(String candidateID) {
//		Candidate -> Experience -> Position
//		Số năm làm việc = to_date - from_date của mỗi experience
		String query = "SELECT e.position, DATEDIFF(YEAR, e.fromDate, e.toDate) " + "FROM Experience e "
				+ "WHERE e.candidate.id = :candidateID";
		List<Object[]> list = em.createQuery(query, Object[].class).setParameter("candidateID", candidateID)
				.getResultList();
		Map<Position, Integer> map = new HashMap<>();
		for (Object[] objects : list) {
			map.put((Position) objects[0], ((Long) objects[1]).intValue());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Liệt kê danh sách các ứng viên và danh sách bằng cấp của từng ứng viên
	 */
	public Map<Candidate, Set<Certificate>> listCadidatesAndCertificates() {
		String query = "SELECT c " + "FROM Candidate c";
		List<Object[]> list = em.createQuery(query, Object[].class).getResultList();
		Map<Candidate, Set<Certificate>> map = new HashMap<>();
		for (Object[] objects : list) {
			Candidate candidate = (Candidate) objects[0];
			Set<Certificate> certificates = new HashSet<>();
			for (Certificate certificate : (Collection<Certificate>) candidate.getCertificates()) {
				certificates.add(certificate);
			}
			map.put(candidate, certificates);
		}
		return map;
	}

}
