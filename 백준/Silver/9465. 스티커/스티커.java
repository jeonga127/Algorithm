import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 스티커의 row 정보
            int[][] sticker = new int[2][N];
            int[][] score = new int[2][N + 1];

            for (int p = 0; p < 2; p++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int q = 0; q < N; q++)
                    sticker[p][q] = Integer.parseInt(st.nextToken());
            }

            score[0][1] = sticker[0][0];
            score[1][1] = sticker[1][0];

            // 각각의 스티커는 두 가지 선택지를 가짐
            // 1. 바로 대각선에 위치한 스티커으로부터 선택받거나 (sticker[(p + 1) % 2][q - 1])
            // 2. 그 전 대각선에 위치한 스티커를 선택받거나 (sticker[(p + 1) % 2][q - 2])
            // => 그 중 더 큰 점수를 갖는 스티커를 고르면 되는 문제!

            for (int q = 2; q < N + 1; q++) {
                for (int p = 0; p < 2; p++) {
                    score[p][q] = Math.max(score[(p + 1) % 2][q - 2], score[(p + 1) % 2][q - 1]) + sticker[p][q-1];
                }
            }

            sb.append(Math.max(score[0][N], score[1][N])).append("\n");
        }
        System.out.print(sb);
    }
}
