package java8practice;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating an empty TreeMap 
		
		Comparator<Integer> comp=(Integer i1,Integer i2)->i2.compareTo(i1); 
				SortedMap<Integer, String> 
					sotree_map = new TreeMap<Integer, String>(comp); 

				// Mapping string values to int keys 
				sotree_map.put(10, "Geeks"); 
				sotree_map.put(15, "4"); 
				sotree_map.put(20, "Geeks"); 
				sotree_map.put(25, "Welcomes"); 
				sotree_map.put(30, "You"); 

				// Displaying the TreeMap 
				System.out.println("Initial Mappings are: "
								+ sotree_map); 

				// Using values() to get the set view of values 
				System.out.println("The collection is: "
								+ sotree_map.values()); 
	}

}
