package java8practice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), 
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), 
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), 
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), 
				new Dish("salmon", false, 450, Dish.Type.FISH));

		List<String> threeHighCaloricDishNames = menu.stream()
				.filter(d -> d.getCalories() > 300)
				.map(Dish::getName)
				.limit(3)
				.collect(Collectors.toList());
				

		List<String> names = menu.stream()
				.filter(d -> {
					System.out.println("filtering "+d.getName());
					return d.getCalories() > 300;
				})
				.map(d->{
					System.out.println("mapping "+d.getName());
					return d.getName();
				})
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println(names);
		menu.stream().forEach(System.out::println);
		
		List<Dish> vegetarianMenu=menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

		vegetarianMenu.forEach(System.out::println);
		
		List<Integer> numbers=Arrays.asList(1,2,1,3,3,2,4);
		numbers.stream().filter(i->i%2==0).distinct().forEach(System.out::println);
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3); 
		List<Integer> numbers2 = Arrays.asList(3, 4);
		
		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().filter(j->(i+j)%3==0).map(k->new int[] {i,k})).collect(Collectors.toList());
		System.out.println("*****pairs*****");
		pairs.forEach(i->System.out.println("("+i[0]+","+i[1]+")"));
		
		if(menu.stream().anyMatch(Dish::isVegetarian))
		{
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
		}
		
		boolean isHealthy=menu.stream().allMatch(a->a.getCalories()<1000);
		System.out.println("The food is healthy "+isHealthy);
		
		Optional<Dish> vegMenu=menu.stream().filter(Dish::isVegetarian).findAny();
		if(vegMenu.isPresent())
		{
			System.out.println(vegMenu.get().getName());
		}
		
		List<Dish> newmenu = new ArrayList<>();
		
		if(menu.stream().noneMatch(a->a.getCalories()>1000))
		{
			System.out.println("***************YEEEEE***************");
		}
		
		for(Dish dish:menu.subList(0, 20))
		{
			System.out.println(dish.getName());
		}
	}

}
