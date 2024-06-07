package year2024.month06.day10;
// 친구 네트워크
import java.io.*;
import java.util.*;

public class BOJ4195 {
	private static Map<String, String> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t = 0; t < test; t++) {
			String[] nameArr = br.readLine().split(" ");
			if(t == 0) {
				map.put(nameArr[0], nameArr[0]);
				map.put(nameArr[1], nameArr[0]);
			} else if (map.keySet().contains(nameArr[0])) {
				
			} else if (map.keySet().contains(nameArr[1])) {
				
			} else {
				
			}
		}
		br.close();
	}
	
	public String getParent(String friend) {
		return null;
	}
}
