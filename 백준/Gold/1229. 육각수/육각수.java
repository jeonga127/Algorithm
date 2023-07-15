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
        for (int i = 1; i < N + 1; i++)
            dp[i] = i < 6 ? i : Integer.MAX_VALUE;

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

        for(int hexNum : hexNumList){
            for(int i = hexNum; i < N + 1; i++)
                dp[i] = Math.min(dp[i], dp[i - hexNum] + 1);
        }

        System.out.print(dp[N]);
    }

}