package com.automationpractice.demos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionDemo {

	public static void main(String[] args) {
		
		ArrayList<String> myToDoList = new ArrayList();//List - interface, no "new" for List,
		myToDoList.add("do grocery");
		myToDoList.add("car wash");
		myToDoList.add("laundry");
		
				
//		System.out.println(myToDoList.get(0));
		
		for(String list:myToDoList) {
			System.out.println(list);
		}
		
		
		
		
		Set<String> setList = new HashSet<String>(); //(no duplicates, but no order)
		setList.add("set do grocery");
		setList.add("set car wash");
		setList.add("set laundry");
		
		for(String s:setList) {
			System.out.println(s);
		}
		
		System.out.println(setList);
		
		Iterator it=setList.iterator();
		System.out.println("iterator");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("loop");
		
		setList.forEach(data->{
			System.out.println(data);
		});
		
			
			
			
			


	}

}
