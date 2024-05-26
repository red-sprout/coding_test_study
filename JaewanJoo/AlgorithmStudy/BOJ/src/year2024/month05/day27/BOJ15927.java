package year2024.month05.day27;
// 회문은 회문아니야!!
import java.io.*;
import java.util.*;

public class BOJ15927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = br.readLine().toCharArray();
		int size = charArr.length;
		
		boolean isSame = true;
		boolean isPalindrome = true;
		for(int i = 0; i < size / 2; i++) {
			if(charArr[i] != charArr[size - i - 1]) {
				isPalindrome = false;
				break;
			}
			if(charArr[i] != charArr[i + 1]) {
				isSame = false;
			}
		}
		
		int ans = -1;
		if(!isPalindrome) {
			ans = size;
		} else if (!isSame){
			ans = size - 1;
		} else {
			ans = -1;
		}
		
		System.out.println(ans);
		br.close();
	}
}
