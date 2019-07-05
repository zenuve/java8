package java8practice.predicate;

import java.util.function.Predicate;

public class PredicateInterfaceExample4 {

	public static void main(String[] args) {
		pred_or();
	}
	
	static void pred_or()
	{
		Predicate<String> containsLetterA=p->p.contains("A");
		String conatinsA="AND";
		//boolean outcome=hasLengthOf10.or(containsLetterA).test(conatinsA);
		boolean outcome=containsLetterA.or(hasLengthOf10).test(conatinsA);
		System.out.println(outcome);
	}
	
	public static Predicate<String> hasLengthOf10 = new Predicate<String>() { 
        @Override
        public boolean test(String t) 
        { 
            return t.length() > 10; 
        } 
    };

}
