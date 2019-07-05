package java8practice;

import java.util.stream.Stream;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee[] arrayOfEmps= {
				new Employee(1, "Jeff Bezos", 100000.0), 
			    new Employee(2, "Bill Gates", 200000.0), 
			    new Employee(3, "Mark Zuckerberg", 300000.0)
		};
		Stream.of(arrayOfEmps).filter(predicate);
	}
}
