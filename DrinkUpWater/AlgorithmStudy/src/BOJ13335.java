import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13335 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue<Integer> truck = new LinkedList<>();  
		Queue<Integer> bridge = new LinkedList<>(); 
		
		st = new StringTokenizer(br.readLine());
		
		int count = 0;
		int sum = 0;
		
		while(st.hasMoreTokens()) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < w; i++) {
			bridge.add(0);
		}
		
		while(!bridge.isEmpty()) {
			sum -= bridge.poll();
			count++;
			if (!truck.isEmpty()) {
				if (sum + truck.peek() <= L) {
					sum += truck.peek();
					bridge.add(truck.poll());
				} else {
					bridge.add(0);
				}
			}
		}
		System.out.println(count);
	}
}
