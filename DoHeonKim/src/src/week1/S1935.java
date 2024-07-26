package src.week1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S1935 {
    public static void main(String[] args) throws IOException {
        Stack<Double> s = new Stack<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String str = bf.readLine();

        double[] dArr = new double[n];
        for(int i =0; i < dArr.length; i++){
            dArr[i] = Double.parseDouble(bf.readLine()); //배열세팅
        }

        for(int i = 0; i < str.length(); i++){
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z'){
                s.push(dArr[str.charAt(i) - 'A']); //아스키코드값 생각해서 빼버리기
            }else {
                if (!s.empty()) { //에러방지
                    double n1 = s.pop();
                    double n2 = s.pop();
                    switch (str.charAt(i)) {
                        case '-':
                            s.push(n2 - n1);
                            break;
                        case '+':
                            s.push(n2 + n1);
                            break;
                        case '/':
                            s.push(n2 / n1);
                            break;
                        case '*':
                            s.push(n2 * n1);
                            break;
                    }
                }
            }
        }
        System.out.printf("%.2f", s.pop()); //소수점 2
    }
}
