package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* 
 * ****** 회의실 배정 ******
 * 그리디 알고리즘
 * 
 * <문제>
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 * 
 * <입력>
 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 
 * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 
 * 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
 * 
 * <출력>
 * 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
 * 
 * 한 개의 회의실을 여러 회의가 겹치지 않게 최대한 많이 사용.
 * 각 회의는 시작 시간과 끝나는 시간이 주어짐.
 * 회의는 한번 시작하면 중간에 중단될 수 없으며, 끝나는 시간과 시작 시간이 같을 수 있음(아니 왜 시작하자 마자 끝내)
 */
public class BOJ1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫째 줄(회의실에서 할 수 있는 회의 수)
		int N = Integer.parseInt(br.readLine());
		
		// 회의 시작 시간, 끝나는 시간 저장할 배열
        int[][] times = new int[N][2];
        
		//둘째 줄 ~ N + 1 줄(각 회의의 시작시간, 끝나는 시간)
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			times[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
		}
		
		// 끝나는 시간을 기준으로 회의 정렬, 끝나는 시간이 같으면 시작 시간을 기준으로 정렬
		//익명 내부 클래스(익명 중첩 클래스)
		//프로그램에서 일시적으로 한번만 사용되고 버려지는 객체
		//유지보수면에서나 프로그램 메모리면에서나 이점
		//https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%9D%B5%EB%AA%85-%ED%81%B4%EB%9E%98%EC%8A%A4Anonymous-Class-%EC%82%AC%EC%9A%A9%EB%B2%95-%EB%A7%88%EC%8A%A4%ED%84%B0%ED%95%98%EA%B8%B0
		
        Arrays.sort(times, new Comparator<int[]>() {//익명 내부 클래스 선언
            @Override
            public int compare(int[] o1, int[] o2) {
            	// 회의의 끝나는 시간이 같은 경우 시작 시간을 기준으로 정렬
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                // 회의의 끝나는 시간이 다른 경우 끝나는 시간을 기준으로 정렬
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        // 그리디 알고리즘
        int count = 0;
        int end = 0;
        
        for (int i = 0; i < N; i++) {
            if (times[i][0] >= end) {
            	end = times[i][1];
                count++;
            }
        }
        
        br.close();
        System.out.println(count);
	}
}
