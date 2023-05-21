import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] tomatoes;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    //정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
    public static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point target = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tmpX = target.x + dx[i];
                int tmpY = target.y + dy[i];

                if (tmpX < 0 || tmpY < 0 || tmpX >= N || tmpY >= M)
                    continue;

                if (!visited[tmpX][tmpY] && tomatoes[tmpX][tmpY] != -1) {
                    tomatoes[tmpX][tmpY] = tomatoes[target.x][target.y] + 1;
                    visited[tmpX][tmpY] = true;
                    queue.add(new Point(tmpX, tmpY));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
        }

        bfs();

        System.out.print(Arrays.stream(tomatoes).flatMapToInt(Arrays::stream).filter(x -> x == 0).count() == 0 ?
                Arrays.stream(tomatoes).flatMapToInt(Arrays::stream).max().getAsInt() - 1 : -1);
    }
}