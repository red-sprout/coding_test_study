package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * ****** 요세푸스 문제 0 ******
 * 
 * <문제>
 * 1~N(N명의 사람이 원형으로 앉음)
 * 양의 정수 K(≤ N). 순서대로 K번째 사람을 제거
 * N명의 사람이 모두 제거될 때까지 계속
 * 	
 * 
 * poll() : 큐가 비어 있으면 null을 반환. 예외를 던지지 않고 안전하게 처리 가능.
 * remove() : 큐가 비어 있으면 NoSuchElementException을 던짐. 예외 처리 필요.
 */
public class BOJ11866 {
	//1 2 3 4 5 6 7
	//7, 3
	//3 6 2 7 5 1 4
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] inputs = br.readLine().split(" ");
	    
	    int N = Integer.parseInt(inputs[0]);
	    int K = Integer.parseInt(inputs[1]);
	    Queue<Integer> queue = new LinkedList<>();
	    
	    for(int i = 1; i <= N; i++) {
	    	queue.add(i);
	    }
	    StringBuilder result = new StringBuilder();
        
        while (!queue.isEmpty()) {
            // K-1 까지 저장
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll()); 
            }
            // K 요소 제거, 출력 리스트에 추가
            result.append(queue.poll());
            if (!queue.isEmpty()) {
                result.append(", ");
            }
        }
        
        System.out.println("<" + result + ">");
        
        br.close();
    }
}
