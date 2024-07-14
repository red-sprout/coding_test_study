package src.week1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S10773 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> q = new Stack<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(bf.readLine()); //반복 횟수
        int result = 0; //최종 결과값
        for(int i =0 ; i < k ; i++){

            int n = Integer.parseInt(bf.readLine());
            
            if(n!=0){
                q.add(n);
                result += n;
            }else {
                result -= q.pop(); // 반환과 동시에 연산
            }
        }
        System.out.println(result);
    }
}