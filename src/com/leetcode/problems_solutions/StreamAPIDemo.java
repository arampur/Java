package com.leetcode.problems_solutions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
	}
	
}
