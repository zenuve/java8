package java8practice;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.junit.Assert.assertThat;

public class EmployeeTest {
	
	Collection<Employee> empList=CollectionUtils.emptyCollection();
	@Before
	public void setUp()
	{
		empList= Arrays.asList(
				new Employee(1, "Jeff Bezos", 100000.0), 
			    new Employee(2, "Bill Gates", 200000.0), 
			    new Employee(3, "Mark Zuckerberg", 300000.0)
		);
		
	}
	
	@Test
	public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {    
		empList.stream().forEach(e -> e.salaryIncrement(10000.0));
		empList.stream().forEach(e -> System.out.println(e.getSalary()));
	    
	}
	
	@Test
	public void whenMapIdToEmployees_thenGetEmployeeStream() {
	    Integer[] empIds= {1,2};
	    List<Employee> employees=Stream.of(empIds).map(employeeRepository::findById);
	    
	}
}
