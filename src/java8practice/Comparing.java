package java8practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Comparing {

	private static int count=0;
	public static void main(String[] args) {
		List<Integer> l1=Arrays.asList(5,2,4,1);
		Collections.sort(l1,new Comparator<Integer>() {
			@Override
			public int compare(Integer o2, Integer o1) {
				System.out.println("Integer 1="+o1);
				System.out.println("Integer 2="+o2);
				System.out.println("Compare To="+o2.compareTo(o1));
				System.out.println("======================"+(++count));
				return o2.compareTo(o1);
			}
		});
		System.out.println(l1);
	}

}
