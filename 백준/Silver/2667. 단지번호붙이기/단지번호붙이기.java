import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] checked;
    static int N, answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N)
                continue;

            if (!checked[tmpX][tmpY] && map[tmpX][tmpY] == 1) {
                checked[tmpX][tmpY] = true;
                answer++;
                dfs(tmpX, tmpY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        checked = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !checked[i][j]) {
                    checked[i][j] = true;
                    answer++;
                    dfs(i, j);

                    list.add(answer);
                    answer = 0;
                }
            }
        }

        sb.append(list.size()).append("\n");
        Collections.sort(list);
        for(int i : list)
            sb.append(i).append("\n");

        System.out.print(sb);
    }
}