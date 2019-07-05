package java8practice.predicate;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateInterfaceExample5 {
	public static void main(String[] args) 
    { 
        predicate_and(); 
    }
	public static Predicate<String> hasLengthOf10 = new Predicate<String>() { 
        @Override
        public boolean test(String t) 
        { 
            return t.length() > 10; 
        } 
    };
	public static void predicate_and() {
		Predicate<String> nonNullPredicate=Objects::nonNull;
		String nullString=null;
		boolean outcome=nonNullPredicate.and(hasLengthOf10).test(nullString);
		System.out.println(outcome);
		
		String lengthGTThan10="Welcome to the machine";
		boolean outcome2=nonNullPredicate
	}
}
