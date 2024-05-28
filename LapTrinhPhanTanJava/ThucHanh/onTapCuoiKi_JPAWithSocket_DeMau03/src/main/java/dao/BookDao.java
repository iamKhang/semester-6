package dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import entity.Book;
import entity.Person;
import entity.Reviews;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class BookDao {
	EntityManager em;
	
	public BookDao() {
		EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("onTapCuoiKi_JPAWithSocket_DeMau03_SQLServer");
		em =emf.createEntityManager();
	}
	
//	a) (1.5 điểm) Liệt kê danh sách các cuốn sách được viết bởi tác giả nào đó khi biết tên tác giả và
//	có điểm đánh giá từ mấy sao trở lên.
//	+ listRatedBooks(author: String, rating: int): List<Book>
	
    public List<Book> listRatedBooks(String author, int rating) {
        String jpql = "SELECT b "
        		+ "FROM Book b JOIN b.authors a JOIN b.reviews r "
        		+ "WHERE a = :author AND r.rating >= :rating";
        TypedQuery<Book> query = em.createQuery(jpql, Book.class);
        query.setParameter("author", author);
        query.setParameter("rating", rating);
        return query.getResultList();
    }
    
//    b) (1.5 điểm) Thống kê số cuốn sách được dịch sang ngôn ngữ khác của từng tác giả, kết quả sắp
//    xếp theo tên tác giả.
//    + countBooksByAuthor(): Map<String, Long>
    
	public Map<String, Long> countBooksByAuthor() {
		String jpql = "SELECT a, COUNT(b) FROM BookTranslation b JOIN b.authors a GROUP BY a ORDER BY a";
		
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		List<Object[]> list = query.getResultList();
		Map<String, Long> map = list.stream().collect(Collectors.toMap(arr -> (String) arr[0], arr -> (Long) arr[1]));
		return map;
	}
	
	
//	c) (1.5 điểm) Cập nhật thêm một lượt đánh giá cho một cuốn sách, cập nhật thành công nếu cuốn
//	sách và người đọc đã tồn tại, rating phải từ 1 đến 5 và bình luận không được để trống hay rỗng.
//	+ updateReviews(isbn: String, readerID: String, rating: int, comment: String): boolen

	public boolean updateReviews(String isbn, String readerID, int rating, String comment) {
		if (rating < 1 || rating > 5)
			return false;
		if (comment == null || comment.trim().isEmpty())
			return false;
		Book book = em.find(Book.class, isbn);
		Person person = em.find(Person.class, readerID);
	
		if (person == null || book == null)
			return false;
		
		Reviews reviews = new Reviews(rating, comment);
		reviews.setBook(book);
		reviews.setPerson(person);
		em.getTransaction().begin();
		em.persist(reviews);
		em.getTransaction().commit();		
		return true;
	}
}
