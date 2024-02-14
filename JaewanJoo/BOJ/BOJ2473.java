import java.io.*;
import java.util.*;

// [BOJ] 세 용액 / 골드 3 / 30분
// 알고리즘 분류 : 정렬 / 이분 탐색 / 두 포인터
public class Main {
	static int n;
	static long[] solution;
	
	static class Data{
		long value;
		long lower;
		long mid;
		long upper;
		
		public Data(long value, long lower, long mid, long upper) {
			this.value = value;
			this.lower = lower;
			this.mid = mid;
			this.upper = upper;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Data> list = new ArrayList<>();
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		solution = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			solution[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(solution);
		
		for(int i = 1; i < n - 1; i++) {
			long lower = 0, upper = n - 1;
			int mid = i;
			int left = 0, right = n - 1;
			long tmp = 0, sum = 0;
			long min = Long.MAX_VALUE;
			
			while(left < mid && mid < right) {
				sum = solution[left] + solution[mid] + solution[right];
				tmp = Math.abs(sum);
				if (tmp < min) {
					min = tmp;
					lower = solution[left];
					upper = solution[right];
				}
				
				if(sum > 0) right--;
				else left++;
			}
			list.add(new Data(min, lower, solution[mid], upper));
		}
		
		Data data = new Data(Long.MAX_VALUE, 0, 0, 0);
		for(Data d : list) {
			if(d.value < data.value) {
				data = d;
			}
		}
		
		System.out.println(data.lower + " " + data.mid + " " + data.upper);
		br.close();
	}
}
