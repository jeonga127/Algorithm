import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordinate {
    int h;
    int n;
    int m;

    Coordinate(int h, int n, int m) {
        this.h = h;
        this.n = n;
        this.m = m;
    }
}

public class Main {
    static int[][][] tomatoes;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int H, M, N;

    //정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
    public static int bfs() {
        Queue<Coordinate> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoes[h][n][m] == 1 && !visited[h][n][m]) {
                        visited[h][n][m] = true;
                        queue.add(new Coordinate(h, n, m));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Coordinate target = queue.poll();

            for (int i = 0; i < 6; i++) {
                int tmpH = target.h + dz[i];
                int tmpN = target.n + dx[i];
                int tmpM = target.m + dy[i];

                if (tmpH < 0 || tmpN < 0 || tmpM < 0 || tmpH >= H || tmpN >= N || tmpM >= M)
                    continue;

                if (tomatoes[tmpH][tmpN][tmpM] != -1 && !visited[tmpH][tmpN][tmpM]) {
                    visited[tmpH][tmpN][tmpM] = true;
                    tomatoes[tmpH][tmpN][tmpM] = tomatoes[target.h][target.n][target.m] + 1;
                    queue.add(new Coordinate(tmpH, tmpN, tmpM));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoes[h][n][m] == 0)
                        return -1;
                    max = Math.max(max, tomatoes[h][n][m]);
                }
            }
        }

        return max-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++)
                   tomatoes[h][n][m] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.print(bfs());
    }
}