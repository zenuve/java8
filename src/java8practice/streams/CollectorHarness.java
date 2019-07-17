package java8practice.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CollectorHarness {
	public static void main(String[] args) {
		long fastest=Long.MAX_VALUE;
		for(int i=0;i<10;i++)
		{
			long start=System.nanoTime();
			partitionPrimes(1_000_000);
			//partitionPrimesWithCustomCollector(1_000_000);
			long duration=(System.nanoTime()-start)/1_000_000;
			if(duration<fastest) fastest=duration;
		}
		System.out.println("Fastest execution done in "+fastest+" msecs");
	}
	
	public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
		int i=0;
		for(A item:list)
		{
			if(!p.test(item)) {
				return list.subList(0, i);
			}
			i++;
		}
		return list;
	}
	
	public static Map<Boolean,List<Integer>> partitionPrimes(int n)
	{
		return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
	}
	
	public static boolean isPrime(List<Integer> primes,int candidate) {
		int candidateRoot=(int) Math.sqrt((double) candidate);
		return takeWhile(primes,i->i<=candidateRoot).stream().noneMatch(p->candidate%p==0);
	}
	
	public static Map<Boolean,List<Integer>> partitionPrimesWithCustomCollector(int n)
	{
		return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
	}
}
