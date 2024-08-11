package com.practice.pro15638;

import java.util.*;

class UserSolution {
	class Monarch {
		int soldier;
		char[] name;
		Set<Integer> allies;
		Set<Integer> enemies;
		
		Monarch(int soldier, char[] name) {
			this.soldier = soldier;
			this.name = name;
			this.allies = new HashSet<>();
			this.enemies = new HashSet<>();
		}
	}
	
	int N;
	Monarch[] monarchList;
	Exception exception = new Exception();
	int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
    void init(int N, int mSoldier[][], char mMonarch[][][]) {
    	this.N = N;
    	this.monarchList = new Monarch[N * N];
    	int idx = 0;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			monarchList[idx++] = new Monarch(mSoldier[i][j], mMonarch[i][j]);
    		}
    	}
    }
    
    void destroy() {
    	
    }
    
    int getIdx(char mMonarch[]) {
    	for(int i = 0; i < monarchList.length; i++) {
    		try {
    			isSameMonarch(mMonarch, monarchList[i].name);
    			return i;
    		} catch(Exception e) {}
    	}
    	return -1;
    }
    
    void isSameMonarch(char mMonarchA[], char mMonarchB[]) throws Exception {
    	for(int i = 0; i < mMonarchA.length; i++) {
			if(mMonarchA[i] != mMonarchB[i]) throw exception;
			if(mMonarchA[i] == '\0') break;
		}
    }
    
    void clear(int idx) {
    	monarchList[idx].allies.clear();
    	monarchList[idx].enemies.clear();
    	for(int i = 0; i < monarchList.length; i++) {
    		if(i == idx) continue;
    		Monarch m = monarchList[i];
    		m.allies.remove(idx);
    		m.enemies.remove(idx);
    	}
    }
    
    int ally(char mMonarchA[], char mMonarchB[]) {
    	int idxA = getIdx(mMonarchA);
    	int idxB = getIdx(mMonarchB);
    	System.out.println(idxA + " " + idxB);
    	return ally(idxA, idxB);
    }
    
    int ally(int idxA, int idxB) {
    	Monarch mA = monarchList[idxA];
    	Monarch mB = monarchList[idxB];
    	
    	if(idxA == idxB) return -1;
    	if(mA.allies.contains(idxB)) return -1;
    	
    	for(int iA : mA.allies) if(mB.enemies.contains(iA)) return -2;
    	for(int iB : mB.allies) if(mA.enemies.contains(iB)) return -2;
    	
    	for(int iA : mA.allies) mB.allies.add(iA);
    	for(int iA : mA.enemies) mB.enemies.add(iA);
    	for(int iB : mB.allies) mA.allies.add(iB);
    	for(int iB : mB.enemies) mA.enemies.add(iB);
    	
    	mA.allies.add(idxB);
    	mB.allies.add(idxA);
    	
        return 1;
    }
    
    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[]) {
    	int idxA = getIdx(mMonarchA);
    	int idxB = getIdx(mMonarchB);
    	Monarch mA = monarchList[idxA];
    	Monarch mB = monarchList[idxB];
    	
    	int row = idxB / N;
    	int col = idxB % N;
    	int attacker = 0;
    	int defender = mB.soldier;
    	for(int i = 0; i < 8; i++) {
    		int nr = row + dr[i];
    		int nc = col + dc[i];
    		if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
    		int idx = nr * N + nc;
    		if(mA.allies.contains(idx)) {
    			int a = monarchList[idx].soldier / 2;
    			monarchList[idx].soldier -= a;
    			attacker += a;
    		}
    		if(mB.allies.contains(idx)) {
    			int d = monarchList[idx].soldier / 2;
    			monarchList[idx].soldier -= d;
    			defender += d;
    		}
    	}
    	
    	if(attacker > defender) {
    		System.out.println(1);
    		Set<Integer> enemies = monarchList[idxB].allies;
    		clear(idxB);
    		monarchList[idxB].name = mGeneral;
    		monarchList[idxB].soldier = attacker - defender;
    		for(int idx : enemies) monarchList[idxB].enemies.add(idx);
    		ally(idxA, idxB);
    		return 1;
    	} else {
    		System.out.println(0);
        	mA.enemies.add(idxB);
        	mB.enemies.add(idxA);
        	for(int iA : mA.allies) mB.enemies.add(iA);
        	for(int iB : mB.allies) mA.enemies.add(iB);
    		mB.soldier = defender - attacker;
    		return 0;
    	}
    }
    
    int recruit(char mMonarch[], int mNum, int mOption) {
    	int idx = getIdx(mMonarch);
    	Monarch m = monarchList[idx];
    	m.soldier += mNum;
        if(mOption == 1) {
        	int sum = m.soldier;
        	for(int i : m.allies) {
        		monarchList[i].soldier += mNum;
        		sum += monarchList[i].soldier;
        	}
        	System.out.println(sum);
        	return sum;
        } else {
        	System.out.println(m.soldier);
        	return m.soldier;
        }
    }
}
