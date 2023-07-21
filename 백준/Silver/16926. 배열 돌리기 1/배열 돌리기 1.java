import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 가로 크기
        int R = Integer.parseInt(st.nextToken()); // 회전 횟수

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        while (--R >= 0) {
            int[][] answer = new int[N][M];
            for (int standard = 0; standard < Math.min(N, M) / 2; standard++) {
                int wLimit = M - standard - 1;
                int hLimit = N - standard - 1;

                for (int i = standard + 1; i <= wLimit; i++) // ←
                    answer[standard][i - 1] = map[standard][i];

                for (int i = standard + 1; i <= hLimit; i++) // ↑
                    answer[i - 1][wLimit] = map[i][wLimit];

                for (int i = standard; i < wLimit; i++) // →
                    answer[hLimit][i + 1] = map[hLimit][i];

                for (int i = standard; i < hLimit; i++) // ↓
                    answer[i + 1][standard] = map[i][standard];
            }
            map = answer;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
}