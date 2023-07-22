import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Fireball {
    int weight;
    int speed;
    int direction;

    Fireball(int weight, int speed, int direction) {
        this.weight = weight;
        this.speed = speed;
        this.direction = direction;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        int N = Integer.parseInt(st.nextToken()); // 격자의 크기
        int M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
        int K = Integer.parseInt(st.nextToken()); // 이동의 횟수

        Queue<Point> fireballs = new LinkedList<>();
        Queue<Fireball>[][] map = new LinkedList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1; // 파이어볼의 row
            int c = Integer.parseInt(st.nextToken()) - 1; // 파이어볼의 col
            int m = Integer.parseInt(st.nextToken()); // 파이어볼의 질량
            int s = Integer.parseInt(st.nextToken()); // 파이어볼의 속력
            int d = Integer.parseInt(st.nextToken()); // 파이어볼의 방향

            map[r][c].add(new Fireball(m, s, d));
            fireballs.add(new Point(r, c));
        }

        while (--K >= 0) {
            // 0. 새로운 map, 새로운 list
            Queue<Point> newFireballs = new LinkedList<>();
            Queue<Point> nextFireballs = new LinkedList<>();
            Queue<Fireball>[][] newMap = new LinkedList[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    newMap[i][j] = new LinkedList<>();
            }

            // 1. 모든 파이어볼이 자신의 방향 d로 s만큼 이동
            while (!fireballs.isEmpty()) {
                Point point = fireballs.poll();
                Queue<Fireball> targetList = map[point.x][point.y];

                while (!targetList.isEmpty()) {
                    Fireball target = targetList.poll();

                    int nextX = point.x + dx[target.direction] * (target.speed % N);
                    int nextY = point.y + dy[target.direction] * (target.speed % N);

                    while (nextX < 0 || nextX >= N)
                        nextX = nextX < 0 ? nextX + N : nextX - N;

                    while (nextY < 0 || nextY >= N)
                        nextY = nextY < 0 ? nextY + N : nextY - N;

                    newMap[nextX][nextY].add(target);
                    newFireballs.add(new Point(nextX, nextY));
                }
            }

            boolean[][] visited = new boolean[N][N];

            // 2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸의 파이어볼은 모두 하나로 합쳐진다.
            while (!newFireballs.isEmpty()) {
                Point point = newFireballs.poll();

                if (visited[point.x][point.y])
                    continue;

                visited[point.x][point.y] = true;

                if (newMap[point.x][point.y].size() >= 2) {
                    Fireball standard = newMap[point.x][point.y].poll();

                    int sumM = standard.weight; // 질량
                    int sumS = standard.speed; // 속력
                    int standardD = standard.direction % 2; // 방향
                    int totalSize = newMap[point.x][point.y].size() + 1;
                    boolean totalD = true;

                    while (!newMap[point.x][point.y].isEmpty()) {
                        Fireball target = newMap[point.x][point.y].poll();

                        sumM += target.weight;
                        sumS += target.speed;

                        if (target.direction % 2 != standardD)
                            totalD = false;
                    }

                    int totalM = sumM / 5;
                    int totalS = sumS / totalSize;

                    if (totalM > 0) {
                        for (int i = 0; i <= 6; i += 2) {
                            newMap[point.x][point.y].add(new Fireball(totalM, totalS, i + (totalD ? 0 : 1)));
                            nextFireballs.add(new Point(point));
                        }
                    }
                } else nextFireballs.add(new Point(point));
            }

            map = newMap;
            fireballs = nextFireballs;
        }

        int answer = 0;

        while (!fireballs.isEmpty()) {
            Point point = fireballs.poll();

            while (!map[point.x][point.y].isEmpty()) {
                Fireball target = map[point.x][point.y].poll();
                answer += target.weight;
            }
        }

        System.out.print(answer);
    }
}