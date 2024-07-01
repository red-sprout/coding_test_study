import java.io.*;

public class SelectProblem2 {
	
	private static int[] queue;
	private static int index;
	private static int pointer;
	private static int size;
	
	public static boolean queueIsEmpty() {
	        // 큐가 비었으면 true, 아니면 false
		if (index == pointer)	return true;
		else return false;
    }
    
    public static boolean queueIsFull() {
        // 큐가 가득 차있으면 true, 아니면 false
    	if (index == size) return true;
    	else return false;
    }
 
    public static boolean queueEnqueue(int value) {
        // 큐에 값을 넣을 때, 넣을 수 있으면 값을 넣고 true, 넣을 수 없으면 false
    	if (!queueIsFull()) {
    		queue[index++] = value;
    		return true;
    	} else 
    		return false;
    }
 
    public static Integer queueDequeue() {
        // 큐에서 값을 꺼내고 그 값을 반환, 없다면 null
    	if (pointer <= index) {
    		return queue[pointer++];
    	} else
    		return null;
    }
 
    public static void main(String[] arg) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			size = Integer.parseInt(br.readLine());
			queue = new int[size];
			pointer = 0;
			index = 0;
			
			String[] sArr = br.readLine().split(" ");
			
			for (int j = 0; j < sArr.length; j++) {
				queueEnqueue(Integer.parseInt(sArr[j]));
			}
			
			while(!queueIsEmpty()) {
				System.out.print(queueDequeue() + " ");
			}
			System.out.println();
		}
    }
}
