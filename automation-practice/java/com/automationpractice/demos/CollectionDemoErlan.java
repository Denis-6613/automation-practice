package com.automationpractice.demos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionDemoErlan {

	public static void main(String[] args) {
		
		List<String> myToDoList = new ArrayList();//List - interface, no "new" for List,
		myToDoList.add("do grocery");
		myToDoList.add("car wash");
		myToDoList.add("laundry");
		myToDoList.add("laundry");
		
				
//		System.out.println(myToDoList.get(0));
		
		for(String list:myToDoList) {
			System.out.println(list);
		}
		
		
		
		
		Set<String> setList = new HashSet<String>(); //(no duplicates, but no order)
		setList.add("handle1");
		setList.add("handle2");
		setList.add("handle3");
		setList.add("handle3");
		
		for(String s:setList) {
			System.out.println(s);
		}
		
//		System.out.println(setList);
//		
//		Iterator it=setList.iterator();
//		System.out.println("iterator");
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		System.out.println("loop");
//		
//		setList.forEach(data->{
//			System.out.println(data);
//		});
		
			
			
			
			


	}

}
