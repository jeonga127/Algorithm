import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] openOrder;
    static int[][][] dp;

    public static int move(int depth, int left, int right) {
        if (depth >= openOrder.length) return 0;

        if (dp[depth][left][right] != -1) return dp[depth][left][right];
        if (dp[depth][right][left] != -1) return dp[depth][right][left];

        int nextMove = openOrder[depth];
        return dp[depth][left][right] = Math.min(
                Math.abs(left - nextMove) + move(depth + 1, nextMove, right),
                Math.abs(right - nextMove) + move(depth + 1, left, nextMove));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 벽장의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());

        int moveNum = Integer.parseInt(br.readLine());
        openOrder = new int[moveNum];

        for(int i = 0; i < moveNum; i++)
            openOrder[i] = Integer.parseInt(br.readLine()) - 1;

        dp = new int[moveNum][N][N];

        for (int i = 0; i < moveNum; i++) {
            for (int j = 0; j < N; j++)
                Arrays.fill(dp[i][j], -1);
        }

        System.out.print(move(0, left - 1, right - 1));
    }
}