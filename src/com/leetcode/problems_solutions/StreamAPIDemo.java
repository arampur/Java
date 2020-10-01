package com.leetcode.problems_solutions;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamAPIDemo {

	//Program to demonstrate the STREAM API JAVA 9=8
	
	public static void main(String[] args) {
		List<Order> orderList = new ArrayList<Order>();
		
		Order buyGoogle = new Order("GOOG.NS", 300, 900.30, Order.Side.BUY); 
		Order sellGoogle = new Order("GOOGL.NS", 600, 890.30, Order.Side.SELL); 
		Order sellApple = new Order("APPL.NS", 200, 550, Order.Side.SELL); 
		Order buyGS = new Order("GS.NS", 300, 130, Order.Side.BUY);

		orderList.add(buyGoogle);
		orderList.add(sellGoogle);
		//orderList.add(buyGoogle);
		//orderList.add(buyGoogle);
		orderList.add(sellApple);
		//orderList.add(sellApple);
		orderList.add(buyGS);
		
		//stream demo
		//filter by buy/sell
		Stream<Order> stream = orderList.stream();
		
		Stream buyOrders = stream.filter((Order o) -> o.getSide().equals(Order.Side.BUY));
		System.out.println("Total buy orders: " + buyOrders.count());
		
		Stream sellOrders = orderList.stream().filter((Order o) -> o.getSide().equals(Order.Side.SELL));
		System.out.println("Total Sell orders: " +  sellOrders.count());
		
		Long value = orderList.stream().mapToLong((Order o) -> o.getQuantity()).sum();
		System.out.println("Total qty :" + value);
		
		double totlPrice = orderList.stream().mapToDouble((Order o) -> o.getPrice()).sum();
		System.out.println("Total Price: " + totlPrice);
		
		
		Map<Object, Order> resl = new LinkedHashMap<>();
		
		resl = orderList.stream()
				.collect(Collectors.toMap(Order:: getSymbol, o -> o));
		
		for(Map.Entry<Object, Order> entry: resl.entrySet()){
			Object e = entry.getKey();
			Order v = entry.getValue();
			
			System.out.println("Key: " + e + " Values: " + v.toString());
		}
		
		//Today's date
		System.out.println("LocalDate " + LocalDate.now());
		int year = LocalDate.now().getYear();
		int month = LocalDate.now().getMonthValue();
		int day = LocalDate.now().getDayOfMonth();
		
		System.out.println("Current Year: " + year + " Current Month: " + month + " & Day: " + day);
		
		LocalDate today = LocalDate.now();
		LocalDate nexWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println(nexWeek);
		
		List<Integer> numbers = Arrays.asList(9,3,4,6,8,9,3,4,5);
		List<Integer> finalList = numbers.stream().map(i -> i* i).distinct()
				.collect(Collectors.toList());
		System.out.println("List contents with squared and distinct --> " + finalList);
		
		//Summary statistics fo find the statistical data comparison in streams
		IntSummaryStatistics statsStream = numbers.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Max element: " + statsStream.getMax());
		System.out.println("Min element: " +  statsStream.getMin());
		System.out.println("Avg element: " + Math.ceil(statsStream.getAverage()));
		System.out.println("Total Sum : " + statsStream.getSum());
		System.out.println("Total Elements: " + statsStream.getCount());
		
		List<String> languages = Arrays.asList("java","Scala","C++","Lisp","VB","Python");
		String lJs = languages.stream().filter(x -> x.startsWith("j")).findAny().get();
		System.out.println(lJs);
		
		System.out.println("Languages ending with a: ");
		languages.stream().filter(s->s.endsWith("a")).forEach(s -> {
			System.out.println(s + " ");
		});
		
		System.out.println();
		
		System.out.println("Another way of printing: ");
		languages.stream().filter(s->s.endsWith("a")).forEach(System.out::println);
		
		
		Stream<Integer> strm = Stream.of(1,2,3,4,5,5,6,7,9,10);
		//strm.forEach(p -> System.out.print(p + " "));
		
		List<Integer> lst = strm.collect(Collectors.toList());
		System.out.println(lst);
		
		
		//String tokenizer demo
		StringTokenizer stoken = new StringTokenizer("anbcd asfdsdf weer 34345 egerg", " ");
		while(stoken.hasMoreTokens()) {
			System.out.print(stoken.nextToken() + " ");
		}
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(12, 34);
		hm.put(11, 344);
		hm.put(14, 354);
		hm.put(10, 2);
		
		System.out.println("HashMap values to Arrays");
		Collection<Integer> values = hm.values();
		Integer[] valArr = values.toArray(new Integer[values.size()]);
		for(Integer v: valArr)
			System.out.println(v);
		
		System.out.println("HashMap Keys to Arrays");
		Collection<Integer> hmKeys = hm.keySet();
		Integer[] valKeys = hmKeys.toArray(new Integer[hmKeys.size()]);
		for(Integer i: valKeys)
			System.out.println(i);
		
	}
	
}
