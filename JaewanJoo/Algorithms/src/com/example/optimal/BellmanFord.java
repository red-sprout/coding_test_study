package com.example.optimal;

import java.io.*;

/*
 * 1. 출발 노드 설정
 * 2. 최단 거리 테이블을 초기화한다.
 * 3. 다음의 과정을 (V - 1)번 반복한다.
 * 	3-1. 모든 간선 E개를 하나씩 확인한다.
 * 	3-2. 각 간선을 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
 * 4. 만약 음수 간선 순환이 발생하는지 체크하려면 3번으로 돌아간다. 갱신되면 존재
 */

class BFNode {
	int from;
	int to;
	int value;
}

public class BellmanFord {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		
		
		br.close();
	}
}
