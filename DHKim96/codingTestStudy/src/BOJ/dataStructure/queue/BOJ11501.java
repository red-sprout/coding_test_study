package BOJ.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 테스트케이스 수 저장
		int T = Integer.parseInt(br.readLine());
	
		// 2. 테스트 케이스마다 최대 이익을 구하기 위한 반복문 구현
		// 테스트 케이스를 반복할 때 유용한 표현식. 반복문의 조건과 감소 연산을 하나의 표현식으로 처리 가능
		while(T-- > 0) {
			// 3. 날 수 저장
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 4. 주가 배열 선언
			int[] stockPrices = new int[N];
			
			// 5. 반복문을 통해 주가배열에 주가 넣기
			for(int i = 0; i < N; i++) {
				stockPrices[i] = Integer.parseInt(st.nextToken());
			}
			
			// 6. 최대 이익을 담을 변수 생성
			// 날의 수를 나타내는 자연수 N이 1,000,000 이고 날 별 주가가 모두 10,000일 때 최대 이익은 32비트 int형의 범위를 벗어나기에
			// 64비트 long 형으로 선언
			long maxProfit = 0;
			
			maxProfit = calcMaxProfit(maxProfit, stockPrices, N);
			
			System.out.println(maxProfit);
		}
		
		br.close();
			
	}
	
	public static long calcMaxProfit(long maxProfit, int[] stockPrices, int N) {
		
		// 7. 최대 주가를 담을 변수 생성
		int maxPrice = 0;
		
		// 8. 최대 이익을 구하기 위한 역순탐색 반복문
		// 최대 이익을 구하기 위해서는 미래의 최대 주가를 예측하고 최대 주가일 때 주식을 팔아야 가능
		// 아주 다행스럽게도 홍준이는 미래 예측 능력을 지녀 미래의 주가를 알 수 있기에 미래에서 현 시점으로 역순하며 주가 비교 가능
		for(int i = N - 1; i >= 0; i-- ) {
			// 9.  최대 주가 갱신
			if(stockPrices[i] > maxPrice) {
				maxPrice = stockPrices[i];
			}
			
			// 10. 이익 누적
			// 현 시점(i) 일 때의 이익 계산하여 추가
			maxProfit += maxPrice - stockPrices[i];
		}
		
		return maxProfit;
	}
}
