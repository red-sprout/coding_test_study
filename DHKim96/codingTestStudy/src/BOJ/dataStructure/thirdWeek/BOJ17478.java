package BOJ.dataStructure.thirdWeek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ17478 {
    public static void main(String[] args) throws IOException {
    	// 자동 응답 챗봇
    	// 1. 출력을 원하는 재귀 횟수 N(1<=N<=50) 추출
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	// 2. 재귀 횟수에 따른 챗봇의 응답 출력
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder total = new StringBuilder();
    	total.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
    	
    	response(total, N, 0);
    	
    	bw.write(total.toString());
    	bw.flush();
    	bw.close();
    	br.close();
    }
    
    static void response(StringBuilder total, int N, int count) {
    	StringBuilder underBar = new StringBuilder();
    	
    	for(int i = 0; i < count; i++) {
    		underBar.append("____");
    	}
    	
    	total.append(underBar).append("\"재귀함수가 뭔가요?\"\n");
    	
    	if(count == N) {
    		// 재귀함수의 깊이가 N 에 도달하면 더 이상 재귀 X
    		total.append(underBar).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
    	} else {
    		total.append(underBar).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
	    		.append(underBar).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
	    		.append(underBar).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
    		response(total, N, count + 1);
    	}
    	// 재귀함수를 빠져나오면서 하나씩 실행
    	total.append(underBar).append("라고 답변하였지.\n");    	
    }
}
