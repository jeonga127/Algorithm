import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> hexNumList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        for (int i = 1; i < Math.min(N + 1, 6); i++)
            dp[i] = i;

        int idx = 1;
        int nearHexNum;

        while (true) {
            nearHexNum = idx * (2 * idx - 1);

            if (nearHexNum > N) break;
            else {
                hexNumList.add(nearHexNum);
                dp[nearHexNum] = 1;
            }
            idx += 1;
        }

        for (int i = 6; i < N + 1; i++) {
            if (dp[i] > 0)
                continue;

            int min = Integer.MAX_VALUE;

            for (int hexNum : hexNumList) {
                if (hexNum > i || min == 1)
                    break;
                min = Math.min(min, dp[i - hexNum]);
            }

            dp[i] = min + 1;
        }

        System.out.print(dp[N]);
    }

}