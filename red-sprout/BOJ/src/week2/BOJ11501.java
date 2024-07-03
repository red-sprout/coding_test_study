package week2;
// 주식
import java.io.*;

public class BOJ11501 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int test = 1; test <= T; test++) {
        	int n = Integer.parseInt(br.readLine());
        	String[] info = br.readLine().split(" ");
        	int[] arr = new int[n];
        	for(int i = 0; i < n; i++) {
        		arr[i] = Integer.parseInt(info[i]);
        	}
        	
        	int now = 0;
        	long ans = 0; // 자료형 주의!
        	for(int i = n - 1; i >= 0; i--) {
        		if(arr[i] > now) {
        			now = arr[i];
        		} else {
        			ans += now - arr[i];
        		}
        	}
        	
        	sb.append(ans).append("\n");
        }
	        
	    System.out.print(sb);
	    br.close();
    }
}
