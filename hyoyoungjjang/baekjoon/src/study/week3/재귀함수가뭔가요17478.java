package study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀함수가뭔가요17478 {
	
	static int n = 0; 
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		function(0);
		
		br.close();
		System.out.println(sb.toString());
	}
	
	public static void function(int count) {
		
		String underBar = "";
		//count개수만큼 언더바 4개씩 추가된다.
		for(int i = 0; i < count; i++) {
			underBar += "____";
		}
		
		// count가 n이랑 같아지면 
		// "\"재귀함수가 뭔가요?\"\n" ~ "라고 답변하였지.\n"
		// sb에 append해주고 리턴
		if(count == n) {
			sb.append(underBar + "\"재귀함수가 뭔가요?\"\n");
			sb.append(underBar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(underBar + "라고 답변하였지.\n");
			return;
		}
		
		sb.append(underBar + "\"재귀함수가 뭔가요?\"\n");
		sb.append(underBar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		sb.append(underBar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		sb.append(underBar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		//재귀함수 호출하면서 count 증가
		function(count + 1);
		
		sb.append(underBar + "라고 답변하였지.\n");
	}
}
