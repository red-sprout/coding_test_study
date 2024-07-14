package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 행의 수
        int m = Integer.parseInt(st.nextToken()); // 열의 수
        int r = Integer.parseInt(st.nextToken()); // 회전 횟수
        
        int[][] matrix = new int[n][m]; // n x m 크기의 2차원 배열 생성
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        rotateMatrix(matrix, n, m, r);
        
        // StringBuilder를 이용하여 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void rotateMatrix(int[][] matrix, int n, int m, int r) {
        int layers = Math.min(n, m) / 2; // 회전해야 할 겹의 수

        for (int i = 0; i < layers; i++) {
            int layerHeight = n - 2 * 1;
            int layerWidth = m - 2 * 1;
            int numElements = 2 * (layerHeight + layerWidth - 2);
            int effectiveRotations = r % numElements;

            for (int rotation = 0; rotation < effectiveRotations; rotation++) {
                int temp = matrix[i][i]; // 첫 번째 요소를 임시로 저장

                // 왼쪽 열 위로 이동
                for (int j = i; j < n - i - 1; j++) {
                    matrix[j][i] = matrix[j + 1][i];
                }

                // 하단 행 왼쪽으로 이동
                for (int j = i; j < m - i - 1; j++) {
                    matrix[n - i - 1][j] = matrix[n - i - 1][j + 1];
                }

                // 오른쪽 열 아래로 이동
                for (int j = n - i - 1; j > i; j--) {
                    matrix[j][m - i - 1] = matrix[j - 1][m - i - 1];
                }

                // 상단 행 오른쪽으로 이동
                for (int j = m - i - 1; j > i + 1; j--) {
                    matrix[i][j] = matrix[i][j - 1];
                }

                matrix[i][i + 1] = temp;
            }
        }
    }
}

