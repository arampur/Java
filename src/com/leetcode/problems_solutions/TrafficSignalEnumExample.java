package com.leetcode.problems_solutions;

enum TrafficSignal {
	RED("STOP"), GREEN("GO"), ORANGE("WAIT");
	
	private String action;
	
	private TrafficSignal(String action) {
		// TODO Auto-generated constructor stub
		this.action = action;
	}

	public String getAction() {
		return action;
	}
	
}
public class TrafficSignalEnumExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrafficSignal[] signal = TrafficSignal.values();
		for(TrafficSignal sgnal: signal) {
			System.out.println("Name: " + sgnal.name() + " & Action: " + sgnal.getAction());
		}
	}

}
