package com.leetcode.problems_solutions;

import java.util.*;

public class ParkingSystem {
    private static List<Integer> lst;
    public ParkingSystem(int big, int medium, int small) {
        lst = new ArrayList<Integer>();
        lst.add(big);
        lst.add(medium);
        lst.add(small);
    }
    
    public boolean addCar(int carType) {
        int val = 0;
        if(carType == 1){
            val = lst.get(0);
            if(val >= 1)
            {
            	val = val-1;
                lst.set(0, val);
                return true;
            }
        }
        else if(carType == 2){
            val = lst.get(1);
            if(val >= 1)
            {
            	val = val-1;
                lst.set(1, val);
                return true;
            }
        }
        else if(carType == 3)
        {
            val = lst.get(2);
            if(val >= 1)
            {
            	val = val-1;
                lst.set(2, val);
                return true;
            }
        }
        return false;
    }
    
    
    public static void main(String[] args) {
    	ParkingSystem pc = new ParkingSystem(1, 1, 0);
    	pc.addCar(1);
    	pc.addCar(2);
    	pc.addCar(3);
    	pc.addCar(1);
    }
}