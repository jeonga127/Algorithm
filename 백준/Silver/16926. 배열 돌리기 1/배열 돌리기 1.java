import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 가로 크기
        int R = Integer.parseInt(st.nextToken()); // 회전 횟수

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int standard = 0; standard < Math.min(N, M) / 2; standard++) {
            int wLimit = M - standard - 1;
            int hLimit = N - standard - 1;
            int realR = R % (2 * (wLimit + hLimit - 2 * standard));

            while (--realR >= 0) {
                int tmp = map[standard][standard];

                for (int i = standard; i < wLimit; i++) // ←
                    map[standard][i] = map[standard][i + 1];

                for (int i = standard; i < hLimit; i++) // ↑
                    map[i][wLimit] = map[i + 1][wLimit];

                for (int i = wLimit; i > standard; i--) // →
                    map[hLimit][i] = map[hLimit][i - 1];

                for (int i = hLimit; i > standard; i--) // ↓
                    map[i][standard] = map[i - 1][standard];

                map[standard + 1][standard] = tmp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sb.append(map[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}