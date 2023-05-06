import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static boolean isDecimal(int num) {
        if (num <= 3)
            return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static long GCD(long a, long b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }

    public static Long LCM(long a, long b) {
        return (a * b) / GCD(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> decimals = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isDecimal(num))
                decimals.add(num);
        }

        if(decimals.isEmpty()){
            System.out.print("-1");
            return;
        }

        long answer = 1;
        for (int i = 0; i < decimals.size(); i++)
            answer = LCM(answer, decimals.get(i));
        System.out.print(answer);
    }
}