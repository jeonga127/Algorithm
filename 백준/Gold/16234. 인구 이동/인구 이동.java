import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, L, R;

    public static boolean bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;

        List<Point> unions = new ArrayList<>();
        int unionNum = 0;
        int unionPeopleNum = 0;

        while (!queue.isEmpty()) {
            Point target = queue.poll();

            unions.add(target);
            unionNum += 1;
            unionPeopleNum += map[target.x][target.y];

            for (int i = 0; i < 4; i++) {
                int tmpX = target.x + dx[i];
                int tmpY = target.y + dy[i];

                if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N)
                    continue;

                int diff = Math.abs(map[target.x][target.y] - map[tmpX][tmpY]);

                if (!visited[tmpX][tmpY] && diff >= L && diff <= R) {
                    visited[tmpX][tmpY] = true;
                    queue.add(new Point(tmpX, tmpY));
                }
            }
        }

        if(unions.size() > 1){
            for (Point union : unions)
                map[union.x][union.y] = unionPeopleNum / unionNum;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 땅의 크기
        L = Integer.parseInt(st.nextToken()); // 최소 인구
        R = Integer.parseInt(st.nextToken()); // 최대 인구

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int days = 0;

        while (true) {
            boolean bfsCheck = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if(bfs(i, j))
                            bfsCheck = true;
                    }
                }
            }

            if (!bfsCheck) break;
            days += 1;
        }

        System.out.print(days);
    }
}