package java8practice.traders;

import java.util.List;

public class Trader {
	private String name;
	private String city;
	
	List<Transactions> transactions;
	public List<Transactions> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	Trader(String name,String city)
	{
		this.name=name;
		this.city=city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}	
}
