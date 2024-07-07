import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1475 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];		
		
		String str = bf.readLine();
		
		for(char c : str.toCharArray()) {
			int num = c - '0';
			
			if(num==9) {
				num = 6;
			}
			arr[num]++;
		}
		
		arr[6] = (arr[6]/2) + (arr[6]%2);
		
		Arrays.sort(arr);
		
		System.out.println(arr[9]);
		

	}

}
