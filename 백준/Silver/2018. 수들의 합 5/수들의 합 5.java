import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int sum = 1;
        int answer = 0;

        while (start <= end) {
            if (sum < N)
                sum += ++end;

            if (sum == N)
                answer += 1;

            if (sum >= N)
                sum -= start++;
        }

        System.out.print(answer);
    }
}