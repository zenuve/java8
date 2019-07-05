package java8practice;

import java8practice.FilterApples.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate{

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight().intValue()>150;
	}

}
