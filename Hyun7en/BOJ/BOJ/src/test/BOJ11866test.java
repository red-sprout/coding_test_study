package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//요세푸스 문제 0
/*
* 1~N(N명의 사람이 원형으로 앉음)
* 양의 정수 K(≤ N). 순서대로 K번째 사람을 제거
* N명의 사람이 모두 제거될 때까지 계속
* 	
*/
public class BOJ11866test {
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] inputs = br.readLine().split(" ");
	    int N = Integer.parseInt(inputs[0]);
	    int K = Integer.parseInt(inputs[1]);
	    br.close();
	    List<Integer> result = josephus(N, K);
	    System.out.println(formatResult(result));
	}

	 public static List<Integer> josephus(int N, int K) {
	        List<Integer> people = new ArrayList<>();
	        for (int i = 1; i <= N; i++) {
	            people.add(i);
	        }

	        List<Integer> result = new ArrayList<>();
	        int index = 0;

	        while (!people.isEmpty()) {
	            index = (index + K - 1) % people.size();
	            result.add(people.remove(index));
	        }

	        return result;
	    }

		private static String formatResult(List<Integer> result) {
		    return "<" + result.stream().map(String::valueOf).collect(Collectors.joining(", ")) + ">";
		}
}

