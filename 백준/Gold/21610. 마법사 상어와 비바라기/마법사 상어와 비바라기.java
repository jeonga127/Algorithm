import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static List<Point> clouds;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx2 = {-1, -1, 1, 1};
    static int[] dy2 = {-1, 1, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 지도의 크기
        int M = Integer.parseInt(st.nextToken()); // 명령어 개수

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        clouds = new ArrayList<>(Arrays.asList(
                new Point(N - 2, 0),
                new Point(N - 2, 1),
                new Point(N - 1, 0),
                new Point(N - 1, 1)));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            visited = new boolean[N][N];

            for(Point cloud : clouds){
                cloud.x = cloud.x + dx[direction] * num;
                cloud.y = cloud.y + dy[direction] * num;

                while (cloud.x < 0 || cloud.x >= N || cloud.y < 0 || cloud.y >= N) {
                    if (cloud.x < 0 || cloud.x >= N) cloud.x = cloud.x < 0 ? cloud.x + N : cloud.x - N;
                    if (cloud.y < 0 || cloud.y >= N) cloud.y = cloud.y < 0 ? cloud.y + N : cloud.y - N;
                }

                map[cloud.x][cloud.y] += 1;
                visited[cloud.x][cloud.y] = true;
            }

            for(Point cloud : clouds){
                for (int j = 0; j < 4; j++) {
                    int tmpX = cloud.x + dx2[j];
                    int tmpY = cloud.y + dy2[j];

                    if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N)
                        continue;

                    if (map[tmpX][tmpY] > 0)
                        map[cloud.x][cloud.y] += 1;
                }
            }

            clouds.clear();

            for (int p = 0; p < N; p++) {
                for (int q = 0; q < N; q++) {
                    if (!visited[p][q] && map[p][q] >= 2) {
                        map[p][q] -= 2;
                        clouds.add(new Point(p, q));
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                answer += map[i][j];
        }

        System.out.print(answer);
    }
}