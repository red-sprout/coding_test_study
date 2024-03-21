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
class BFEdge {
	int v, w;
	int cost;
	
	BFEdge(int v, int w, int cost) {
		this.v = v;
		this.w = w;
		this.cost = cost;
	}
}

public class BellmanFordRun {
	private static BFEdge[] edges;
	private static final long INF = Long.MAX_VALUE;
	
	public static void BellmanFord(int n, int m) {
		long[] dist = new long[n + 1];
		for(int i = 0; i <= n; i++) {
			dist[i] = INF;
		}
		dist[1] = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				BFEdge edge = edges[j];
				if(dist[edge.v] == INF) continue;
				if(dist[edge.w] > dist[edge.v] + edge.cost) {
					dist[edge.w] = dist[edge.v] + edge.cost;
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			BFEdge edge = edges[i];
			if(dist[edge.v] == INF) continue;
			if(dist[edge.w] > dist[edge.v] + edge.cost) {
				System.out.println(-1);
				return;
			}
		}
		
		for(int i = 2; i <= n; i++) {
			System.out.println(dist[i] == INF ? -1 : dist[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		edges = new BFEdge[m];
		for(int i = 0; i < m; i++) {
			String[] vwc = br.readLine().split(" ");
			int v = Integer.parseInt(vwc[0]);
			int w = Integer.parseInt(vwc[1]);
			int cost = Integer.parseInt(vwc[2]);
			edges[i] = new BFEdge(v, w, cost);
		}
		BellmanFord(n, m);
		
		br.close();
	}
}
