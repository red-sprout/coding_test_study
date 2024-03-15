package com.example.list;

public class MyLinkedListRun {
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		
		// toString 체크
		list.add("first");
		System.out.println(list.toString()); // [first]
		
		list.add("second");
		System.out.println(list.toString()); // [first, second]
		
		// index 인자가 있는 add 체크
		list.add(0, "head");
		list.add(4, "tail");
		list.add(2, "new Second");
		System.out.println(list); // [head, first, new Second, second, tail]
		
		// contains 체크
		System.out.println(list.contains("second")); // true
		System.out.println(list.contains("third")); // false
		
		// get 체크
		System.out.println(list.get(2)); // new Second
		
		// remove 체크
		list.remove(4);
		list.remove(0);
		list.remove(1);
		System.out.println(list.toString()); // [first, second]
		
		// set 체크
		list.set(0, "zero");
		System.out.println(list.toString()); // [zero, second]
		
		// size 체크
		System.out.println(list.size()); // 2
	}
}