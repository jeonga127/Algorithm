import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> hexNumList = new ArrayList<>();
    static int[] dp;

    public static void getHexNumber(int N) {
        int idx = 1;
        int nearHexNum;

        while (true) {
            nearHexNum = idx * (2 * idx - 1);

            if (nearHexNum > N) return;
            else {
                hexNumList.add(nearHexNum);
                dp[nearHexNum] = 1;
            }
            idx += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        for (int i = 1; i < Math.min(N + 1, 6); i++)
            dp[i] = i;

        if (N < 6) {
            System.out.print(dp[N]);
            return;
        }

        getHexNumber(N);

        for(int i = 6; i < N + 1; i++){
            int min = Integer.MAX_VALUE;

            for(int hexNum : hexNumList){
                if(hexNum > i)
                    break;
                min = Math.min(min, dp[i - hexNum]);
            }

            dp[i] = min + 1;
        }

        System.out.print(dp[N]);
    }
}