package year2024.month08.fifth;

import java.io.*;
import java.util.*;

public class Main_bj_16287_Parcel {
	static int w, n, arr[], dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		dp = new int[800000];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n ; j++) {
                int tmp = arr[i] + arr[j];
                if(tmp > w) continue;
                dp[tmp] = j;
                if(dp[w-tmp] != 0 && dp[w-tmp] > j){
                    System.out.println("YES");
                    br.close();
                    return;
                }
            }
        }
        System.out.println("NO");
		br.close();
	}
}
