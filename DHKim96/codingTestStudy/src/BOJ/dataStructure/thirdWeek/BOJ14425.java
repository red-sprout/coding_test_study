package BOJ.dataStructure.thirdWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ14425 {
	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	Set<String> S = new HashSet<>();
    	for(int i = 0; i < N; i++) {
    		S.add(br.readLine());
    	}
    	
    	int count = 0;
    	for(int i = 0; i < M; i++) {
    		 String str = br.readLine();
    		 if(S.contains(str)) count++;
    	}
    	System.out.println(count);
    	br.close();
    	// 메모리는 큰 차이 없으나 시간이 364ms 로 약 1/10 단축
	 }
}
//	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	    	// N개의 문자열로 이루어진 집합 S
//	    	
//	    	// 입력으로 주어진 M개의 문자열
//	    	
//	    	// M개의 문자열 중 집합 S 에 포함된 것들의 갯수
//	    	
//	    	// 첫째 줄에는 문자열의 갯수 N(1<=N<=10,000), M(1<=M<=10,000)
//	    	// 1. N, M 추출하기
//	    	// 1.1 문자열을 쪼갤 StringTokenizer 생성
//	    	StringTokenizer st = new StringTokenizer(br.readLine());
//	    	// 1.2. 문자열을 쪼갠 뒤 int형 변수에 저장
//	    	int N = Integer.parseInt(st.nextToken());
//	    	int M = Integer.parseInt(st.nextToken());
//	    	
//	    	// 2. N 개의 줄에 입력된 집합 S에 포함된 문자열들 추출해 저장
//	    	// 2.1. 집합 S를 저장하기 위한 Map 객체 생성
//	    	Map<Integer, String> S = new HashMap<>();
//	    	// 2.2. 해당 Map 에 N개의 줄에 입력한 문자열들 저장
//	    	for(int i = 1; i <= N; i++) {
//	    		S.put(i, br.readLine());
//	    	}
//	    	
//	    	// 3. M 개의 줄에 입력한 문자열들 검사
//	    	int count = 0;
//	    	while(M-- > 0) {
//	    		 String str = br.readLine();
//	    		 if(S.containsValue(str)) count++;
//	    	}
//	    	System.out.println(count);
//	    	br.close();
//	    	// write() 사용시 31556kb/3616ms
//	    	// println() 사용시 31300kb/3396ms
//	    }
//}
