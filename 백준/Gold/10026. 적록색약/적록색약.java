import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static char[][] grid;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Character, Integer> areaNum = new HashMap<>();
    static int rgArea = 0;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < N; j++)
                grid[i][j] = tmp.charAt(j);
        }

        areaNum.put('R', 0);
        areaNum.put('G', 0);
        areaNum.put('B', 0);

        bfs(false);
        sb.append(areaNum.get('R') + areaNum.get('G') + areaNum.get('B')).append(" ");

        areaNum.put('R', 0);
        areaNum.put('G', 0);
        areaNum.put('B', 0);

        bfs(true);
        sb.append(areaNum.get('R') + areaNum.get('G') + areaNum.get('B'));
        System.out.print(sb);
    }

    public static void bfs(boolean rgWeak) {
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    char saveCharacter = grid[i][j];
                    visited[i][j] = true;

                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));

                    while (!queue.isEmpty()) {
                        Point target = queue.poll();

                        for (int p = 0; p < 4; p++) {
                            int tmpX = target.x + dx[p];
                            int tmpY = target.y + dy[p];

                            if (tmpX >= N || tmpY >= N || tmpX < 0 || tmpY < 0)
                                continue;

                            if (visited[tmpX][tmpY])
                                continue;

                            if (rgWeak && ((saveCharacter == 'G' && grid[tmpX][tmpY] == 'R') || (saveCharacter == 'R' && grid[tmpX][tmpY] == 'G'))) {
                                grid[tmpX][tmpY] = saveCharacter;
                            }

                            if (grid[tmpX][tmpY] == saveCharacter) {
                                visited[tmpX][tmpY] = true;
                                queue.add(new Point(tmpX, tmpY));
                            }
                        }
                    }

                    areaNum.put(saveCharacter, areaNum.get(saveCharacter) + 1);
                }
            }
        }
    }
}