package BOJ.dataStructure.thirdWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ10816 {
	  public static void main(String[] args) throws IOException {
	    	//HashMap(Dictionary) 구조를 이용한 풀이법
			// cf) 시간복잡도 : N / 메모리: 159640KB / 시간: 960ms
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    	
	    	StringTokenizer st;
	    	
	    	// 숫자 카드를 key로 빈도를 value로 갖는 HashMap 생성
	    	Map<Integer, Integer> cards = new HashMap<>();
	    	
	    	// 상근이 지닌 숫자 카드의 갯수(N)
	    	int numbersOfCard = Integer.parseInt(br.readLine());
	    	
	    	// 숫자 카드에 적힌 정수값 입력받은 후 쪼갬
	    	st = new StringTokenizer(br.readLine());
	    	
	    	// map에 카드를 저장하되 같은 숫자의 카드일 시 value 값 + 1 처리
	    	while(numbersOfCard-- > 0) {
	    		int card = Integer.parseInt(st.nextToken());
	    		// HashMap 은 같은 키값을 넣을 시 value 값 초기화됨
	    		// 이런 특성을 활용하여 .getOrDefault(Object key, Integer defaultValue; key 의 value 값(부재 시 defaultValue) 반환) + 1 을 하여 같은 숫자의 카드일 시 빈도 수 + 1 처리
	    		cards.put(card, cards.getOrDefault(card, 0) + 1);
	    	}
	    	
	    	// 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 정수의 갯수(M)
	    	int numbersOfNum = Integer.parseInt(br.readLine());
	    	
	    	// 쪼개서 배열에 저장
	    	int[] targetNumbers = new int[numbersOfNum];
	    	st = new StringTokenizer(br.readLine());
	    	for(int i = 0; i < numbersOfNum; i++) {
	    		targetNumbers[i] = Integer.parseInt(st.nextToken());
	    	}
	    	
	    	// 결과 저장할 StringBuilder
	    	StringBuilder result = new StringBuilder();
	    	
	    	for(int target : targetNumbers) {
	    		int frequency = cards.getOrDefault(target, 0);
	    		
	    		result.append(frequency).append(" ");
	    	}
	    	
	    	bw.write(result.toString().trim());
	    	bw.flush();
	    	bw.close();
	    	br.close();
	    }
	}
//	    	// 이진 탐색(Binary Search) 활용한 풀이법(분할 정복 알고리즘)
//			// cf) 시간복잡도 : NlogN / 메모리: 126628KB / 시간: 1500ms
//	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	    	StringTokenizer st;
//	    	
//	    	// 상근이 지닌 숫자 카드의 갯수(N)
//	    	int numbersOfCard = Integer.parseInt(br.readLine());
//	    	
//	    	
//	    	// 숫자 카드에 적힌 정수들 저장하기 위한 변수
//	    	int[] numbers = new int[numbersOfCard];
//	    	
//	    	// 숫자 카드에 적힌 정수값 입력받은 후 쪼갬
//	    	st = new StringTokenizer(br.readLine());
//	    	
//	    	// 저장
//	    	for(int i = 0; i < numbers.length; i++) {
//	    		numbers[i] =  Integer.parseInt(st.nextToken());    		
//	    	}
//	    	
//	    	// 정렬
//	    	Arrays.sort(numbers);
//	    	
//	    	// 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 정수의 갯수(M)
//	    	int numbersOfNum = Integer.parseInt(br.readLine());
//	    	
//	    	// 쪼개서 배열에 저장
//	    	int[] targetNumbers = new int[numbersOfNum];
//	    	st = new StringTokenizer(br.readLine());
//	    	for(int i = 0; i < numbersOfNum; i++) {
//	    		targetNumbers[i] = Integer.parseInt(st.nextToken());
//	    	}
//	    	
//	    	// 결과 저장할 StringBuilder
//	    	StringBuilder result = new StringBuilder();
//	    	
//	    	// 이진 탐색 통해 동일 숫자 빈도 계산
//	    	// 정렬 탐색 후 (큰 첫 번째 위치 - 크거나 같은 첫 번째 위치)의 결과값이 곧 빈도
//	    	// ex) 정렬한 배열 arr[6] = 7, arr[7] = 10, arr[8] = 10, arr[9] = 10, M = 10 일때
//	    	// M 보다 큰 첫 번째 위치 = 배열의 끝 다음 위치(M이 정렬된 배열내에서 제일 큰 값일 경우) == 10 
//	    	// M 크거나 같은 첫 번째 위치 = 7
//	    	//  => 빈도는 3
//	    	// 만약 정렬 내에 M이 없다면 위치값들이 모두 같을 것이기 때문에 결과값은 0이게 됨
//	    	for(int target : targetNumbers) {
//	    		int frequency = upperBound(numbers, target) - lowerBound(numbers, target);
//	    		
//	    		result.append(frequency).append(" ");
//	    	}
//	    	
//	    	
//	    	bw.write(result.toString().trim());
//	    	
//	    	bw.flush();
//	    	
//	    	br.close();
//	    }
	//    
//	    // M보다 큰 수 중 첫 번째 위치 반환하는 메소드
//	    static int upperBound(int[] array, int key) {
//	    	// 탐색 범위는 첫 번째 인덱스 ~ 배열의 끝 다음 위치
//	    	int low = 0;
//	    	// high = numbers.length - 1이 아닌 이유는 key 값이 배열의 최대값일 경우 key 보다 큰 위치는 배열의 마지막 위치 + 1 이기 때문(배열의 마지막 요소를 제대로 탐색하지 못함)
//	    	int high = array.length;
//	    	
//	    	// 이진 탐색을 위한 반복문
//	    	while(low < high) {
//	    		// 이진 탐색을 위한 기준점 선언
//	    		int mid = (high + low) / 2;
//	    		// key 가 기준점보다 작으면 numbers[low] ~ numbers[기준점]을 탐색
//	    		if(array[mid] > key) {
//	    			high = mid;
//	    		// key 가 기준점보다 크면 numbers[low+1] ~ high 를 탐색 범위로 설정
//	    		} else {
//	    			low = mid + 1;
//	    		}
//	    		// 반복문이 종료되는 시점에 low = high 이므로 low 는 큰 수 중 첫번째 위치를 반환하게 됨.  
//	    	}
//	    	return low;
//	    }
	//    
//	    // M보다 크거나 같은 수 중 첫 번째 위치 반환하는 메소드
//	    static int lowerBound(int[] array, int key) {
//	    	int low = 0;
//	    	int high = array.length;
//	    	
//	    	while(low < high) {
//	    		int mid = (high + low) / 2;
//	    		
//	    		if(array[mid] >= key) {
//	    			high = mid;
//	    		} else {
//	    			low = mid + 1;
//	    		}
//	    	}
//	    	
//	    	return low;
//	    }
	//}
