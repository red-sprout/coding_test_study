package year2024.month10.third;

import java.io.*;
import java.util.*;

public class Main_bj_1708_볼록껍질 {
	static int ccw(int[] a, int[] b, int[] c) {
		long result = (long)(b[0] - a[0]) * (c[1] - a[1]) - (long)(c[0] - a[0]) * (b[1] - a[1]);
		if(result > 0) return 1;
		else if(result < 0) return -1;
		return 0;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] point = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < N; i++) {
			if(point[0][1] > point[i][1] || (point[0][1] == point[i][1] && point[0][0] > point[i][0])) {
				int[] temp = point[0];
				point[0] = point[i];
				point[i] = temp;
			}
		}
		Arrays.sort(point, 1, N, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int v = ccw(point[0], o1, o2);
				if(v > 0) return -1;
				if(v < 0) return 1;
				return (Math.abs(o1[0]) + o1[1]) - (Math.abs(o2[0]) + o2[1]);
			}
		});
		int size = 0;
		int[] stack = new int[N];
		stack[size++] = 0;
		for(int i = 1; i < N; i++) {
			while(size > 1 && ccw(point[stack[size - 2]], point[stack[size - 1]], point[i]) <= 0) {
				size--;
			}
			stack[size++] = i;
		}
		System.out.println(size);
		br.close();
	}
}
