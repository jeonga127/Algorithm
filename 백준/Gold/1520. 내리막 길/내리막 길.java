import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int[][] path;
    static int M, N;

    public static int dfs(int startX, int startY) {
        if (startX == M - 1 && startY == N - 1)
            return 1;

        if(path[startX][startY] > -1)
            return path[startX][startY];

        path[startX][startY] = 0;

        for (int i = 0; i < 4; i++) {
            int tmpX = startX + dx[i];
            int tmpY = startY + dy[i];

            if (tmpX < 0 || tmpX >= M || tmpY < 0 || tmpY >= N)
                continue;

            if (map[startX][startY] > map[tmpX][tmpY]) {
                path[startX][startY] += dfs(tmpX, tmpY);
            }
        }

        return path[startX][startY];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        path = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                path[i][j] = -1;
            }
        }

        System.out.print(dfs(0, 0));
    }
}