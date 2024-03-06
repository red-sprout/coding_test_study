import java.io.*;
import java.util.*;

// [BOJ] 큐빙 / 플레티넘 5 / 4시간
// 알고리즘 분류 : 구현 / 시뮬레이션
public class Main {
	static char[][] up, down, front, back, left, right;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        up = new char[3][3];
        down = new char[3][3];
        front = new char[3][3];
        back = new char[3][3];
        left = new char[3][3];
        right = new char[3][3];
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
        	init(up, 'w');
            init(down , 'y');
            init(front, 'r');
            init(back, 'o');
            init(left, 'g');
            init(right, 'b');
            
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
            	String rotation = st.nextToken();
            	boolean clockwise = rotation.charAt(1) == '+';
            	switch(rotation.charAt(0)) {
            	case 'U':
            		rUp(clockwise);
            		break;
            	case 'D':
            		rDown(clockwise);
            		break;
            	case 'F':
            		rFront(clockwise);
            		rotation = "R" + rotation.charAt(1);
            		break;
            	case 'B':
            		rBack(clockwise);
            		rotation = "L" + rotation.charAt(1);
            		break;
            	case 'L':
            		rLeft(clockwise);
            		rotation = "F" + rotation.charAt(1);
            		break;
            	case 'R':
            		rRight(clockwise);
            		rotation = "B" + rotation.charAt(1);
            		break;
            	}
            }
            print(up);
            
        }
        
        System.out.print(sb);
        br.close();
    }
    
    public static void init(char[][] arr, char c) {
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			arr[i][j] = c;
    		}
    	}
    }
    
    public static void print(char[][] arr) {
    	for(int j = 0; j < 3; j++) {
        	for(int k = 0; k < 3; k++) {
        		sb.append(arr[j][k]);
        	}
        	sb.append("\n");
        }
    }
    
    public static char[][] clockwise(char[][] arr) {
    	char[][] result = new char[3][3];
    	for(int i = -1; i <= 1; i++) {
    		for(int j = -1; j <= 1; j++) {
    			result[j + 1][-1 * i + 1] = arr[i + 1][j + 1];
    		}
    	}
    	return result;
    }
    
    public static char[][] counterclockwise(char[][] arr) {
    	char[][] result = new char[3][3];
    	for(int i = -1; i <= 1; i++) {
    		for(int j = -1; j <= 1; j++) {
    			result[-1 * j + 1][i + 1] = arr[i + 1][j + 1];
    		}
    	}
    	return result;
    }
    
    public static void rUp(boolean clockWise) {
    	char[] tmp = new char[3];
    	for(int i = 0; i < 3; i++) tmp[i] = left[0][i];
    	
    	if(clockWise) {
    		up = clockwise(up);
    		for(int i = 0; i < 3; i++) left[0][i] = front[0][i];
    		for(int i = 0; i < 3; i++) front[0][i] = right[0][i];
    		for(int i = 0; i < 3; i++) right[0][i] = back[0][i];
    		for(int i = 0; i < 3; i++) back[0][i] = tmp[i];
    	} else {
    		up = counterclockwise(up);
    		for(int i = 0; i < 3; i++) left[0][i] = back[0][i];
    		for(int i = 0; i < 3; i++) back[0][i] = right[0][i];
    		for(int i = 0; i < 3; i++) right[0][i] = front[0][i];
    		for(int i = 0; i < 3; i++) front[0][i] = tmp[i];
    	}
    }
    
    public static void rDown(boolean clockWise) {
    	char[] tmp = new char[3];
    	for(int i = 0; i < 3; i++) tmp[i] = left[2][i];
    	
    	if(clockWise) {
    		down = clockwise(down);
    		for(int i = 0; i < 3; i++) left[2][i] = back[2][i];
    		for(int i = 0; i < 3; i++) back[2][i] = right[2][i];
    		for(int i = 0; i < 3; i++) right[2][i] = front[2][i];
    		for(int i = 0; i < 3; i++) front[2][i] = tmp[i];
    	} else {
    		down = counterclockwise(down);
    		for(int i = 0; i < 3; i++) left[2][i] = front[2][i];
    		for(int i = 0; i < 3; i++) front[2][i] = right[2][i];
    		for(int i = 0; i < 3; i++) right[2][i] = back[2][i];
    		for(int i = 0; i < 3; i++) back[2][i] = tmp[i];
    	}
    }
    
    public static void rFront(boolean clockWise) {
    	char[] tmp = new char[3];
    	for(int i = 0; i < 3; i++) tmp[i] = left[i][2];
    	
    	if(clockWise) {
    		front = clockwise(front);
    		for(int i = 0; i < 3; i++) left[i][2] = down[0][i];
    		for(int i = 0; i < 3; i++) down[0][2 - i] = right[i][0];
    		for(int i = 0; i < 3; i++) right[i][0] = up[2][i];
    		for(int i = 0; i < 3; i++) up[2][2 - i] = tmp[i];
    	} else {
    		front = counterclockwise(front);
    		for(int i = 0; i < 3; i++) left[i][2] = up[2][2 - i];
    		for(int i = 0; i < 3; i++) up[2][i] = right[i][0];
    		for(int i = 0; i < 3; i++) right[i][0] = down[0][2 - i];
    		for(int i = 0; i < 3; i++) down[0][i] = tmp[i];
    	}
    }
    
    public static void rBack(boolean clockWise) {
    	char[] tmp = new char[3];
    	for(int i = 0; i < 3; i++) tmp[i] = right[i][2];
    	
    	if(clockWise) {
    		back = clockwise(back);
    		for(int i = 0; i < 3; i++) right[2 - i][2] = down[2][i];
    		for(int i = 0; i < 3; i++) down[2][i] = left[i][0];
    		for(int i = 0; i < 3; i++) left[i][0] = up[0][2 - i];
    		for(int i = 0; i < 3; i++) up[0][i] = tmp[i];
    	} else {
    		back = counterclockwise(back);
    		for(int i = 0; i < 3; i++) right[i][2] = up[0][i];
    		for(int i = 0; i < 3; i++) up[0][2 - i] = left[i][0];
    		for(int i = 0; i < 3; i++) left[i][0] = down[2][i];
    		for(int i = 0; i < 3; i++) down[2][i] = tmp[2 - i];
    	}
    }
    
    public static void rLeft(boolean clockWise) {
    	char[] tmp = new char[3];
    	for(int i = 0; i < 3; i++) tmp[i] = back[i][2];
    	
    	if(clockWise) {
    		left = clockwise(left);
    		for(int i = 0; i < 3; i++) back[2 - i][2] = down[i][0];
    		for(int i = 0; i < 3; i++) down[i][0] = front[i][0];
    		for(int i = 0; i < 3; i++) front[i][0] = up[i][0];
    		for(int i = 0; i < 3; i++) up[2 - i][0] = tmp[i];
    	} else {
    		left = counterclockwise(left);
    		for(int i = 0; i < 3; i++) back[i][2] = up[2 - i][0];
    		for(int i = 0; i < 3; i++) up[i][0] = front[i][0];
    		for(int i = 0; i < 3; i++) front[i][0] = down[i][0];
    		for(int i = 0; i < 3; i++) down[i][0] = tmp[2 - i];
    	}
    }
    
    public static void rRight(boolean clockWise) {
    	char[] tmp = new char[3];
    	for(int i = 0; i < 3; i++) tmp[i] = front[i][2];
    	
    	if(clockWise) {
    		right = clockwise(right);
    		for(int i = 0; i < 3; i++) front[i][2] = down[i][2];
    		for(int i = 0; i < 3; i++) down[2 - i][2] = back[i][0];
    		for(int i = 0; i < 3; i++) back[2 - i][0] = up[i][2];
    		for(int i = 0; i < 3; i++) up[i][2] = tmp[i];
    	} else {
    		right = counterclockwise(right);
    		for(int i = 0; i < 3; i++) front[i][2] = up[i][2];
    		for(int i = 0; i < 3; i++) up[i][2] = back[2 - i][0];
    		for(int i = 0; i < 3; i++) back[i][0] = down[2 - i][2];
    		for(int i = 0; i < 3; i++) down[i][2] = tmp[i];
    	}
    }
}
