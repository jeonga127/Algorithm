import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] sandX = {
            {1, -1, 2, -2, -1, 1, -1, 1, 0, 0}, // ←
            {0, 0, 0, 0, -1, -1, 1, 1, 2, 1}, // ↓
            {1, -1, 2, -2, 1, -1, 1, -1, 0, 0}, // →
            {0, 0, 0, 0, 1, 1, -1, -1, -2, -1}}; // ↑
    static int[][] sandY = {
            {0, 0, 0, 0, 1, 1, -1, -1, -2, -1}, // ←
            {1, -1, 2, -2, 1, -1, 1, -1, 0, 0}, // ↓
            {0, 0, 0, 0, -1, -1, 1, 1, 2, 1}, // →
            {1, -1, 2, -2, -1, 1, -1, 1, 0, 0}}; // ↑
    static int[] rate = {7, 7, 2, 2, 1, 1, 10, 10, 5, 0};
    static int N, answer;

    static void calSand(int nowX, int nowY, int direction) {
        if (map[nowX][nowY] == 0)
            return;

        int totalSand = map[nowX][nowY];
        int restSand = map[nowX][nowY];
        map[nowX][nowY] = 0;

        for (int i = 0; i < 10; i++) {
            int tmpX = nowX + sandX[direction][i];
            int tmpY = nowY + sandY[direction][i];
            int nowSand = i == 9 ? restSand : (int) (totalSand * rate[i] * 0.01);

            if (nowSand == 0)
                continue;

            restSand -= nowSand;

            if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N)
                answer += nowSand;
            else map[tmpX][tmpY] += nowSand;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int nowX = N / 2;
        int nowY = N / 2;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for (int i = 0; i < N; i++) {
            int direction = i % 2 == 1 ? 2 : 0; // ← : 0, ↓ : 1, → : 2, ↑ : 3

            for (int j = 0; j < 2; j++, direction++) {
                for (int k = 0; k < i + 1; k++) {
                    nowX = nowX + dx[direction];
                    nowY = nowY + dy[direction];

                    calSand(nowX, nowY, direction);
                    
                    if (nowX == 0 && nowY == 0) {
                        System.out.print(answer);
                        return;
                    }
                }
            }
        }
    }
}