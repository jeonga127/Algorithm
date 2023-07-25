import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 집의 크기

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][][] memo = new int[N][N][3];
        memo[0][1][0] = 1;

        for (int i = 2; i < N; i++)
            memo[0][i][0] = map[0][i] == 0 ? memo[0][i - 1][0] : 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0) {
                    memo[i][j][0] = memo[i][j - 1][0] + memo[i][j - 1][2];
                    memo[i][j][1] = memo[i - 1][j][1] + memo[i - 1][j][2];

                    if (map[i - 1][j] == 0 && map[i][j - 1] == 0)
                        memo[i][j][2] = memo[i - 1][j - 1][0] + memo[i - 1][j - 1][1] + memo[i - 1][j - 1][2];
                }
            }
        }

        System.out.print(memo[N - 1][N - 1][0] + memo[N - 1][N - 1][1] + memo[N - 1][N - 1][2]);
    }
}