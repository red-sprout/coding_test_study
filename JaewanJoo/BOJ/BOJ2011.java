import java.io.*;

// [BOJ] 암호코드 / 골드 5 / 30분
// 알고리즘 분류 : 다이나믹 프로그래밍
public class Main {
	private static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String password = br.readLine();
        String part = null;
        
        int[] dp = new int[password.length() + 1];
        boolean flag = false;
        dp[0] = 1;
        
        for(int i = 1; i <= password.length(); i++) {
        	if(i == 1) {
        		if(!isAlphabet(password.substring(0, 1))) {
        			flag = true;
        			break;
        		}
        		dp[1] = 1;
        		continue;
        	} 
        	
        	part = password.substring(i - 2, i);
        	if(isAlphabet(part.substring(1, 2))) {
        		dp[i] = (dp[i] + dp[i - 1]) % MOD;
        	}
        	if(isAlphabet(part)) {
        		dp[i] = (dp[i] + dp[i - 2]) % MOD;
        	}
        	
        	if(dp[i] == 0) {
        		flag = true;
        		break;
        	}
        }
        
        if(flag) {
        	System.out.println(0);
        } else {
        	System.out.println(dp[password.length()]);
        }
        
        br.close();
    }
    
    public static boolean isAlphabet(String part) {
    	if(part.charAt(0) == '0') return false;
    	
    	int i = (char)Integer.parseInt(part);
    	return i >= 1 && i <= 26;
    }
}
