package com.practice.pro15638;

import java.util.*;

class UserSolution {
	class Monarch {
		int row;
		int col;
		int soldiers;
		String name;
		int union = -1;
		
		Monarch(int row, int col, int soldiers, String name) {
			this.row = row;
			this.col = col;
			this.soldiers = soldiers;
			this.name = name;
		}
	}
	
	class Union {
		int idx;
		Set<Integer> enemies = new HashSet<>();
		
		Union(int idx) {
			this.idx = idx;
		}
	}
	
	List<Union> unions = new ArrayList<>();
	Monarch[][] monarchs;
	Monarch[] monarchList;
	int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	String char2String(char charArr[]) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while(charArr[idx] != '\0') sb.append(charArr[idx++]);
		return sb.toString();
	}
	
	Monarch search(char charArr[]) {
		String name = char2String(charArr);
		for(int i = 0; i < monarchList.length; i++) if(monarchList[i].name.equals(name)) return monarchList[i];
		return null;
	}
	
    void init(int N, int mSoldier[][], char mMonarch[][][]) {
    	monarchs = new Monarch[N][N];
    	monarchList = new Monarch[N * N];
    	int idx = 0;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			monarchs[i][j] = new Monarch(i, j, mSoldier[i][j], char2String(mMonarch[i][j]));
    			monarchList[idx++] = monarchs[i][j];
    		}
    	}
    }
    
    void destroy() {
    	
    }
    
    int ally(char mMonarchA[], char mMonarchB[]) {
    	Monarch ma = search(mMonarchA);
    	Monarch mb = search(mMonarchB);
    	
    	if(ma.equals(mb)) return -1;
    	if(ma.union == -1 && mb.union == -1) {
    		int idx = unions.size();
    		unions.add(new Union(idx));
    		ma.union = idx;
    		mb.union = idx;
    		return 1;
    	}
    	
    	if(ma.union == mb.union) return -1;
    	if(ma.union == -1) {
    		ma.union = mb.union;
    		return 1;
    	}
    	
    	if(mb.union == -1) {
    		mb.union = ma.union;
    		return 1;
    	}
    	
    	Union union1 = unions.get(ma.union);
    	Union union2 = unions.get(mb.union);
    	
    	for(int e1 : union1.enemies) {
    		for(int i = 0; i < monarchList.length; i++) {
    			if(monarchList[i].union != mb.union) continue;
    			if(e1 == i) return -2;
    		}
    	}
    	
    	for(int e2 : union2.enemies) {
    		for(int i = 0; i < monarchList.length; i++) {
    			if(monarchList[i].union != ma.union) continue;
    			if(e2 == i) return -2;
    		}
    	}
    	
    	int idx = unions.size();
    	Union union = new Union(idx);
    	
    	for(int e1 : union1.enemies) union.enemies.add(e1);
    	for(int e2 : union2.enemies) union.enemies.add(e2);
    	
    	unions.add(union);
    	
    	for(Monarch mo : monarchList) if(mo.union == ma.union || mo.union == mb.union) mo.union = idx;
    		
    	return 1;
    }
    
    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
    	Monarch ma = search(mMonarchA);
    	Monarch mb = search(mMonarchB);
    	
    	if(ma.union == mb.union && ma.union != -1) return -1;
    	
    	if(ma.union == -1) {
    		
    	}
    	
    	if(mb.union == -1) {
    		
    	}

    	int attacker = 0;
    	int defender = mb.soldiers;
    	int N = monarchs.length;
    	boolean isAttack = false;
    	for(int d = 0; d < 8; d++) {
    		int nr = mb.row + dr[d];
    		int nc = mb.col + dc[d];
    		if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
    		
    		if(monarchs[nr][nc].union == ma.union) {
    			isAttack = true;
    			attacker += monarchs[nr][nc].soldiers / 2;
    			monarchs[nr][nc].soldiers -= monarchs[nr][nc].soldiers / 2;
    			continue;
    		}
    		
    		if(monarchs[nr][nc].union == mb.union) {
    			defender += monarchs[nr][nc].soldiers / 2;
    			monarchs[nr][nc].soldiers -= monarchs[nr][nc].soldiers / 2;
    			continue;
    		}
    	}
    	
    	if(!isAttack) return -2;
    	
    	if(attacker > defender) {
    		unions.get(mb.union).enemies.add(ma.union);
    		unions.get(ma.union).enemies.add(mb.union);
    		mb.union = ma.union;
    		mb.name = char2String(mGeneral);
    		mb.soldiers = attacker - defender;
    		return 1;
    	}
    	
		unions.get(mb.union).enemies.add(ma.union);
		unions.get(ma.union).enemies.add(mb.union);
		mb.soldiers = defender - attacker;
    	return 0;
    }
    
    int recruit(char mMonarch[], int mNum, int mOption) {
    	Monarch m = search(mMonarch);
    	if(mOption == 0) return m.soldiers += mNum;
    	int result = 0;
    	for(Monarch mo : monarchList) {
    		if(mo.union == m.union) {
    			mo.soldiers += mNum;
    			result += mo.soldiers;
    		}
    	}
    	return result;
    }
}
