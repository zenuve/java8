package java8practice.traders;

public class Transactions {
	private int year;
	private Double value;
	public Transactions(int year,Double value) {
		this.year=year;
		this.value=value;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
}
