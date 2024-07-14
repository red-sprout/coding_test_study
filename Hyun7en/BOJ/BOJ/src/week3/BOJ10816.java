package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


/* 
 * ****** 숫자 카드 2 ******
 * Binary search/ HashMap/ counting
 * <문제>
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 
 * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
 * 
 * <입력>
 * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 
 * 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 
 * 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 
 * 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 * 
 * <출력>
 * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
 * 
 */
public class BOJ10816 {

	//HashMap
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		// 첫째 줄(상근이가 가지고 있는 숫자 카드의 개수)
//		int N = Integer.parseInt(br.readLine());
//		
//		//둘째 줄(숫자 카드에 적혀있는 정수)
//		StringTokenizer st = new StringTokenizer(br.readLine());
//	    Map<Integer, Integer> map = new HashMap<>();
//		
//	    int[] card = new int[N];
//	    
//        for (int i = 0; i < N; i++) {
//            card[i] = Integer.parseInt(st.nextToken());
//            map.put(card[i], map.getOrDefault(card[i], 0) + 1);
//        }
//        
//		
//		//셋째 줄(정수 M)
//		int M =Integer.parseInt(br.readLine());
//		
//		//넷째 줄(상근이가 몇 개 가지고 있는 숫자 카드인지 구해야할 M개의 정수)
//		st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < N; i++) {
//            int num = Integer.parseInt(st.nextToken());
//            
//            if(map.get(num) == null ) {
//            	sb.append(0).append(" ");
//            }else {
//            	sb.append(map.get(num)).append(" ");
//            }
//        }
//		
//		System.out.println(sb);
//		
//	}
	
//Counting
// 가장 빠름 대신 수의 범위가 커질 경우 에는 사용하기 힘든 방법(특히 자바에서 배열의 최대 길이가 int 범위를 넘지 못함, 메모리 낭비가 심함).	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] counting = new int[20000001];
		
		// 첫째 줄
		int N = Integer.parseInt(br.readLine());
		
		//둘째 줄
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N; i++) {
			counting[Integer.parseInt(st.nextToken()) + 10000000]++;	// 해당 인덱스의 값 증가
		}
		
		//셋째 줄
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//넷째 줄
		for(int i = 0; i < M; i++) {
			sb.append(counting[Integer.parseInt(st.nextToken()) + 10000000]).append(' ');
		}
		
		br.close();
		System.out.println(sb);
		
	}
	
}
