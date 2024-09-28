package year2024.month09.third;

import java.io.*;

public class Main_bj_10829_이진수변환 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Long.toString(Long.parseLong(br.readLine()), 2));
		br.close();
	}
}
