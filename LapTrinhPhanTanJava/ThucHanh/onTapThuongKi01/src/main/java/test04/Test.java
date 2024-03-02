package test04;

import java.time.LocalDate;

public class Test {
	private LocalDate date;
	private String result;
	private int testId;
	private String testType;
	private int cost;

	public Test() {
		super();
	}

	public Test(LocalDate date, String result, int testId, String testType, int cost) {
		super();
		this.date = date;
		this.result = result;
		this.testId = testId;
		this.testType = testType;
		this.cost = cost;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Test [date=" + date + ", result=" + result + ", testId=" + testId + ", testType=" + testType + ", cost="
				+ cost + "]";
	}

}
