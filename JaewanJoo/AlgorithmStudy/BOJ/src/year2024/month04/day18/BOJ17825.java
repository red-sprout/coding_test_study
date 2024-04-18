package year2024.month04.day18;

import java.io.*;
import java.util.*;

public class BOJ17825 {
	private static int maxScore = 0;
	private static int[] dice = new int[10];
	private static int[] order = new int[10];
	private static Node[] horses = new Node[4];
	private static Node start;
	
	static class Node {
		int score;
		boolean isEnd;
		boolean isExist;
		boolean isBlue;
		Node next;
		Node blueNext;
		
		Node(int score) {
			this.score = score;
			this.isExist = false;
		}
		
		Node add(int score) {
			Node next = new Node(score);
			this.next = next;
			return next;
		}
		
		static Node get(Node start, int score) {
			for(Node n = start; ; n = n.next) {
				if(n == null) return null;
				if(n.score == score) return n;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		init();
		test(0);
		System.out.println(maxScore);
		br.close();
	}
	
	public static void test(int depth) {
		if(depth >= 10) {
			maxScore = Math.max(maxScore, game());
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			order[depth] = i;
			test(depth + 1);
		}
	}
	
	public static int game() {
        int score = 0;
        Arrays.fill(horses, start);

        for(int i = 0; i < 10; i++){
        	Node now = horses[order[i]];
        	now.isExist = false;
            for(int j = 1; j <= dice[i]; j++) {
            	if(j == 1 && now.isBlue) {
            		now = now.blueNext;
            	} else {
            		now = now.next;
            	}
            }
            
            horses[order[i]] = now;
            
            if(now.isExist && !now.isEnd) {
            	score = 0;
            	break;
            } else {
            	now.isExist = true;
            	score += now.score;
            }
        }
        
        for(int i = 0; i < 4; i++) {
        	horses[i].isExist = false;
        }
        
        return score;
	}
	
	public static void init() {
		start = new Node(0);
		Node n = start;
		
		for(int i = 2; i <= 40; i += 2) {
			n = n.add(i);
		}
		
		Node end = n.add(0);
		end.isEnd = true;
		end.next = end;
		
		Node cross = new Node(25);
		
		n = cross.add(30);
		n = n.add(35);
		n.next = Node.get(start, 40);
		
		n = Node.get(start, 10);
		n.isBlue = true;
		n = n.blueNext = new Node(13);
		n = n.add(16);
		n = n.add(19);
		n.next = cross;
		
		n = Node.get(start, 20);
		n.isBlue = true;
		n = n.blueNext = new Node(22);
		n = n.add(24);
		n.next = cross;
		
		n = Node.get(start, 30);
		n.isBlue = true;
		n = n.blueNext = new Node(28);
		n = n.add(27);
		n = n.add(26);
		n.next = cross;
	}
}
