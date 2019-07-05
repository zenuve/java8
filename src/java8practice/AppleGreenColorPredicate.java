package java8practice;

import java8practice.FilterApples.Apple;

public class AppleGreenColorPredicate implements ApplePredicate{

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}

}
