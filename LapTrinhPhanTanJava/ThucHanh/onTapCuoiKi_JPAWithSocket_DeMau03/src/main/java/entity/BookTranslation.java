package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_translations")
public class BookTranslation extends Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2538856988210143055L;
	@Column(name = "translate_name")
	private String translateName;
	private String language;
	public BookTranslation() {
		super();
	}
	public BookTranslation(String iSBN, String name, int publicYear, int numberOfPages, double price,
			Set<String> authors, String translateName, String language) {
		super(iSBN, name, publicYear, numberOfPages, price, authors);
		this.translateName = translateName;
		this.language = language;
	}
	public String getTranslateName() {
		return translateName;
	}
	public void setTranslateName(String translateName) {
		this.translateName = translateName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "BookTranslation [translateName=" + translateName + ", language=" + language + ", ISBN=" + ISBN
				+ ", name=" + name + ", publicYear=" + publicYear + ", numberOfPages=" + numberOfPages + ", price="
				+ price + ", authors=" + authors + "]";
	}
	
	
}
