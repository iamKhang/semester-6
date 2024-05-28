package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
@Inheritance(strategy = InheritanceType.JOINED)
public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -431106810969682264L;
	@Id
	protected String ISBN;
	protected String name;
	@Column(name = "publish_year")
	protected int publicYear;
	@Column(name = "num_of_pages")
	protected int numberOfPages;
	protected double price;
	
	@ElementCollection
    @CollectionTable(name = "books_authors", joinColumns = @JoinColumn(name = "ISBN"))
	@Column(name = "author", unique = true)
    protected Set<String> authors;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	protected Publisher publisher;
	
	@OneToMany(mappedBy = "book")
	protected Set<Reviews> reviews;

	public Book() {
		super();
	}

	public Book(String iSBN, String name, int publicYear, int numberOfPages, double price, Set<String> authors) {
		super();
		ISBN = iSBN;
		this.name = name;
		this.publicYear = publicYear;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.authors = authors;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPublicYear() {
		return publicYear;
	}

	public void setPublicYear(int publicYear) {
		this.publicYear = publicYear;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Reviews> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", name=" + name + ", publicYear=" + publicYear + ", numberOfPages="
				+ numberOfPages + ", price=" + price + ", authors=" + authors + "]";
	}
	
	
}
