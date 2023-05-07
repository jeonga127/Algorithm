import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int idx = Integer.MIN_VALUE;

        for (int i = 0; i < 9; i++) {
            int target = Integer.parseInt(br.readLine());
            if (max < target) {
                max = target;
                idx = i + 1;
            }
        }

        System.out.print(max + "\n" + idx);
    }
}