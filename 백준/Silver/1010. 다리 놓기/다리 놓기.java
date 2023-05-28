import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 서쪽 사이트 개수
            int M = Integer.parseInt(st.nextToken()); // 동쪽 사이트 개수

            sb.append(combination(M, N)).append("\n");
        }
        System.out.print(sb);
    }

    public static int combination(int M, int N) { //mCn 계산
        if (dp[M][N] > 0) return dp[M][N];
        if (M == N || N == 0) return dp[M][N] = 1;
        if (N == 1) return dp[M][N] = M;
        return dp[M][N] = combination(M - 1, N - 1) + combination(M - 1, N);
    }
}