package com.bookManagementAPI.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

public class BookMgmtDemo {

	private List<Book> booksCatalog = new ArrayList<Book>();
	private HashMap<String, List<BookReservation>> reserveLogs = new HashMap<String, List<BookReservation>>();
	
	
	public static void main(String[] args) throws ParseException {
		// Sample Data
		
		BookMgmtDemo bm = new BookMgmtDemo();
		
		Book bk = new Book("1", "Database Management Systems", "Navathe");
		Book bk1 = new Book("2", "Database Management Systems", "Cindrella");
		Book bk2 = new Book("3", "Database Management Systems", "Shamkanth");
		Book bk3 = new Book("4", "Java", "Navathe");
		Book bk4 = new Book("5", "Java", "Schildt");
		Book bk5 = new Book("6", "SQL", "Navathe");
		Book bk6 = new Book("7", "SQL", "Oracle books");
		Book bk7 = new Book("8", "C++", "Dr. Ritchie");
		Book bk8 = new Book("9", "C++", "Schildt");
		Book bk9 = new Book("10", "Python", "Tech Dummies");
		
		bm.addBook(bk);
		bm.addBook(bk1);
		bm.addBook(bk2);
		bm.addBook(bk3);
		bm.addBook(bk4);
		bm.addBook(bk5);
		bm.addBook(bk6);
		bm.addBook(bk7);
		bm.addBook(bk8);
		bm.addBook(bk9);
		
		
		List<Book> bks = bm.retreiveBooks("Database Management Systems", "Navathe");
		System.out.println("Retrieving books for title Database Management Systems or Author name as Navathe");
		for(Book k: bks) {
			System.out.println(k);
		}
		//System.out.println(bks);
		
		System.out.println();
		String str = bm.reserveBooks(bk9, "2020-04-01", "2020-05-01");
		System.out.println(str);
		
		System.out.println();
		String str2 = bm.reserveBooks(bk9, "2020-04-03", "2020-05-01");
		System.out.println(str2);
		
		System.out.println();
		String str3 = bm.reserveBooks(bk9, "2020-09-27", "2020-09-28");
		System.out.println(str3);
		
		
		
		System.out.println();
		System.out.println("Total Books in the system: ");
		for(Book b: bm.booksCatalog) {
			System.out.println(b);
		}
		
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(23);
		lst.add(231);
		lst.add(12);
		lst.add(43);
		lst.add(123);
		
		ListIterator<Integer> lstIt = lst.listIterator();
		System.out.println("List Iterator");
		while(lstIt.hasNext())
			System.out.print(lstIt.next() + " ");
		
		
		
//		List<Integer> dup = lst.stream().filter(i -> Collections.frequency(lst, i) > 1).collect(Collectors.toList());
//		
//		System.out.println(dup);
		
		
		
		String st = "asdAdsfs";
		System.out.println(st.matches("^[a-zA-z]*$"));
		
		HashMap<Integer, Integer>hm = new HashMap<Integer, Integer>();
		hm.put(1223,1);
		hm.put(1224,2);
		hm.put(1226,3);
		hm.put(1227,4);
		
		Collection<Integer> values = hm.values();
		
		Integer[] val = values.toArray(new Integer[values.size()]);
		for(Integer i: val)
			System.out.print(i + " ");
		
		
		TrafficSignal[] signls = TrafficSignal.values();
		for(TrafficSignal sig: signls) {
			System.out.println("Name: " + sig.name() + " Action: " + sig.getAction());
		}
		
	}
	
	
	//adding book to the system
	public void addBook(Book bk) {
		booksCatalog.add(bk);
	}
	
	
	//looking books from the system
	public List<Book> retreiveBooks(String title, String author){
		List<Book> bkr = new ArrayList<Book>();
		
		if(title != null) {
			for(Book bk : booksCatalog) {
				if(bk.getTitle().equals(title)) {
					bkr.add(bk);
				}
			}
					
		}
		else if(author != null)  {
			for(Book bk : booksCatalog) {
				if(bk.getAuthor().equals(author)) {
					bkr.add(bk);
				}
			}
		}
		
		if(bkr.size() == 0)
			System.out.println("No book found in the catalog for author " + author + " and title " + title + ".");
		
		return bkr;
	}
	
	//reserving books
	public String reserveBooks(Book bk, String startDate, String endDate) throws ParseException {
		Date dt = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date st = sdf.parse(startDate);
		Date en = sdf.parse(endDate);
		
		System.out.println("Date1 : " + sdf.format(st)); 
        System.out.println("Date2 : " + sdf.format(en)); 
        System.out.println("Current Date: " + sdf.format(dt));
        
		String bkId = "";
		BookReservation recentReservation = new BookReservation();
		
		List<BookReservation> bkr = new ArrayList<BookReservation>();
			for(Map.Entry<String, List<BookReservation>> entry : reserveLogs.entrySet()) {
				bkId = entry.getKey();
				if(bk.getBookId().equals(bkId)) {
					bkr.addAll(entry.getValue());
				}
			}
			
			if(bkr.size() == 0 || reserveLogs.size() == 0)  {
				System.out.println("Book not in reserve shelf yet. Checking the given dates ..");
				recentReservation.setBookId(bk.getBookId());
				recentReservation.setEndDate(en);
				recentReservation.setStartDate(st);
				bkr.add(recentReservation);
				
				if(recentReservation.getStartDate().before(dt))
					return "Given date is past date. You cannot reserve book for past date";
				
				else if(st.after(dt) && en.after(dt) && st.equals(en) == false) {
				
				reserveLogs.put(bk.getBookId(), bkr);
				for(BookReservation br: reserveLogs.get(bk.getBookId())) {
					System.out.println("Book map details:- Book id: " + br.getBookId() 
					+ " Author: " + "Start Date " + sdf.format(br.getStartDate()) + " End Date: " + sdf.format(br.getEndDate()));
				}
					return "Book reserved successfully. Have a nice day!!";
				}
				
				
				
			}
			
			else {
				
				recentReservation = bkr.get(bkr.size() -1);
					if(recentReservation.getStartDate().equals(st) && recentReservation.getEndDate().equals(en))
						return "Book is already reserved during given time. Please come back some other time";
					
					else if(recentReservation.getStartDate().after(st) && recentReservation.getEndDate().before(en))
						return "Book is already reserved during given time. Please come back some other time";
					
					
					else if(st.after(recentReservation.getEndDate()) && en.after(dt) && st.equals(en) == false) {
						bkr.add(recentReservation);
						reserveLogs.put(bkId, bkr);
						return "Book reserved successfully. Have a nice day!!";
					}
				
			}
			
			return "Error reserving. Please verify the details";
			
		}
		
}
