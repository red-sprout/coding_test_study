package com.example.list;

public class MyArrayListRun {
	public static void main(String[] args) {
		MyList<Integer> list = new MyArrayList<>();
		
		System.out.println(list); // []
		
		list.add(1);
		System.out.println(list); // [1]
		
		list.add(2); // Doubling! 1 -> 2
		System.out.println(list); // [1, 2]
		
		list.add(3); // Doubling! 2 -> 4
		System.out.println(list); // [1, 2, 3]
		System.out.println(list.indexOf(3)); // 2
		System.out.println(list.size()); // 3
		
		list.remove(1);
		System.out.println(list); // [1, 3]
		
		list.add(1, 4);
		list.add(1, 5);
		list.add(0, 6); // Doubling! 4 -> 8
		System.out.println(list); // [6, 1, 5, 4, 3]
		System.out.println(list.contains(7)); // false 
		
		list.set(1, 7);
		System.out.println(list); // [6, 7, 5, 4, 3]
		System.out.println(list.contains(7)); // true
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " "); // 6 7 5 4 3 
		}
		System.out.println();
	}
}
