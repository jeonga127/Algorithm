import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            answer += isDecimal(Integer.parseInt(st.nextToken()));

        System.out.print(answer);
    }

    public static int isDecimal(int num) {
        if (num == 1) return 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return 0;
        }
        return 1;
    }
}