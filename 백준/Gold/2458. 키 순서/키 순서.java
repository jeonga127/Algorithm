import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수

        int[][] dp = new int[N][N];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 작은 학생
            int b = Integer.parseInt(st.nextToken()); // 큰 학생

            dp[a - 1][b - 1] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) dp[i][j] = 0;
                    else if (dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            int tmp = 0;

            for (int j = 0; j < N; j++) {
                if (dp[i][j] != Integer.MAX_VALUE && dp[i][j] != 0)
                    tmp++;
            }

            for (int j = 0; j < N; j++) {
                if (dp[j][i] != Integer.MAX_VALUE && dp[j][i] != 0)
                    tmp++;
            }

            if (tmp == N - 1)
                count++;
        }
        System.out.print(count);
    }
}