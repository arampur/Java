package com.leetcode.problems_solutions;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBzzMultiThreaded {
	
	 private int n;
     private final AtomicInteger currentProcess = new AtomicInteger(1);
     private final Semaphore semaphore = new Semaphore(1);
    
    public FizzBzzMultiThreaded(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int fizzCount = n/3 - n/15;
        int step = 0;
        while (step < fizzCount){
            try {
                semaphore.acquire();
                if (currentProcess.get() % 3 == 0 && currentProcess.get() % 15 != 0) {
                    printFizz.run();
                    currentProcess.incrementAndGet();
                    step++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int buzzCount = n/5 - n/15;
        int step = 0;
        while (step < buzzCount) {
            try {
                semaphore.acquire();
                if (currentProcess.get() % 5 == 0 && currentProcess.get() % 15 != 0) {
                    printBuzz.run();
                    currentProcess.incrementAndGet();
                    step++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
       int fizzBuzzCount = n/15;
        int step = 0;
        while (step < fizzBuzzCount){
            try {
                semaphore.acquire();
                if (currentProcess.get() % 15 == 0) {
                    printFizzBuzz.run();
                    currentProcess.incrementAndGet();
                    step++;
                }
            } finally {
                semaphore.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        int numCount = n - n/3 - n/5 + n/15;
        int step = 0;
        while (step < numCount){
            try {
                semaphore.acquire();
                if (currentProcess.get() % 3 != 0 && currentProcess.get() % 5 != 0) {
                    printNumber.accept(currentProcess.get());
                    currentProcess.incrementAndGet();
                    step++;
                }
            } finally {
                semaphore.release();
            }
        }

    }
}
