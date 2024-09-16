package year2024.month09.second;

import java.io.*;
import java.util.*;

public class Main_bj_14843_정보갓영훈이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		double score = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double S = Double.parseDouble(st.nextToken());
			double A = Double.parseDouble(st.nextToken());
			double T = Double.parseDouble(st.nextToken());
			double M = Double.parseDouble(st.nextToken());
			score += S * (1 + 1 / A) * (1 + M / T) / 4;
		}
		
		int cnt = 0;
		int P = Integer.parseInt(br.readLine());
		double[] R = new double[P];
		for(int i = 0; i < P; i++) {
			R[i] = Double.parseDouble(br.readLine());
			if(R[i] > score) cnt++;
		}
		
		boolean notGod = (double)(cnt + 1) * 100 / (P + 1) > 15;
		System.out.printf("The total score of %s is %.2f.\n", notGod ? "Younghoon" : "Younghoon \"The God\"", score);
		br.close();
	}
}
