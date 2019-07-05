package java8practice.traders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {
		Trader trader1=new Trader("John","Cambridge");
		Trader trader2=new Trader("Cena","Cambridge");
		Trader trader3=new Trader("Rambo","Milan");
		Trader trader4=new Trader("Wick","York");
		Trader trader5=new Trader("Will","LA");
		
		Transactions tr1=new Transactions(2010, 100.00);
		Transactions tr2=new Transactions(2011, 105.00);
		Transactions tr3=new Transactions(2011, 120.00);
		Transactions tr4=new Transactions(2011, 420.00);
		Transactions tr5=new Transactions(2011, 40.00);
		Transactions tr6=new Transactions(2011, 43.00);
		Transactions tr7=new Transactions(2012, 440.00);
		
		List<Transactions> trader1Trns=new ArrayList<>();
		trader1Trns.add(tr1);
		trader1Trns.add(tr2);
		trader1Trns.add(tr3);
		trader1Trns.add(tr4);
		
		List<Transactions> trader2Trns=new ArrayList<>();
		trader2Trns.add(tr1);
		trader2Trns.add(tr2);
		trader2Trns.add(tr5);
		trader2Trns.add(tr6);
		
		List<Transactions> trader3Trns=new ArrayList<>();
		trader3Trns.add(tr3);
		trader3Trns.add(tr2);
		trader3Trns.add(tr7);
		trader3Trns.add(tr6);
		
		List<Transactions> trader4Trns=new ArrayList<>();
		trader4Trns.add(tr3);
		trader4Trns.add(tr5);
		trader4Trns.add(tr7);
		trader4Trns.add(tr1);
		
		List<Transactions> trader5Trns=new ArrayList<>();
		trader5Trns.add(tr6);
		trader5Trns.add(tr5);
		trader5Trns.add(tr7);
		trader5Trns.add(tr4);
		
		trader1.setTransactions(trader1Trns);
		trader2.setTransactions(trader2Trns);
		trader3.setTransactions(trader3Trns);
		trader4.setTransactions(trader4Trns);
		trader5.setTransactions(trader5Trns);
		
		List<Trader> tradersList=Arrays.asList(trader1,trader2,trader3,trader4,trader5);
		List<Transactions> transactionsList=Arrays.asList(tr1,tr2,tr3,tr4,tr5,tr6,tr7);
		
		System.out.println("1. Find all transactions in the year 2011 and sort them by value (small to high)");
		Comparator<Transactions> cmp=(Transactions a1,Transactions a2)->a1.getValue().compareTo(a2.getValue());
		transactionsList.stream().filter(a->a.getYear()==2011).sorted(cmp).forEach(a->System.out.println(a.getYear()+" "+a.getValue()));
		
		System.out.println("\n");
		System.out.println("2. What are all the unique cities where the traders work?");
		tradersList.stream().map(m->m.getCity()).distinct().forEach(System.out::println);
		
		System.out.println("\n");
		System.out.println("3. Find all traders from Cambridge and sort them by name");
		tradersList.stream().filter(p->p.getCity().equals("Cambridge")).sorted((Trader t1,Trader t2)->t1.getName().compareTo(t2.getName())).forEach(a->System.out.println(a.getName()));
		
		System.out.println("\n");
		System.out.println("4.  Return a string of all traders’ names sorted alphabetically");
		tradersList.stream().sorted((Trader t1,Trader t2)->t1.getName().compareTo(t2.getName())).forEach(a->System.out.println(a.getName()));
		
		System.out.println("\n");
		System.out.println("5.  Are any traders based in Milan?");
		if(tradersList.stream().anyMatch(a->a.getCity().equals("Milan")))
		{
			System.out.println("Yes");
		}
		
		System.out.println("\n");
		System.out.println("6.  Print all transactions’ values from the traders living in Cambridge");
		tradersList.stream().filter(a->a.getCity().equals("Cambridge")).map(a->a.getTransactions()).collect(Collectors.toList()).forEach(a->a.forEach(b->System.out.println(b.getValue())));
		
		System.out.println("\n");
		System.out.println("7.  What’s the highest value of all the transactions");
		System.out.println(transactionsList.stream().map(a->a.getValue()).reduce(Double::max).get());
		
		System.out.println("\n");
		System.out.println("8.  Find the transaction with the smallest value");
		transactionsList.stream().filter(e->e.getValue().equals(transactionsList.stream().map(a->a.getValue()).reduce(Double::min).get())).forEach(a->System.out.println(a.getValue()+" "+a.getYear()));
	}

}
