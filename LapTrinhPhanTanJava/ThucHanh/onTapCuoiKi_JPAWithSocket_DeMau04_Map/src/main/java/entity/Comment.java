package entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@ManyToOne
	@JoinColumn(name = "user_name")
	private User user;
	@Id
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	private String contents;
	@Column(name = "comment_date")
	private LocalDateTime commentDate;
	private int likes;
}
