package com.example.hash;

class MyHashTable {
	class Node {
		String key;
		String value;
		Node next;
		
		Node(String key, String value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	Node[] head;
	
	MyHashTable(int size) {
		this.head = new Node[size];
	}
	
	int getIdx(String key) {
		return key.hashCode() % head.length;
	}
	
	void put(String key, String value) {
		int idx = getIdx(key);
		Node node = new Node(key, value);
		Node tmp = head[idx];
		
		if(tmp == null) {
			head[idx] = node;
			return;
		} 
		
		while(true) {
			if(tmp.next == null) {
				tmp.next = node;
				break;
			}
			tmp = tmp.next;
		}
	}
	
	String get(String key) {
		int idx = getIdx(key);
		for(Node n = head[idx]; n != null; n = n.next) {
			if(n.key.equals(key)) return n.value;
		}
		return null;
	}
}

public class MyHashTableRun {
	public static void main(String[] args) {
		MyHashTable h = new MyHashTable(4);
		h.put("Kim", "Minjae");
		h.put("Son", "Heungmin");
		h.put("Lee", "Sanghyeok");
		h.put("Joo", "Jaewan");
		System.out.println(h.get("Kim"));
		System.out.println(h.get("Son"));
		System.out.println(h.get("Lee"));
		System.out.println(h.get("Joo"));
	}
}
