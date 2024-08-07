package com.practice.a;

public class SegmentTree {
	static int[] arr = {0, 1, 4, 2, 7, 3};
	// index 2 ~ 4 => 13
	// index 3 => 6
	// index 2 ~ 4 => 17
	static int[] tree;
	public static void main(String[] args) {
		int h = (int)Math.ceil(Math.log(5)/Math.log(2));
		tree = new int[1 << (h + 1)];
		init(1, 1, 5);
		System.out.println(query(1, 1, 5, 2, 4));
		update(1, 1, 5, 3, 6);
		System.out.println(query(1, 1, 5, 2, 4));
	}
	
	// Segment Tree 초기화
	public static int init(int node, int start, int end) {
		// 리프 노드는 start == end
		if(start == end) {
			// 리프 노드의 경우 arr[start] 값으로 대입 후 그 값을 반환
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		// 리프 노드가 아닌 경우 왼쪽 자식 노드와 오른쪽 자식 노드의 합 - 분할 정복
		return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	}
	
	// 조회
	public static int query(int node, int start, int end, int left, int right) {
		// lr  se 또는 se lr 인 케이스는 논외 - 0 반환
		if(end < left || start > right) {
			return 0;
		}
		
		// l (se) r 인 케이스는 더이상 볼 필요가 없으므로 해당 노드 반환
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		// 리프 노드가 아닌 경우 왼쪽 자식 노드와 오른쪽 자식 노드의 합 - 분할 정복
		return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
	}
	
	// 업데이트
	public static int update(int node, int start, int end, int idx, int value) {
		// 인덱스가 범위 밖인 경우 더 이상 볼 필요가 없으므로 해당 노드 반환
		if(idx < start || end < idx) {
			return tree[node];
		}
		
		// 한 점으로 수렴하는 경우 업데이트를 해야되는 노드에 해당, 노드 업데이트 후 해당 노드 반환
		if(start == end) {
			arr[idx] = value;
			return tree[node] = value;
		}
		
		int mid = (start + end) / 2;
		// 리프 노드가 아닌 경우 왼쪽 자식 노드와 오른쪽 자식 노드의 합 - 분할 정복
		return tree[node] = update(node * 2, start, mid, idx, value) + update(node * 2 + 1, mid + 1, end, idx, value);
	}
	
	// 준호 방식 - 업데이트, 값의 차이를 계속 더하는 방식으로 진행
	public static void update2(int node, int start, int end, int idx, int diff) {
		if (idx < start || end < idx) {
			return;
		}
		
		if(start == end) {
			arr[idx] += diff;
			tree[node] += diff;
			return;
		}
		
		int mid = (start + end) / 2;
		tree[node] += diff;
		update2(node * 2, start, mid, idx, diff);
		update2(node * 2 + 1, mid + 1, end, idx, diff);
	}
}
