import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());
        int answerX = 0;
        int answerY = 0;

        for (int i = (int) Math.sqrt((double) lcm / gcd); i >= 1; i--) {
            if ((lcm / gcd) % i == 0 && GCD(i * gcd, lcm / i) == gcd) {
                answerX = i * gcd;
                answerY = lcm / i;
                break;
            }
        }
        System.out.print(answerX + " " + answerY);
    }
}
