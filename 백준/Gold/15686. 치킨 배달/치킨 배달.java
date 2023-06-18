import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] open;
    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시의 크기
        int M = Integer.parseInt(st.nextToken()); // 치킨집 갯수
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) house.add(new Point(i, j));
                if (map[i][j] == 2) chicken.add(new Point(i, j));
            }
        }

        open = new boolean[chicken.size()];
        dfs(0, 0, M);
        System.out.print(minDistance);
    }

    public static void dfs(int idx, int depth, int goal) {
        if (depth == goal) {
            int distanceSum = 0;

            for (int i = 0; i < house.size(); i++) {
                Point targetHouse = house.get(i);
                int targetDistance = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        Point targetChicken = chicken.get(j);

                        int dist = Math.abs(targetHouse.x - targetChicken.x) + Math.abs(targetHouse.y - targetChicken.y);
                        targetDistance = Math.min(targetDistance, dist);
                    }
                }

                distanceSum += targetDistance;
            }

            minDistance = Math.min(minDistance, distanceSum);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, depth + 1, goal);
            open[i] = false;
        }
    }
}