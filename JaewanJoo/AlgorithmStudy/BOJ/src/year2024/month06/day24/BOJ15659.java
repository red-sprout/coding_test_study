package year2024.month06.day24;
// 연산자 끼워넣기 (3)
import java.io.*;
import java.util.*;

public class BOJ15659 {
	private static int n;
	private static int[] arr, count, order;
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	private static List<Integer> numlist = new LinkedList<>();
	private static List<Integer> orderlist = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		count = new int[4];
		order = new int[n - 1];
		
		String[] info = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(info[i]);
		}
		
		info = br.readLine().split(" ");
		for(int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(info[i]);
		}
		
		dfs(0);
		System.out.println(max);
		System.out.println(min);
		br.close();
	}
	
	public static void dfs(int idx) {
		if(idx == n - 1) {
			calc();
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(count[i] == 0) continue;
			order[idx] = i;
			count[i]--;
			dfs(idx + 1);
			count[i]++;
		}
	}
	
	public static void calc() {
		for(int i : arr) {
			numlist.add(i);
		}
		
		for(int i : order) {
			orderlist.add(i);
		}
		
		for(int i = 0; i < orderlist.size(); i++) {
			if(orderlist.get(i) < 2) continue;
			if(orderlist.get(i) == 2) {
				numlist.set(i, numlist.get(i) * numlist.get(i + 1));
			} else {
				numlist.set(i, numlist.get(i) / numlist.get(i + 1));
			}
			orderlist.remove(i);
			numlist.remove(i + 1);
			i--;
		}
		
		int result = numlist.get(0);
		for(int i = 1; i < numlist.size(); i++) {
			if(orderlist.get(i - 1) == 0) {
				result += numlist.get(i);
			} else {
				result -= numlist.get(i);
			}
		}
		
		max = Math.max(max, result);
		min = Math.min(min, result);
		
		numlist.clear();
		orderlist.clear();
	}
}
