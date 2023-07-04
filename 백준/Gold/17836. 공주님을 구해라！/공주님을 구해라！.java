import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Step implements Comparable<Step> {
    int x;
    int y;
    int depth;
    boolean hasSword;

    Step(int x, int y, int depth, boolean hasSword) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.hasSword = hasSword;
    }

    @Override
    public int compareTo(Step o) {
        return Integer.compare(this.depth, o.depth);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 성의 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 성의 가로 크기
        int T = Integer.parseInt(st.nextToken()); // 저주의 제한 시간

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        boolean[][] visitedSwords = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Step> queue = new PriorityQueue<>();
        queue.add(new Step(0, 0, 0, false));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Step target = queue.poll();

            if (target.depth > T) {
                System.out.print("Fail");
                return;
            }

            if (target.x == N - 1 && target.y == M - 1) {
                System.out.print(target.depth);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int tmpX = target.x + dx[i];
                int tmpY = target.y + dy[i];

                if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M || (!target.hasSword && map[tmpX][tmpY] == 1))
                    continue;

                if (target.hasSword && !visitedSwords[tmpX][tmpY]) {
                    queue.add(new Step(tmpX, tmpY, target.depth + 1, true));
                    visitedSwords[tmpX][tmpY] = true;
                }

                if (!target.hasSword && !visited[tmpX][tmpY]) {
                    if(map[tmpX][tmpY] == 0)
                        queue.add(new Step(tmpX, tmpY, target.depth + 1, false));

                    if(map[tmpX][tmpY] == 2)
                        queue.add(new Step(tmpX, tmpY, target.depth + 1, true));

                    visited[tmpX][tmpY] = true;
                }
            }
        }
        System.out.print("Fail");
    }
}