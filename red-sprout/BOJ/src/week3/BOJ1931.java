package week3;
// 회의실 배정
import java.io.*;
import java.util.*;

public class BOJ1931 {
	private static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting m) {
			if(this.end == m.end) {
				return this.start - m.start;
			} else {
				return this.end - m.end;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Meeting[] mArr = new Meeting[N];
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			mArr[i] = new Meeting(start, end);
		}
		
		Arrays.sort(mArr);
		int cnt = 0;
		int end = 0;
		for(Meeting m : mArr) {
			if (m.start < end) continue;
			cnt++;
			end = m.end;
		}
		
		System.out.println(cnt);
		br.close();
	}
}
