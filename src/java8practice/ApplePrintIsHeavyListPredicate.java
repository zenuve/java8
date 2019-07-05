package java8practice;

import java8practice.FilterApples.Apple;

public class ApplePrintIsHeavyListPredicate implements AppleToStringPredicate {

	@Override
	public String msgAftertest(Apple a) {
		String str="";
		if(a.getWeight()>150)
		{
			str="HEAVY";
		}
		else
		{
			str="LIGHT";
		}
		return a.getColor()+" colored apple is "+str;
	}

}
