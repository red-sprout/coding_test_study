import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//처음 주어진 n 개의 수
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		//상근이가 가지고잇는 수
		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		//map 에 index가 arr1 갯수 갯수  arr[i]에 각 수 가 몇개있는지 
		for (int i = 0; i < arr1.length; i++) {
			if (map.get(arr1[i]) == null) {
				map.put(arr1[i], 1);
			} else {
				map.put(arr1[i], map.get(arr1[i]) + 1);
			}
//			map.getOrDefault(map, null) 사용
		}
		//숫자 출력
		for (int i = 0; i < arr2.length; i++) {
			if (map.get(arr2[i]) == null) {
				sb.append("0 ");
			} else {
				sb.append(map.get(arr2[i])).append(" ");
			}
		}
		System.out.println(sb);
	}
}
