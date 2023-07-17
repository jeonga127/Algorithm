import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 늘려야 하는 고객의 수
        int N = Integer.parseInt(st.nextToken()); // 도시의 수

        int[] memo = new int[C + 101];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken()); // 홍보 비용
            int effect = Integer.parseInt(st.nextToken()); // 늘릴 수 있는 고객의 수

            for (int j = effect; j < C + 101; j++) {
                if (memo[j - effect] != Integer.MAX_VALUE)
                    memo[j] = Math.min(memo[j], memo[j - effect] + cost);
            }
        }

        System.out.print(IntStream.range(C, C + 101).map(idx -> memo[idx]).min().getAsInt());
    }
}