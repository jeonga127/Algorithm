import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Block {
        int x, y, dist, crushedNum;

        Block(int x, int y, int dist, int crushedNum) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.crushedNum = crushedNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = tmp.charAt(j) - '0';
        }

        PriorityQueue<Block> queue = new PriorityQueue<>(Comparator.comparingInt(block -> block.dist));
        queue.add(new Block(0, 0, 1, 0));

        boolean[][][] visited = new boolean[K + 1][N][M];
        for (int k = 0; k < K + 1; k++)
            visited[k][0][0] = true;

        while (!queue.isEmpty()) {
            Block target = queue.poll();

            if (target.x == N - 1 && target.y == M - 1) {
                System.out.print(target.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int tmpX = target.x + dx[i];
                int tmpY = target.y + dy[i];

                if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M || visited[target.crushedNum][tmpX][tmpY])
                    continue;

                if (map[tmpX][tmpY] == 0) {
                    visited[target.crushedNum][tmpX][tmpY] = true;
                    queue.add(new Block(tmpX, tmpY, target.dist + 1, target.crushedNum));
                }
                else if (target.crushedNum < K && !visited[target.crushedNum + 1][tmpX][tmpY]) {
                    visited[target.crushedNum + 1][tmpX][tmpY] = true;
                    queue.add(new Block(tmpX, tmpY, target.dist + 1, target.crushedNum + 1));
                }
            }
        }

        System.out.print(-1);
    }
}