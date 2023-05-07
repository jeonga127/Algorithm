import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if (N == 1) {
            System.out.print(1);
            return;
        }

        long before = 1;
        int idx = 1;

        while (true) {
            long standard = before + 6 * idx;
            if (N <= standard) {
                System.out.print(idx + 1);
                break;
            } else {
                before = standard;
                idx++;
            }
        }
    }
}