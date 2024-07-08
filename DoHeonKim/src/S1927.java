import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		for(int i = 0 ; i < n ; i++) {
			int x = Integer.parseInt(bf.readLine());
			
			if(x!=0) {
				pQ.add(x);

			} else {
				if(pQ.isEmpty()) {
					System.out.println(0);
				}else {
					int y = pQ.poll();
					System.out.println(y);
				}
			} 
			
		}
	}

}
