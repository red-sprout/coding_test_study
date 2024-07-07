package study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


//07:05
public class 주식11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
				
		for(int i = 0; i < t; i++) {		
			
			int n = Integer.parseInt(br.readLine());	
			Deque<Integer> dayPrice = new LinkedList<Integer>();	
			String[] dayPriceStr = br.readLine().split(" ");
			
			for(int j = 0;  j < dayPriceStr.length; j++){				
				dayPrice.addLast(Integer.parseInt(dayPriceStr[j]));	
			}
			
		    System.out.println(maxProfit(dayPrice));
			
		}
		
		br.close();
		
	}
	
	//64bit 정수형 <- 이것이 long인지 몰랐다 왜 계속 틀리나했네 
	
	//T번째 최대이익
	public static long maxProfit(Deque<Integer> dayPrice) {
		
		long profit = 0;
		long maxPrice = 0;
		
		while(!dayPrice.isEmpty()) {
			int currentPrice = dayPrice.pollLast();
			
			//만약 마지막날이 마지막전날보다 값이 작거나 같다면 lastDayPrice를 교체
			if(maxPrice < currentPrice) {
				maxPrice = currentPrice;
				continue;
			}
			
			//마지막날 가격이 전날보다 값이 크다면 덱의 마지막날을 제거해주면서 
			//이익실현을 해준다
			profit += maxPrice - currentPrice;		
			
		}
			
		return profit;
	}
	//08:28
}
