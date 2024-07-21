package src.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S14235 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
		
		int n = Integer.parseInt(bf.readLine()); //돌아갈 횟수
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(bf.readLine()); //끊어서 입력받고
			
			int a = Integer.parseInt(st.nextToken()); //처음 끊어서 입력받은 a가 충전 횟수
			
			if(a==0 && pQ.isEmpty()) { //0이며 비어있다면 1출력
				System.out.println(-1);
			}else if(a==0 && !pQ.isEmpty()) { //0이고 비어있지 않으면 추출
				System.out.println(pQ.poll());
			}else {
				while(st.hasMoreElements()) { //0이 아닐시에 처음 입력된 a를 제외하고 후에 입력받은 값들을 모두 넣어준다.
					pQ.add(Integer.parseInt(st.nextToken()));
				}
			}
		}

	}

}
