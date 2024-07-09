package src.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S10816_HashMap {
	 public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        //시간초과 아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
//	        // n 세팅
//	        int n = Integer.parseInt(bf.readLine());
//	        int[] sArr = new int[n];
//	        HashMap<Integer, Integer> map = new HashMap<>();
//	        st = new StringTokenizer(bf.readLine());
//
//	        for (int i = 0; i < n; i++) {
//	            sArr[i] = Integer.parseInt(st.nextToken());
//	            map.put(sArr[i], map.getOrDefault(sArr[i], 0) + 1);
//	        }
//
//	        // m 세팅
//	        int m = Integer.parseInt(bf.readLine());
//	        int[] checkArr = new int[m];
//	        st = new StringTokenizer(bf.readLine());
//
//	        for (int i = 0; i < m; i++) {
//	            checkArr[i] = Integer.parseInt(st.nextToken());
//	        }
//
//	        // 결과 출력
//	        for (int i = 0; i < m; i++) {
//	            System.out.print(map.getOrDefault(checkArr[i], 0) + " ");
//	        }
	     // n 세팅
	        int n = Integer.parseInt(bf.readLine());
	        st = new StringTokenizer(bf.readLine());
	        
	        // 해시맵 생성
	        HashMap<Integer, Integer> map = new HashMap<>();
	        
	        // 숫자 카드의 개수를 셈
	        for (int i = 0; i < n; i++) {
	            int num = Integer.parseInt(st.nextToken());
	            map.put(num, map.getOrDefault(num, 0) + 1);
	            System.out.println(map);
	        }
	        
	        // m 세팅
	        int m = Integer.parseInt(bf.readLine());
	        st = new StringTokenizer(bf.readLine());
	        
	        // 결과 출력
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < m; i++) {
	            int num = Integer.parseInt(st.nextToken());
	            sb.append(map.getOrDefault(num, 0)).append(" ");
	        }
	        System.out.println(sb.toString());
	        
	    }
}
