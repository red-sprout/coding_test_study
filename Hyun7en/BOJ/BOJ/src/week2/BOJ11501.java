package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ****** 주식 ******
 * 
 * <문제>
 * 세 가지 행동
 * 1. 주식 하나 삼
 * 2. 원 하는 만큼 가지고 있는 주식 팔음
 * 3. 아무것도 안 함
 * 
 * <입력>
 * 입력의 첫 줄에는 테스트케이스 수를 나타내는 자연수 T가 주어진다. 
 * 각 테스트케이스 별로 첫 줄에는 날의 수를 나타내는 자연수 N(2 ≤ N ≤ 1,000,000)이 주어지고, 
 * 둘째 줄에는 날 별 주가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다. 
 * 날 별 주가는 10,000이하다.
 * 
 * <출력>
 * 각 테스트케이스 별로 최대 이익을 나타내는 정수 하나를 출력한다. 
 * 답은 부호있는 64bit 정수형으로 표현 가능하다
 * 
 * 탐색 한 후 줄어드는 형태면 0
 * 처음 수 보다 큰 수가 있으면 팔기
 * 가장 비싸게 팔 수 있는 날이 나오기 전까지 계속 삼
 * -> 뒤에서 부터 계산 하면 비싼 날을 쉽게 찾을 수 있음
 */
public class BOJ11501 {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());//테스트 케이스
		
		for(int i = 1; i <= test; i++) {
			int day = Integer.parseInt(br.readLine());//날의 수
			int[] stock = new int[day];//날 별 주가
			
			StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < day; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }
            
            long profit = 0; // 최대 이익
            int maxPrice = 0; // 현재까지의 최대 주가
            
            // 뒤에서부터 주가를 탐색하면서 최대 이익 계산
            for (int j = day - 1; j >= 0; j--) {
                if (stock[j] > maxPrice) {
                    maxPrice = stock[j];
                }
                profit += maxPrice - stock[j];
            }
            
            System.out.println(profit);
        }
		
		br.close();
	}
}
