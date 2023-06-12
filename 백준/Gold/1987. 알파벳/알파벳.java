import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R, C;
    static int maxDistance = Integer.MIN_VALUE;

    public static void dfs(int currentX, int currentY, List<Character> list) {
        maxDistance = Math.max(list.size(), maxDistance);

        for (int i = 0; i < 4; i++) {
            int tmpX = currentX + dx[i];
            int tmpY = currentY + dy[i];

            if (tmpX < 0 || tmpX >= R || tmpY < 0 || tmpY >= C)
                continue;

            if (!list.contains(board[tmpX][tmpY])) {
                list.add(board[tmpX][tmpY]);
                dfs(tmpX, tmpY, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 세로 길이
        C = Integer.parseInt(st.nextToken()); // 가로 길이

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++)
                board[i][j] = tmp.charAt(j);
        }

        dfs(0, 0, new ArrayList<>(Arrays.asList(board[0][0])));
        System.out.print(maxDistance);
    }
}