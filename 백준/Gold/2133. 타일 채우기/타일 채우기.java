import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static int DP(int num) {
        if (dp[num] != 0) return dp[num];
        if (num == 0) return 1;
        if (num == 2) return 3;
        if (num % 2 == 1) return 0;

        int result = 3 * DP(num - 2);
        for (int i = 4; i < num + 1; i++) {
            if (i % 2 == 0) {
                result += 2 * DP(num - i);
            }
        }
        return dp[num] = result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        System.out.print(DP(N));
    }
}