package src.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int n = Integer.parseInt(bf.readLine());
		
		int count = 0;
//		//이렇게 하면 중복 체크를 할 수가 없음
//		int[] startArr = new int[n];
//		int[] endArr = new int[n];		
//		
//		for(int i = 0; i < n; i++) {
//			st = new StringTokenizer(bf.readLine());
//			
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			
//			startArr[i] = start;
//			endArr[i] = end;
//		}
//		
//		int endTime = 0 ;
//		
//		for(int i = 0 ; i < n; i++) {
//			if(i > 0) {			
//				if(endTime <= startArr[i]) {
//					count++;
//					endTime = endArr[i];
//				}
//			}else {
//				endTime = endArr[0];
//			}
//		}
//		System.out.println(count);
		
		//그래서 고안해낸 중복체크 정렬
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
		st = new StringTokenizer(bf.readLine());
		
		arr[i][0] = Integer.parseInt(st.nextToken());
		arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
			
		});
		
	int endtime=0;
		
	for(int i = 0 ; i < n; i++) {		
		if(endtime <= arr[i][0]) {
			count++;
			endtime = arr[i][1];
		}

	}
		System.out.println(count);
		
	}

}
