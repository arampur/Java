package com.braintree_assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


class CreditDebitDtl {
	
	private String transType;
	private String cardHolderName;
	private String carNum;
	private String balance;
	private String limit;
	
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	
	public CreditDebitDtl(String transType, String cardHolderName, String carNum, String balance) {
		super();
		this.transType = transType;
		this.cardHolderName = cardHolderName;
		this.carNum = carNum;
		this.balance = balance;
	}
	
	public CreditDebitDtl() {
		
	}
}



public class MainProgram{
	
	private static TreeMap<String, List<CreditDebitDtl>> transMap = 
			new TreeMap<String,List<CreditDebitDtl>>(); //to keep of the transactions for each account
	
	public static int totalSum(int[] arr) {
		return Arrays.stream(arr).sum();
	}

	//Transaction Type - Add
	public static void Add(String transType, String name, String cardNum, String limit) {
		List<CreditDebitDtl> accntDtl = new ArrayList<CreditDebitDtl>();
		CreditDebitDtl cdb = new CreditDebitDtl();
		cdb.setBalance("0"); //Initially the card balance is 0 when its added for first time
		cdb.setLimit(limit);
		cdb.setCardHolderName(name);
		cdb.setCarNum(cardNum);
		cdb.setTransType(transType);
		
		accntDtl.add(cdb);
		transMap.put(name, accntDtl);
		
	}

	
	public static void Charge(String name, String balanceAmount) {
		List<CreditDebitDtl> dbl = transMap.get(name);
		
		if(!transMap.containsKey(name))
			return;
		
		if(transMap.containsKey(name) && dbl.get(0).getBalance() != "error") {
		for(CreditDebitDtl d: dbl) {
			if(Integer.valueOf(balanceAmount) > Integer.valueOf(d.getLimit()))
				continue;
			
			else {
				Integer oldBal = Integer.valueOf(d.getBalance());
				Integer newBal = Integer.valueOf(balanceAmount);
				
				if((oldBal + newBal) <= Integer.valueOf(d.getLimit()))
					d.setBalance(String.valueOf(oldBal + newBal));
			}
		}
		}
		
	}

	//Transaction Type - Credit
	public static void Credit(String name, String Amount) {
		if(!transMap.containsKey(name))
			return;
		
		List<CreditDebitDtl> dbl = transMap.get(name);
		
		if(transMap.containsKey(name) && dbl.get(0).getBalance() != "error") {
		for(CreditDebitDtl d: dbl) {
			Integer oldBal = Integer.valueOf(d.getBalance());
			Integer amntToCredit = Integer.valueOf(Amount);
			
			Integer newBal = oldBal - amntToCredit;
			
			d.setBalance(String.valueOf(newBal));
		}
		
		}
		//return "success";
		
	}
	
	
	//Function to validate the credit card Number -- luhn's Algorithm
		public static boolean creditCardValidate(String creditCardNumber) {
			
			int[] ints = new int[creditCardNumber.length()];
			for (int i = 0; i < creditCardNumber.length(); i++) {
				ints[i] = Integer.parseInt(creditCardNumber.substring(i, i + 1));
			}
			for (int i = ints.length - 2; i >= 0; i = i - 2) {
				int j = ints[i];
				j = j * 2;
				if (j > 9) {
					j = j % 10 + 1;
				}
				ints[i] = j;
			}
			int sum = 0;
			for (int i = 0; i < ints.length; i++) {
				sum += ints[i];
			}
			
			if (sum % 10 == 0) {
				return true;
			}  
			else {
				return false;
			}
	}
		
		
		public static void main(String[] args) throws IOException {
			
			//Comment the below lines of code to compile the program in an IDE and if you do not wish to send Arguments
			//through the command line
			
//			File inFile = null;
//			
//			if (0 < args.length) {
//			   inFile = new File(args[0]);
//			} else {
//			   System.err.println("Invalid arguments count: " + args.length);
//			   System.exit(0);
//			}
			
			
			File inFile = new File("/Users/amithrampur/git/Java/src/com/braintree_assignment/input.txt");
			
			BufferedReader reader = null;
			
			try {
			
			String currLine;
			
			reader = new BufferedReader(new FileReader(inFile));
			
				while((currLine = reader.readLine()) != null) {
					//System.out.println(currLine);
					String[] curLineInfo = currLine.split(" ");
					String limit = "";
					String accHolderName = "";
					String creditNum = "";
					String amount = "";
					String transType = "";
					
					transType = curLineInfo[0];
					
					if(transType.equals("Add")) {
						accHolderName = curLineInfo[1];
						creditNum = curLineInfo[2];
						limit = curLineInfo[3];
						limit = limit.substring(1,limit.length()); //to ignore $ sign from the input
						
						if(creditCardValidate(creditNum)) {
							
							Add(transType, accHolderName, creditNum, limit);
						}
						else {
							//System.out.println("Not a valid Credit Card number");
							//Error account - Any transaction done on this will be an error
							List<CreditDebitDtl> d = new ArrayList<CreditDebitDtl>();
							CreditDebitDtl cd = new CreditDebitDtl();
							cd.setBalance("error");
							d.add(cd);
							transMap.put(accHolderName, d);
						}
					}
					
					else if(transType.equals("Charge")) {
						accHolderName = curLineInfo[1];
						amount = curLineInfo[2];
						amount = amount.substring(1, amount.length()); //to ignore $ sign from the input
						Charge(accHolderName, amount);
					}
					
					else if(transType.equals("Credit")) {
						accHolderName = curLineInfo[1];
						amount = curLineInfo[2];
						amount = amount.substring(1, amount.length());
						Credit(accHolderName, amount);
					}
					
				}
			}
			
			finally {
				try {
					if(reader != null)
						reader.close(); //closing the reader after reading all the input data
				}
				catch(IOException ex) {
					ex.printStackTrace(); //Exception if encountered issue in reading/closing the file
				}
			}
			
			//Displaying the Summary information by iterating the map
			for(Map.Entry<String, List<CreditDebitDtl>> entry : transMap.entrySet()) {
				String k = entry.getKey();
				List<CreditDebitDtl> cd = entry.getValue();
				for(CreditDebitDtl c : cd) {
					if(c.getBalance() != "error")
					System.out.println(k + ": $" + c.getBalance());
					else
					System.out.println(k + ": " + c.getBalance());
				}
				
			}

		}
		
		public static void display() {
			for(Map.Entry<String, List<CreditDebitDtl>> entry : transMap.entrySet()) {
				String k = entry.getKey();
				List<CreditDebitDtl> cd = entry.getValue();
				for(CreditDebitDtl c : cd) {
					if(c.getBalance() != "error")
					System.out.println(k + ": $" + c.getBalance());
					else
					System.out.println(k + ": " + c.getBalance());
				}
				
			}
		}

}
