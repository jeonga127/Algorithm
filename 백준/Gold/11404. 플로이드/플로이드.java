import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        int[][] dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용

            dp[a - 1][b - 1] = Math.min(dp[a - 1][b - 1], c);
        }

        for (int k = 0; k < n; k++) { // 0~n-1번 도시에 대해 모두 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) dp[i][j] = 0;
                    else if (dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        Arrays.stream(dp)
                .map(row -> Arrays.stream(row)
                        .map(x -> x == Integer.MAX_VALUE ? 0 : x)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);
    }
}