import java.io.*;

public class SelectProblem1 {
	static int[] stack;
	static int index = 0;
	static int max;
	
	public static boolean stackIsEmpty() {
        // 스택이 비었으면 true, 아니면 false
		if (index > 0) {
			return false;
		} else {
			return true;
		}
    }
 
    public static boolean stackPush(int value) {
        // 스택에 값을 넣을 때, 넣을 수 있으면 값을 넣고 true, 넣을 수 없으면 false
    	if (index < max) {
    		stack[index] = value;
        	index++;
        	return true;
    	} else {
    		return false;
    	}
    }
 
    public static Integer stackPop() {
        // 스택에서 값을 꺼내고 그 값을 반환, 없다면 null
    	if (index > 0) {
    		index--;
        	return stack[index];
    	} else {
    		return null;
    	}
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			max = Integer.parseInt(br.readLine());
			stack = new int[max];
			String str = br.readLine();
			String[] sArr = str.split(" "); 
			
			for (int j = 0; j < max; j++) {
				int num = Integer.parseInt(sArr[j]);
				stackPush(num);
			}
			
			System.out.print("#" + (i + 1) + " ");
			while(!stackIsEmpty()) {
				System.out.print(stackPop() + " ");
			}
			System.out.println();
		}
	}
}
