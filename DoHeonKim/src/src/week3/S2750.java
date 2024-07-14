package src.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2750 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int a : arr) {
			System.out.println(a);
		}
	}

}
