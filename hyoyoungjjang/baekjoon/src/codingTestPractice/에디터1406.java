package codingTestPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class 에디터1406 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split("");
		LinkedList<String> list = new LinkedList<>();
		
		for(String s : str) {
			list.add(s);
		}
		
		//Iterator는 컬렉션을 순회하는 도구로, 요소를 가르키는 포인터 처럼사용!!
		ListIterator<String> iterator = list.listIterator();
		
		//포인터를 가장 뒤쪽을 이동
		while(iterator.hasNext()) {
			iterator.next();
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			
			switch(s) {
			case "L" : 
				if(iterator.hasPrevious()) {					
					iterator.previous();
				}
				break;
			case "D" :
				if(iterator.hasNext()) {					
					iterator.next();
				}
				break;
			case "B" : 
				if(iterator.hasPrevious()) {
					iterator.previous();
					iterator.remove();	
				}
				break;
			case "P" : 
				iterator.add(st.nextToken());
				break;
			}
		}
				
		while(iterator.hasPrevious()) {
			iterator.previous();
		}
		
		while(iterator.hasNext()) {
			String s = iterator.next();
			sb.append(s);
			iterator.remove();
		}
		
		br.close();
		System.out.println(sb);	
	}
}
