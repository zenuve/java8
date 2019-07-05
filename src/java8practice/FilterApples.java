package java8practice;

import java.util.ArrayList;
import java.util.List;

public class FilterApples {

	public static void main(String[] args) {
		FilterApples filterApples=new FilterApples();
		Apple apple1=new Apple();
		apple1.setColor("red");
		apple1.setWeight(160);
		Apple apple2=new Apple();
		apple2.setColor("green");
		apple2.setWeight(140);
		Apple apple3=new Apple();
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
	

	public static void prettyPrintApple(List<Apple> inventory,AppleToStringPredicate apple)
	{
		for(Apple appleI:inventory)
		{
			String output=apple.msgAftertest(appleI);
			System.out.println(output);
		}
	}
}
