import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];

        for (int i = 0; i < N; i++)
            scores[i] = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 1; i - j >= 0; j++) {
                if (scores[i - j] >= scores[i]) {
                    count += scores[i-j] - scores[i] + 1;
                    scores[i - j] = scores[i] - 1;
                }
            }
        }

        System.out.print(count);
    }
}