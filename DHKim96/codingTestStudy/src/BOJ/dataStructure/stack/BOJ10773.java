package BOJ.dataStructure.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10773 {
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int k = Integer.parseInt(br.readLine());
			
			// 배열 생성
			int[] arr = new int[k];
			
			int num = 0;
			
			int sum = 0;
			
			for(int i = 0; i < k; i++) {
				arr[i] = 0;
				
				num = Integer.parseInt(br.readLine());
				
				if(i > 0 && num == 0) {
					for(int j = i; j >= 0; j--) {
						if(arr[j] == 0) continue;
						arr[j] = 0;
						break;
					};
				};
				
				arr[i] = num;
			}
			
			br.close();
			
			for(int m : arr) {
				sum += m;
			}
			
			System.out.println(sum);
			
		}
}
