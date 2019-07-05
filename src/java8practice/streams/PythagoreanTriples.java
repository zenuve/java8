package java8practice.streams;

import java.util.stream.Stream;
import java.util.stream.IntStream;

public class PythagoreanTriples {

	public static void main(String[] args) {
		Stream<int[]> pythagoreanTriples=IntStream.rangeClosed(1, 100).boxed().flatMap(a->IntStream.rangeClosed(a, 100).filter(b->Math.sqrt(a*a+b*b)%1==0).mapToObj(b->new int[] {a,b,(int)Math.sqrt(a*a+b*b)}));
		pythagoreanTriples.limit(10).forEach(a->System.out.println(a[0]+","+a[1]+","+a[2]));
	}

}
