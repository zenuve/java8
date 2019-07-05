package java8practice;

import java8practice.FilterApples.Apple;

public class ApplePrintWeightPredicate implements AppleToStringPredicate {

	@Override
	public String msgAftertest(Apple apple) {
		return "Weight of apple is:"+apple.getWeight();
	}

}
