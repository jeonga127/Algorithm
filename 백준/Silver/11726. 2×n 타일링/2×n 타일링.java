import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 직사각형의 크기는 2 * n
        int[] dp = new int[n + 1];

        if (n < 3) {
            System.out.print(n);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        System.out.print(dp[n]);
    }
}