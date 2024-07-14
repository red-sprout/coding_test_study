import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11286 {
	private static class Coperator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			
			int a = Math.abs(o1);
			int b = Math.abs(o2);
			
			if (a == b) {
				return o1 - o2;
			} else {
				return a - b;
			}
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Coperator());
		
		for (int i = 0; i < n ; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (queue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			} else {
				queue.add(x);
			}
		}
		System.out.println(sb);
	}
}
