import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 표의 크기
        int M = Integer.parseInt(st.nextToken()); // 합을 구하는 횟수
        int[][] table = new int[N][N];
        int[][] sum = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                table[i][j] = Integer.parseInt(st.nextToken());
        }

        sum[0][0] = table[0][0];

        for (int i = 1; i < N; i++) {
            sum[i][0] = sum[i - 1][0] + table[i][0];
            sum[0][i] = sum[0][i - 1] + table[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++)
                sum[i][j] = table[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            if(x1 == 0 && y1 == 0)
                sb.append(sum[x2][y2]).append("\n");
            else if(x1 == 0)
                sb.append(sum[x2][y2] - sum[x2][y1 - 1]).append("\n");
            else if(y1 == 0)
                sb.append(sum[x2][y2] - sum[x1 - 1][y2]).append("\n");
            else
                sb.append(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]).append("\n");
        }

        System.out.print(sb);
    }
}