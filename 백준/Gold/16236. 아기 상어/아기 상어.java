import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Fish implements Comparable<Fish> {
    int x;
    int y;
    int depth;

    Fish(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    @Override
    public int compareTo(Fish fish) {
        if (this.depth != fish.depth) return Integer.compare(this.depth, fish.depth);
        else if (this.x != fish.x) return Integer.compare(this.x, fish.x);
        else return Integer.compare(this.y, fish.y);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 공간의 크기
        int[][] map = new int[N][N];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int sharkX = 0;
        int sharkY = 0;
        int sharkEat = 0;
        int sharkStrength = 2;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        int times = 0;

        while (true) {
            List<Fish> fishes = new ArrayList<>();
            Queue<Fish> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];

            queue.add(new Fish(sharkX, sharkY, 0));
            map[sharkX][sharkY] = 0;
            visited[sharkX][sharkY] = true;

            while (!queue.isEmpty()) {
                Fish target = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int tmpX = target.x + dx[i];
                    int tmpY = target.y + dy[i];

                    if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N)
                        continue;

                    Fish newMove = new Fish(tmpX, tmpY, target.depth + 1);

                    if (!visited[tmpX][tmpY] && map[tmpX][tmpY] <= sharkStrength) {
                        visited[tmpX][tmpY] = true;
                        queue.add(newMove);
                    }

                    if (map[tmpX][tmpY] > 0 && map[tmpX][tmpY] < sharkStrength)
                        fishes.add(newMove);
                }
            }

            if (fishes.isEmpty()) break;

            Collections.sort(fishes);
            Fish catchedFish = fishes.get(0);

            map[catchedFish.x][catchedFish.y] = 0;
            sharkX = catchedFish.x;
            sharkY = catchedFish.y;

            times += catchedFish.depth;

            sharkEat += 1;
            if (sharkEat == sharkStrength) {
                sharkStrength += 1;
                sharkEat = 0;
            }
        }

        System.out.print(times);
    }
}