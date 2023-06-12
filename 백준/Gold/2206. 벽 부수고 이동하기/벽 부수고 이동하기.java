import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Block implements Comparable<Block>{
    int x;
    int y;
    int dist;
    boolean isBroken;

    Block(int x, int y, int dist, boolean isBroken) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.isBroken = isBroken;
    }
    
    @Override
    public int compareTo(Block o) {
        return Integer.compare(this.dist, o.dist);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[][][] visited = new boolean[N][M][2];
        int[][] map = new int[N][M];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        PriorityQueue<Block> queue = new PriorityQueue<>();
        queue.add(new Block(0, 0, 1, false));
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        while (!queue.isEmpty()) {
            Block target = queue.poll();
            
            if (target.x == N - 1 && target.y == M - 1) {
                System.out.print(target.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int tmpX = target.x + dx[i];
                int tmpY = target.y + dy[i];

                if (tmpX < 0 || tmpY < 0 || tmpX >= N || tmpY >= M || visited[tmpX][tmpY][target.isBroken? 1 : 0])
                    continue;

                visited[tmpX][tmpY][target.isBroken? 1 : 0] = true;

                if (map[tmpX][tmpY] == 0)
                    queue.add(new Block(tmpX, tmpY, target.dist + 1, target.isBroken));
                else if (!target.isBroken)
                    queue.add(new Block(tmpX, tmpY, target.dist + 1, true));
            }
        }
        System.out.print(-1);
    }
}