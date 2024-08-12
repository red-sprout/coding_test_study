package com.example.bs;

import java.io.*;
import java.util.*;

public class LIS {
    static int n;
    static int[] arr;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list.add(arr[0]);
        br.close();
        for (int i = 1; i < n; i++) {
            int ele = arr[i];
            if (list.get(list.size() - 1) < ele) {
                list.add(ele);
            } else {
                int searchedIdx = lowerBound(ele);
                list.set(searchedIdx, ele);
            }
        }

        System.out.println(list.size());
        br.close();
    }

    public static int lowerBound(int target) {
        int start = 0;
        int end = list.size();
        int answer = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < target) {
            	start = mid + 1;
            } else {
            	answer = mid;
            	end = mid - 1;
            }
        }
        return answer;
    }
}
