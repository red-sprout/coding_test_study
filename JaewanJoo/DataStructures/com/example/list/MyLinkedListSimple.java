package com.example.list;

/*
 * 코딩 테스트 용으로 구성된 간단한 LinkedList
 * add(), remove(), get()으로 구성
 * 단일 연결 리스트로 구성
 * 데이터로 정수가 들어온다고 가정
 * 헤드를 추가적인 노드로 생성, 그 헤드 다음부터 인덱스 0로 시작
 */
class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	/**
	 * 전해준 노드 뒤에 데이터를 집어넣는 메소드
	 * @param prev 데이터를 집어넣는 곳 앞에 있는 노드
	 * @param data 데이터
	 */
	public static void add(Node prev, int data) {
		Node node = new Node(data);
		Node next = prev.next;
		
		prev.next = node;
		node.next = next;
	}
	
	/**
	 * 전달받은 값(데이터)에 해당하는 모든 노드 삭제
	 * @param head LinkedList의 처음
	 * @param data 데이터
	 */
	public static void remove(Node head, int data) {
		Node prev = null;
		for(Node n = head; n != null; n = n.next) {
			if(n.data == data) {
				Node next = n.next;
				prev.next = next;
			}
			prev = n;
		}
	}
	
	/**
	 * 해당 인덱스의 노드를 반환
	 * @param head LinkedList의 처음
	 * @param index 인덱스
	 * @return Node
	 */
	public static Node get(Node head, int index) {
		Node node = head.next;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
}

public class MyLinkedListSimple {
	public static void main(String[] args) {
		// 헤드, 0이라는 데이터는 dummy data (size == 0)
		Node head = new Node(0); 
		
		// add()
		Node.add(head, 1);
		System.out.println(list(head)); // 1
		
		Node.add(head, 2);
		System.out.println(list(head)); // 2 1
		
		Node last = Node.get(head, 1);
		Node.add(last, 2);
		System.out.println(list(head)); // 2 1 2
		
		Node node = Node.get(head, 0);
		Node.add(node, 3);
		System.out.println(list(head)); // 2 3 1 2
		
		// get()
		for(int i = 0; i < 4; i++) {
			System.out.print(Node.get(head, i).data);
			System.out.print("|");
		} 
		System.out.println(); // 2|3|1|2|
		
		// remove()
		Node.remove(head, 2);
		System.out.println(list(head)); // 3 1
		
		Node.remove(head, 3);
		System.out.println(list(head)); // 1
	}
	
	public static String list(Node head) {
		StringBuilder sb = new StringBuilder();
		for(Node n = head.next; n != null; n = n.next) { 
			sb.append(n.data).append(" ");
		}
		return sb.toString();
	}
}
