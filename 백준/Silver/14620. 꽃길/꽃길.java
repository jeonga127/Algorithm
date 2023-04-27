import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static int minPrice = Integer.MAX_VALUE;
    static int N;

    public static void dfs(int count) {
        if (count == 3) {
            minPrice = Math.min(minPrice, calPrice());
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (!visit[i - 1][j] && !visit[i + 1][j] && !visit[i][j] && !visit[i][j - 1] && !visit[i][j + 1]) {

                    for (int p = 0; p < 5; p++)
                        visit[i + dx[p]][j + dy[p]] = true;

                    dfs(count + 1);

                    for (int p = 0; p < 5; p++)
                        visit[i + dx[p]][j + dy[p]] = false;
                }
            }
        }
    }

    public static int calPrice() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                result += visit[i][j] ? map[i][j] : 0;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < tmp.length; j++)
                map[i][j] = Integer.parseInt(tmp[j]);
        }

        dfs(0);

        System.out.println(minPrice);
    }
}
