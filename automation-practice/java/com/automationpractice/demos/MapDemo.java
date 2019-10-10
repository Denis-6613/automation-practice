package com.automationpractice.demos;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
		
		List <String> list = new ArrayList<String>();
		list.add("Mushfig");
		list.add("Ahmad");
		list.add("Taisiya");
		list.add("Jon Snow");
		
		
		Map <Integer, String> map = new HashMap<Integer,String>();
		
//		key --> Integer data type
//		value --> String data
		map.put(19, "Mushfig");
		map.put(12, "Ahmad");
		map.put(13, "Taisiya");
		map.put(20, "Jon Snow");
		
		for (Map.Entry<Integer, String> map1:map.entrySet()) 
			System.out.println(map1.getKey()+" - "+map1.getValue());
		
		System.out.println("========="+map.get(12));
		System.out.println("map size "+map.size());
		map.remove(12);//remove element by using key
		
		for (Map.Entry<Integer, String> map1:map.entrySet()) {
			System.out.println(map1.getKey()+" - "+map1.getValue());
		}
		System.out.println("map size "+map.size());
		/////////////////
		
		if (!map.isEmpty())
			for (Map.Entry<Integer, String> map1:map.entrySet()) 
				System.out.println("inside if "+map1.getKey()+" - "+map1.getValue());
		
		Set<Integer> keys = map.keySet();
		for (Integer key:keys)
			System.out.println(" key "+key);
		
		map.put(20, "Black Panther");
		for (Map.Entry<Integer, String> map1:map.entrySet()) {
			System.out.println(map1.getKey()+" - "+map1.getValue());
		}
		System.out.println("============");
//		map.put(1, "Ahmad");
		map.put(21, "Black Panther");
		for (Map.Entry<Integer, String> map1:map.entrySet()) {
			System.out.println(map1.getKey()+" - "+map1.getValue());
		}
		map=new TreeMap<Integer, String>(map);
		System.out.println("++++++++++++");
		for (Map.Entry<Integer, String> map1:map.entrySet()) {
			System.out.println(map1.getKey()+" - "+map1.getValue());
		}

	}

}
