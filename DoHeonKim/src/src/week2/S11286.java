package src.week2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int absA = Math.abs(a);
                int absB = Math.abs(b);
                if (absA == absB) {
                    return a - b; // 절댓값이 같으면 원래 값으로 비교
                } else {
                    return absA - absB; // 절댓값으로 비교
                }
            }
        });
		
		for(int i = 0; i < n ; i++) {
			int x = Integer.parseInt(bf.readLine());
			
			if(x != 0) {
				pQ.add(x);
			}else {
				if(pQ.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pQ.poll());
				}
			}
		}

	}

}
