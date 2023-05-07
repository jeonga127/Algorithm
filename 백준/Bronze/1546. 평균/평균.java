import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            sum += target;
            max = Math.max(max, target);
        }
        System.out.print((double) sum / max * 100 / N);
    }
}