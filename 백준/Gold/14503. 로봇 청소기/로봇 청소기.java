import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] room;
    static int N, M;
    static int cleanedBlock = 0;

    public static void dfs(int r, int c, int d) {
        for(int i = 0; i < 4; i++){
            d = d == 0 ? 3 : d - 1;

            if (d == 0 && r - 1 >= 0 && r - 1 < N && room[r - 1][c] == 0) {
                room[r - 1][c] = -1;
                cleanedBlock += 1;
                dfs(r - 1, c, d);
                return;
            }

            if (d == 1 && c + 1 >= 0 && c + 1 < M && room[r][c + 1] == 0) {
                room[r][c + 1] = -1;
                cleanedBlock += 1;
                dfs(r, c + 1, d);
                return;
            }

            if (d == 2 && r + 1 >= 0 && r + 1 < N && room[r + 1][c] == 0) {
                room[r + 1][c] = -1;
                cleanedBlock += 1;
                dfs(r + 1, c, d);
                return;
            }

            if (d == 3 && c - 1 >= 0 && c - 1 < M && room[r][c - 1] == 0) {
                room[r][c - 1] = -1;
                cleanedBlock += 1;
                dfs(r, c - 1, d);
                return;
            }
        }

        if (d == 0 && r + 1 >= 0 && r + 1 < N && room[r + 1][c] != 1)
            dfs(r + 1, c, d);

        if (d == 1 && c - 1 >= 0 && c - 1 < M && room[r][c - 1] != 1)
            dfs(r, c - 1, d);

        if (d == 2 && r - 1 >= 0 && r - 1 < N && room[r - 1][c] != 1)
            dfs(r - 1, c, d);

        if (d == 3 && c + 1 >= 0 && c + 1 < M && room[r][c + 1] != 1)
            dfs(r, c + 1, d);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 방의 가로 크기
        M = Integer.parseInt(st.nextToken()); // 방의 세로 크기
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 로봇 청소기의 row 좌표
        int c = Integer.parseInt(st.nextToken()); // 로봇 청소기의 column 좌표
        int d = Integer.parseInt(st.nextToken()); // 로봇 청소기의 direction

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                room[i][j] = Integer.parseInt(st.nextToken());
        }

        cleanedBlock += 1;
        room[r][c] = -1;
        dfs(r, c, d);
        System.out.print(cleanedBlock);
    }
}