package week3;
// 재귀함수가 뭔가요?
import java.io.*;

public class BOJ17478 {
	private static int n;
	private static String title = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	private static String first = "\"재귀함수가 뭔가요?\"\n";
	private static String[] content = {"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
										, "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
										, "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"};
	private static String middleEnd = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	private static String blank = "____";
	private static String end = "라고 답변하였지.\n";
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		sb.append(title);
		definition(0);
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void definition(int cnt) {
		makeBlank(cnt);
		sb.append(first);
		if(cnt == n) {
			makeBlank(cnt);
			sb.append(middleEnd);
		} else {
			for(int i = 0; i < 3; i++) {
				makeBlank(cnt);
				sb.append(content[i]);
			}
			definition(cnt + 1);
		}
		makeBlank(cnt);
		sb.append(end);
	}
	
	public static void makeBlank(int cnt) {
		for(int i = 0; i < cnt; i++) {
			sb.append(blank);
		}
	}
}
