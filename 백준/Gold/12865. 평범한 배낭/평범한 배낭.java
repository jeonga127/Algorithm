import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int M = Integer.parseInt(st.nextToken()); // 최대 무게

        int[] memo = new int[M + 1];
        for (int item = 1; item < N + 1; item++) {
            st = new StringTokenizer(br.readLine());

            int itemWeight = Integer.parseInt(st.nextToken());
            int satisfaction = Integer.parseInt(st.nextToken());

            for (int weight = M; weight >= itemWeight; weight--)
                memo[weight] = Math.max(memo[weight], memo[weight - itemWeight] + satisfaction);
        }

        System.out.print(memo[M]);
    }
}