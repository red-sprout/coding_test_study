package src.week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S11866 {

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n ; i++) {
			q.add(i);
		}
		
		int count = 0;
		System.out.print('<');
		while(!q.isEmpty()) {
			count++;
			if(count==k) {
				if(q.size()!=1) {
					System.out.print(q.remove()+", ");
				} else {
					System.out.print(q.remove()+">");
				}
				count=0;
			} else {
				q.add(q.remove());
			}
		}
	}

}
