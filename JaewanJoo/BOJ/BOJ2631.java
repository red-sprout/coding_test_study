import java.io.*;
import java.util.*;

// [BOJ] 줄세우기 / 골드 4 / 10분
// 알고리즘 분류 : 다이나믹 프로그래밍
// 사실 LIS 문제임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	arr[i] = tmp;
        }

        for(int i : arr) {
        	int left = 0;
            int right = list.size();
        	while(left < right) {
        		int mid = left + (right - left) / 2;
        		if(list.get(mid) > i) right = mid;
        		else left = mid + 1;
        	}
        	
        	if(left == list.size()) list.add(i);
        	else list.set(left, i);
        }
        
        System.out.println(n - list.size());
        br.close();
    }
}
