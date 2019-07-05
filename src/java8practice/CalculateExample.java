package java8practice;

public class CalculateExample {
	public static void main(String args[]) {
		System.out.println(calculate(6,5,"add"));
	}

	public static int calculate(int a, int b, String operator) {
	    int result = Integer.MIN_VALUE;
	 
		    switch (operator) {
			case "add":
				result = a + b;
				break;
			case "multiply":
				result=a*b;
				break;
			case "divide":
				result=a/b;
			case "substract":
				result=a-b;
			default:
				break;
		}
	    return result;
	}
}
