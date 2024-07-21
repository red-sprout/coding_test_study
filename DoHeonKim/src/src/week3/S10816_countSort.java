package src.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10816_countSort {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n 세팅
        int n = Integer.parseInt(bf.readLine());
        int[] sArr = new int[n];
        st = new StringTokenizer(bf.readLine());

        // 범위 설정
        int offset = 10000000;
        int[] count = new int[20000001]; // -10,000,000 ~ 10,000,000

        // 숫자 카드의 개수를 셈
        for (int i = 0; i < n; i++) {
            sArr[i] = Integer.parseInt(st.nextToken());
            count[sArr[i] + offset]++;
        }

        // m 세팅
        int m = Integer.parseInt(bf.readLine());
        int[] checkArr = new int[m];
        st = new StringTokenizer(bf.readLine());

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(count[num + offset]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
