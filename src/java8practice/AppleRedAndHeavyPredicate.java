package java8practice;

import java8practice.FilterApples.Apple;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
	public boolean test(Apple apple)
	{
		return "red".equals(apple.getColor()) && apple.getWeight().intValue()>150;
	}
}
