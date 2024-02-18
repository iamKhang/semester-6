package practiceTest1st;

import java.time.LocalDate;

public class Grade {
	private LocalDate date;
	private String grade;
	private int score;

	public Grade() {
		super();
	}

	public Grade(LocalDate date, String grade, int score) {
		super();
		this.date = date;
		this.grade = grade;
		this.score = score;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Grade [date=" + date + ", grade=" + grade + ", score=" + score + "]";
	}

}
