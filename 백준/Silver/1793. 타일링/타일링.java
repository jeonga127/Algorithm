import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String tmp;

        while ((tmp = br.readLine()) != null && !tmp.isEmpty()) {
            int n = Integer.parseInt(tmp); // 직사각형 크기는 2*n
            BigInteger[] dp = new BigInteger[n + 1];

            if (n < 2) {
                sb.append(1).append("\n");
                continue;
            }

            dp[1] = BigInteger.valueOf(1);
            dp[2] = BigInteger.valueOf(3);

            for (int i = 3; i < n + 1; i++)
                dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));

            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}