package src.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10816_binarySearch {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // n 세팅
        int n = Integer.parseInt(bf.readLine());
        int[] sArr = new int[n];
        st = new StringTokenizer(bf.readLine());    
        
        for (int i = 0; i < n; i++) {
            sArr[i] = Integer.parseInt(st.nextToken());
        }
        
        // m 세팅
        int m = Integer.parseInt(bf.readLine());
        int[] checkArr = new int[m];
        st = new StringTokenizer(bf.readLine());
        
        for (int i = 0; i < m; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }
        
        QuickSort(sArr, 0, sArr.length - 1);
        
        print(binarySearch(sArr, checkArr));
    }
    
    public static int[] binarySearch(int[] sArr, int[] checkArr) {
        int[] countArr = new int[checkArr.length];
        
        for (int i = 0; i < checkArr.length; i++) {
            int target = checkArr[i];
            countArr[i] = countOccurrences(sArr, target);
        }
        
        return countArr;
    }
    
    public static int countOccurrences(int[] arr, int target) {
        int firstIndex = findFirst(arr, target);
        if (firstIndex == -1) {
            return 0;
        }
        int lastIndex = findLast(arr, target);
        return lastIndex - firstIndex + 1;
    }
    
    public static int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        if (left < arr.length && arr[left] == target) {
            return left;
        }
        return -1;
    }
    
    public static int findLast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (right >= 0 && arr[right] == target) {
            return right;
        }
        return -1;
    }
    
    //퀵정렬시작
    public static void QuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //피벗이라는 왼쪽, 오른쪽을 나눌 기준 선정
        int pivot = partition(arr, left, right);
        
        QuickSort(arr, left, pivot - 1);
        QuickSort(arr, pivot + 1, right);
    }
    //왼쪽파트 오른쪽파트 나눠서 정렬시작
    public static int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[right];
        
        while (lo < hi) {
            while (arr[lo] < pivot && lo < hi) {
                lo++;
            }
            
            while (arr[hi] >= pivot && lo < hi) {
                hi--;
            }
            swap(arr, lo, hi);
        }
        
        swap(arr, right, hi);
        
        return hi;
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
