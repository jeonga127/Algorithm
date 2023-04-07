import java.util.*;

public class Main {
    static int [][] map;
    static int [][] check;
    static int N;
    static int M;
    public static void dfs(int x, int y){
        check[x][y] = -3;

        int[] dx = { 1, 0, -1, 0};
        int[] dy = { 0, -1, 0, 1};

        for(int i = 0; i < 4; i++){
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M)
                continue;
            if(map[tmpX][tmpY] == 1 && check[tmpX][tmpY] == -1)
                dfs(tmpX, tmpY);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < testcase; i++){
            N = sc.nextInt();
            M = sc.nextInt();
            int K = sc.nextInt();

            map = new int[N][M];
            check = new int[N][M];

            for(int j = 0; j < K; j++) {
                int x_cord = sc.nextInt();
                int y_cord = sc.nextInt();
                map[x_cord][y_cord] = 1;
                check[x_cord][y_cord] = -1; // 아직 체크하지 않음
            }

            int cnt = 0;

            for(int p = 0; p < N; p++) {
                for (int q = 0; q < M; q++) {
                    if (map[p][q] == 1 && check[p][q] == -1) {
                        dfs(p, q);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
