import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int maxSafe = Integer.MIN_VALUE;
    static int[][] map;
    static int N, M;

    public static void bfs() {
        boolean[][] visited = new boolean[N][M];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int countSafe = 0;

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0)
                    countSafe += 1;
                if (map[i][j] == 2) {
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point target = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tmpX = target.x + dx[i];
                int tmpY = target.y + dy[i];

                if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M)
                    continue;

                if(!visited[tmpX][tmpY] && map[tmpX][tmpY] == 0){
                    visited[tmpX][tmpY] = true;
                    queue.add(new Point(tmpX, tmpY));
                    countSafe -= 1;
                }
            }
        }

        maxSafe = Math.max(maxSafe, countSafe);
    }

    public static void buildWall(int depth){
        if(depth == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
        M = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        buildWall(0);
        System.out.print(maxSafe);
    }
}