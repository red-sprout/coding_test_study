package BOJ.dataStructure.thirdWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import BOJ.Main;

public class BOJ1931 {
	 public static void main(String[] args) throws IOException {
	    	// 문제의 포인트
	    	// : 그리디 알고리즘을 활용하여 회의의 종료 시간이 빠른 것들 중 겹치지 않는 것들을 선별하여 선택하기
	    	
	    	// 1.회의의 수 추출
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	int N = Integer.parseInt(br.readLine());
	    	
	    	// 2. 희의의 정보 추출(시작 시간, 종료 시간)
	    	// 회의의 정보를 저장하기 위한 2차원 배열
	    	int[][] meetings = new int[N][2];
	    	
	    	for(int i = 0; i < N; i++) {
	    		StringTokenizer st = new StringTokenizer(br.readLine());
	    		// 시작 시간
	    		meetings[i][0] = Integer.parseInt(st.nextToken());
	    		// 종료 시간
	    		meetings[i][1] = Integer.parseInt(st.nextToken());
	    	}
	    	
	    	// 3. 회의를 종료 시각이 빠른 순서로 정렬
	    	Arrays.sort(meetings, BOJ1931::compareMeetings);
	    	/*
	    	 * Comparator 메서드 분리했음
	    	 * "::"는 메서드 참조(Method Reference) 활용하면 특정 메서드를 직접 참조하여 람다 표현식 대신 사용 가능
	    	 * 람다 표현식 (o1, o2) -> Main.compareMeetings(o1, o2)와 동일한 기능
	    	 */
	    	
	    	// 4. 겹치지 않는 회의 숫자 저장할 변수 선언
	    	int count = 0;
	    	// 5. 정렬된 배열을 시작 시간과 종료 시간을 비교하여 겹치지 않는 회의 탐색
	    	// 5.1. 회의가 끝나는 시간을 저장한 변수 선언
	    	int endTime = 0;
	    	// 5.2. 배열을 반복하여 겹치지 않는 회의 탐색
	    	for(int i = 0; i < N; i++) {
	    		// 탐색한 회의의 시작 시간이 이전 회의의 종료 시간보다 커야 겹치지 않음 
	    		if(meetings[i][0] >= endTime) {
	    			// 다음 회의와 비교하기 위해 종료 시간 최신화
	    			endTime = meetings[i][1];
	    			count++;
	    		}
	    	}
	    	
	    	System.out.println(count);
	    	br.close();
	    	//44300	476
	    }
	    
	    public static int compareMeetings(int[] o1, int[] o2) {
	    	// 종료 시간이 같을 경우
	    	if(o1[1] == o2[1]) {
	    		// 시각 시간이 빠른 순서대로 정렬
	    		return o1[0] - o2[0];
	    	}
			return o1[1] - o2[1];
		}
}
