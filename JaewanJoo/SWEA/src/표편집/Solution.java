package 표편집;

import java.util.*;

class Solution {
	int idx;
	Node[] nodeList;
	Deque<Integer> stack;
	
	class Node {
		int idx;
		Node prev;
		Node next;
		boolean isExist;
		
		Node(int idx) {
			this.idx = idx;
			this.isExist = true;
		}
	}
	
    public String solution(int n, int k, String[] cmd) {
    	init(n, k);
    	StringTokenizer st = null;
    	for(int i = 0; i < cmd.length; i++) {
    		st = new StringTokenizer(cmd[i], " ");
    		char c = st.nextToken().charAt(0);
    		switch(c) {
    		case 'U':
    			up(Integer.parseInt(st.nextToken()));
    			break;
    		case 'D':
    			down(Integer.parseInt(st.nextToken()));
    			break;
    		case 'C':
    			delete();
    			break;
    		case 'Z':
    			revert();
    			break;
    		}
    	}
    	return check();
    }
    
    public void init(int n, int k) {
    	idx = k;
    	nodeList = new Node[n];
    	stack = new ArrayDeque<>();
    	for(int i = 0; i < n; i++) {
    		nodeList[i] = new Node(i);
    	}
    	
    	nodeList[0].next = nodeList[1];
    	
    	Node node = nodeList[1];
    	for(int i = 1; i < n - 1; i++) {
    		node.prev = nodeList[i - 1];
    		node.next = nodeList[i + 1];
    		node = node.next;
    	}
    	
    	node.prev = nodeList[n - 2];
    }
    
    public void up(int x) {
    	Node node = nodeList[idx];
    	for(int i = 0; i < x; i++) {
    		node = node.prev;
    		idx = node.idx;
    	}
    }
    
    public void down(int x) {
    	Node node = nodeList[idx];
    	for(int i = 0; i < x; i++) {
    		node = node.next;
    		idx = node.idx;
    	}
    }
    
    public void delete() {
    	nodeList[idx].isExist = false;
    	Node before = nodeList[idx].prev;
    	Node after = nodeList[idx].next;
    	
    	if(before != null) before.next = after;
    	if(after != null) after.prev = before;
    	
    	int store = idx;
    	stack.push(store);
    	
    	if(after == null) idx = before.idx;
        else idx = after.idx;
    }
    
    public void revert() {
    	int d = stack.pop();
    	nodeList[d].isExist = true;
    	
    	Node before = nodeList[d].prev;
    	Node after = nodeList[d].next;
    	
    	if(before != null) before.next = nodeList[d];
    	if(after != null) after.prev = nodeList[d];
    }
    
    public String check() {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < nodeList.length; i++) sb.append(nodeList[i].isExist ? 'O' : 'X');
    	return sb.toString();
    }
}

