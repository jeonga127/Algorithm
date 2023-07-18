import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Light {
    int x;
    int y;
    int energy;

    Light(int x, int y, int energy) {
        this.x = x;
        this.y = y;
        this.energy = energy;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int W = Integer.parseInt(st.nextToken()); // 맵의 가로 길이
        int H = Integer.parseInt(st.nextToken()); // 맵의 세로 길이
        int[][] map = new int[H][W];
        int[][] light = new int[H][W];

        Queue<Light> queue = new LinkedList<>();
        List<Point> lampList = new ArrayList<>();

        final int DUST = 1;
        final int BLOCK = 2;
        final int LAMP = 3;

        int N = Integer.parseInt(br.readLine()); // 화로 블록의 개수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String blockType = st.nextToken();
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            switch (blockType) {
                case "redstone_dust":
                    map[x][y] = DUST;
                    break;
                case "redstone_block":
                    map[x][y] = BLOCK;
                    queue.add(new Light(x, y, 16));
                    break;
                case "redstone_lamp":
                    map[x][y] = LAMP;
                    lampList.add(new Point(x, y));
                    break;
            }
        }

        while (!queue.isEmpty()) {
            Light target = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tmpX = target.x + dx[i];
                int tmpY = target.y + dy[i];

                if (tmpX < 0 || tmpX >= H || tmpY < 0 || tmpY >= W)
                    continue;

                if (target.energy - 1 > 0 && map[tmpX][tmpY] % 2 == 1 && target.energy - 1 > light[tmpX][tmpY]) {
                    light[tmpX][tmpY] = target.energy - 1;
                    queue.add(new Light(tmpX, tmpY, target.energy - 1));
                }
            }
        }

        Point firstLamp = lampList.get(0);
        int standard = light[firstLamp.x][firstLamp.y] % 2;

        for(int i = 0; i < lampList.size(); i++){
            Point lamp = lampList.get(i);
            if(light[lamp.x][lamp.y] == 0 || (light[lamp.x][lamp.y] % 2) != standard){
                System.out.print("failed");
                return;
            }
        }

        System.out.print("success");
    }
}