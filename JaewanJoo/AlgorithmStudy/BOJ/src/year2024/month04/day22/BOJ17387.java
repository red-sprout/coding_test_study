package year2024.month04.day22;

import java.io.*;
import java.util.*;

public class BOJ17387 {
	private static double e = 1e-9;
	private static class Line {
		long a, b, c;
		long xmin, xmax;
		long ymin, ymax;
		
		Line(long[] points) {
			this.xmin = Math.min(points[0], points[2]);
			this.xmax = Math.max(points[0], points[2]);
			this.ymin = Math.min(points[1], points[3]);
			this.ymax = Math.max(points[1], points[3]);
			
			if(xmax == xmin) {
				this.a = 1l;
				this.b = 0l;
				this.c = xmin;
			} else if(ymax == ymin) {
				this.a = 0l;
				this.b = 1l;
				this.c = ymin;
			} else {
				this.a = points[3] - points[1];
				this.b = points[0] - points[2];
				this.c = a * points[0] + b * points[1];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long[] p1 = new long[4];
		long[] p2 = new long[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			p1[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			p2[i] = Long.parseLong(st.nextToken());
		}
		
		int result = 0;
		Line l1 = new Line(p1);
		Line l2 = new Line(p2);
		if(isSamePoint(p1, p2)) {
			result = 1;
		} else if(isSameDirection(p1, p2)) {
			result = inRange(l1, l2);
		} else {
			double[] pos = calc(l1, l2);
			result = inRange(pos, l1, l2);
		}
		
		System.out.println(result);
		br.close();
	}
	
	public static boolean isSameDirection(long[] p1, long[] p2) {
		long left = (p2[2] - p2[0]) * (p1[3] - p1[1]);
		long right = (p2[3] - p2[1]) * (p1[2] - p1[0]);
		return left == right;
	}
	
	public static boolean isSamePoint(long[] p1, long[] p2) {
		if(p1[0] == p2[0] && p1[1] == p2[1]) return true;
		if(p1[2] == p2[0] && p1[3] == p2[1]) return true;
		if(p1[0] == p2[2] && p1[1] == p2[3]) return true;
		if(p1[2] == p2[2] && p1[3] == p2[3]) return true;
		return false;
	}
	
	public static int inRange(Line l1, Line l2) {
		if(l1.c != l2.c) return 0;
		if(l1.xmax < l2.xmin) return 0;
		if(l1.xmin > l2.xmax) return 0;
		if(l1.ymax < l2.ymin) return 0;
		if(l1.ymin > l2.ymax) return 0;
		return 1;
	}
	
	public static double[] calc(Line l1, Line l2) {
		double det = (double)(l1.a * l2.b - l2.a * l1.b);
		double x = (l2.b * l1.c - l1.b * l2.c) / det;
		double y = (-l2.a * l1.c + l1.a * l2.c) / det;
		return new double[] {x, y};
	}
	
	public static int inRange(double[] pos, Line l1, Line l2) {
		if(pos[0] + e < l1.xmin || pos[0] - e > l1.xmax) return 0;
		else if(pos[1] + e < l1.ymin || pos[1] - e > l1.ymax) return 0;
		else if(pos[0] + e < l2.xmin || pos[0] - e > l2.xmax) return 0;
		else if(pos[1] + e < l2.ymin || pos[1] - e > l2.ymax) return 0;
		else return 1;
	}
}
