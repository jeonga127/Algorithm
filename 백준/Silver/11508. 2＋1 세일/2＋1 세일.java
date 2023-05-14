import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] price = new int[N];

        for (int i = 0; i < N; i++)
            price[i] = Integer.parseInt(br.readLine());
        Arrays.sort(price);

        int idx = 1;
        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (idx % 3 != 0)
                answer += price[i];
            idx++;
        }
        System.out.print(answer);
    }
}