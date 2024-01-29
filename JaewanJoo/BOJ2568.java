import java.io.*;
import java.util.*;

// [BOJ] 전깃줄 - 2 / 플레티넘 5 / 30분
// 알고리즘 분류 : 가장 긴 증가하는 부분 수열: o(n log n)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] idx = new int[n];
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (o1, o2) -> {return o1[0] - o2[0];});
        
        list.add(arr[0][1]);
        idx[0] = 0;
        for(int i = 1; i < n; i++) {
        	if(arr[i][1] > list.get(list.size() - 1)) {
        		idx[i] = list.size();
        		list.add(arr[i][1]);
        		continue;
        	}
        	int start = 0;
            int end = list.size();
            while(start < end) {
            	int mid = (start + end) / 2;
            	if(arr[i][1] <= list.get(mid)) end = mid;
            	else start = mid + 1;
            }
            list.set(start, arr[i][1]);
            idx[i] = start;
        }
        
        sb.append((n - list.size()) + "\n");
        int nowIdx = list.size() - 1;
        
        for(int i = n - 1; i >= 0; i--) {
        	if(nowIdx == idx[i]) {
        		nowIdx--;
        	} else {
        		stack.add(arr[i][0]);
        	}
        }
        
        while(!stack.isEmpty()) {
        	sb.append(stack.pop() + "\n");
        }

        System.out.print(sb);
        br.close();
    }
}
