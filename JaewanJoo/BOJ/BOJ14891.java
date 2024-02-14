import java.io.*;
import java.util.*;

// [BOJ] 톱니바퀴 / 골드 5 / 2시간
// 알고리즘 분류 : 구현 / 시뮬레이션
public class Main {
	private static List<LinkedList<Integer>> gears;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gears = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			String row = br.readLine();
			LinkedList<Integer> gear = new LinkedList<>();
			for (int j = 0; j < 8; j++) {
				gear.add(row.charAt(j) - '0');
			}
			gears.add(gear);
		}
		
		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int gearIdx = Integer.parseInt(st.nextToken());
			boolean isCW = (Integer.parseInt(st.nextToken()) == 1);
			rotation(gearIdx - 1, isCW);
		}
		
		int part = 1;
		int sum = 0;
		for(LinkedList<Integer> gear : gears) {
			sum += gear.get(0) * part;
			part = part << 1;
		}
		
		System.out.println(sum);
		br.close();
    }
	
	public static void rotation(int gearIdx, boolean isCW) {
		boolean[] canRotate = new boolean[3];
		for (int i = 0; i < 3; i++) {
			canRotate[i] = gears.get(i).get(2) != gears.get(i + 1).get(6);
		}
		
		switch(gearIdx) {
		case 0:
			isCW = gearRotation(isCW, 0);
			for(int i = 0; i < 3; i++) {
				if(!canRotate[i]) break;
				isCW = gearRotation(isCW, i + 1);
			}
			break;
		case 1:
			isCW = gearRotation(isCW, 1);
			if(canRotate[0]) gearRotation(isCW, 0);
			for(int i = 1; i < 3; i++) {
				if(!canRotate[i]) break;
				isCW = gearRotation(isCW, i + 1);
			}
			break;
		case 2:
			isCW = gearRotation(isCW, 2);
			if(canRotate[2]) gearRotation(isCW, 3);
			for(int i = 1; i >= 0; i--) {
				if(!canRotate[i]) break;
				isCW = gearRotation(isCW, i);
			}
			break;
		case 3:
			isCW = gearRotation(isCW, 3);
			for(int i = 2; i >= 0; i--) {
				if(!canRotate[i]) break;
				isCW = gearRotation(isCW, i);
			}
			break;
		}
	}
	
	public static boolean gearRotation(boolean isCW, int idx) {
		if(isCW) {
			clockwise(gears.get(idx));
		} else {
			counterClockwise(gears.get(idx));
		}
		return !isCW;
	}
	
	public static void clockwise(LinkedList<Integer> gear) {
		gear.addFirst(gear.pollLast());
	}
	
	public static void counterClockwise(LinkedList<Integer> gear) {
		gear.addLast(gear.pollFirst());
	}
}
