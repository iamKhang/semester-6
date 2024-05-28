package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posts")


@Getter
@Setter
public class Post {
	@Id
	@Column(name = "post_id")
	private String id;
	private String title;
	private String contents;
	private int likes;
	private int views;
	private int shares;
	
	@Embedded
	private Approval approval;
	
	@OneToMany(mappedBy = "post")
	List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "user_name")
	User user;
	
	
}
