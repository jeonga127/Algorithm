import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ball = Integer.parseInt(st.nextToken());
        int basket = Integer.parseInt(st.nextToken());
        int[] arr = new int[basket];

        if ((basket >= ball)) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < basket; i++) {
            arr[i] = i + 1;
            ball -= arr[i];

            if (ball < 0) {
                System.out.println(-1);
                return;
            }
        }

        while (ball >= basket) {
            ball -= basket;
            for (int i = 0; i < basket; i++) {
                arr[i]++;
            }
        }

        if (ball != 0) arr[basket - ball] += ball;
        Arrays.sort(arr);
        System.out.print(arr[basket - 1] - arr[0]);
    }
}