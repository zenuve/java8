package java8practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FilterApplesLambda {

	public static void main(String[] args) {
		FilterApplesLambda filterApples=new FilterApplesLambda();
		Apple apple1=new Apple(filterApples);
		apple1.setColor("red");
		apple1.setWeight(190);
		Apple apple2=new Apple(filterApples);
		apple2.setColor("green");
		apple2.setWeight(140);
		Apple apple3=new Apple(filterApples);
		apple3.setColor("blue");
		apple3.setWeight(180);
		
		List<Apple> listApple=new ArrayList<Apple>();
		listApple.add(apple1);
		listApple.add(apple2);
		listApple.add(apple3);
		
		List<Apple> listAppleResult=filterGreenApples(listApple);
		System.out.println("Filtered green apples="+listAppleResult.get(0).getColor());
		
		List<Apple> redAndHeavyApples=filterApples(listApple, new AppleRedAndHeavyPredicate());
		System.out.println("Filtered redAndHeavy apples="+redAndHeavyApples.get(0).getColor());
		
		prettyPrintApple(listApple, new ApplePrintIsHeavyListPredicate());
		prettyPrintApple(listApple, new ApplePrintWeightPredicate());
		
		listAppleResult=filterGreenApplesOld(listApple);
		
		filterAppleByColor(listApple,"green");
		filterAppleByColor(listApple,"red");
		
		listAppleResult=filterApplesLambda(listApple, (Apple a)->a.getWeight()>150);
		
		listApple.sort(new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}			
		});
		System.out.println("NO LAMBDA:PRINTING SORTED BY WEIGHT IN ASC");
		listApple.forEach(a->System.out.println(a.getColor()));
		
		Comparator<Apple> cmp1=(o1,o2)->o2.getWeight().compareTo(o1.getWeight());
		listApple.sort(cmp1);
		
		System.out.println("LAMBDA:PRINTING SORTED BY WEIGHT IN DESC");
		listApple.forEach(a->System.out.println(a.getColor()+":"+a.getWeight()));
		
		Thread t=new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello thread 1");
			}
			
		});
		t.run();
		t=new Thread(()->System.out.println("Hello lambda thread 1"));
		t.run();
	}
	
	public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p)
	{
		List<Apple> result=new ArrayList<Apple>();
		for(Apple apple:inventory) {
			if(p.test(apple))
			{
				result.add(apple);
			}
		}
		return result;
	}
	
	public static <A> List<A> filterApplesLambda(List<A> inventory,Predicate<A> p)
	{
		List<A> result=new ArrayList<A>();
		for(A apple:inventory) {
			if(p.test(apple))
			{
				result.add(apple);
			}
		}
		return result;
	}
	
	public static List<Apple> filterGreenApples(List<Apple> inventory)
	{
		List<Apple> listApple=new ArrayList<Apple>();
		for(Apple apple:inventory)
		{
			if("green".equals(apple.getColor()))
			{
				listApple.add(apple);
			}
		}
		return listApple;
		
	}
	
	public static List<Apple> filterGreenApplesOld(List<Apple> inventory)
	{
		List<Apple> listApple=new ArrayList<Apple>();
		for(Apple apple:inventory)
		{
			if("green".equals(apple.getColor()))
			{
				listApple.add(apple);
			}
		}
		return listApple;	
	}
	
	public static List<Apple> filterAppleByColor(List<Apple> inventory,String color)
	{
		List<Apple> result=new ArrayList<Apple>();
		for(Apple apple:inventory)
		{
			if(apple.getColor().equals(color))
			{
				result.add(apple);
			}
		}
		
		return result;
	}
	
	public static List<Apple> filterAppleByWeight(List<Apple> inventory,int weight)
	{
		List<Apple> result=new ArrayList<Apple>();
		for(Apple apple:inventory)
		{
			if(apple.getWeight()>weight)
			{
				result.add(apple);
			}
		}
		
		return result;
	}
	
	public static void prettyPrintApple(List<Apple> inventory,AppleToStringPredicate apple)
	{
		for(Apple appleI:inventory)
		{
			String output=apple.msgAftertest(appleI);
			System.out.println(output);
		}
	}
}
