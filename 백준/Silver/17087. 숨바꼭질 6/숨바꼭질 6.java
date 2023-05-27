import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동생
        int S = Integer.parseInt(st.nextToken()); // 수빈이 위치
        int[] interval = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            interval[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);

        int D = N == 1 ? gcd(interval[0], interval[0]) : gcd(interval[0], interval[1]);
        for (int i = 2; i < N; i++)
            D = gcd(interval[i], D);
        
        System.out.print(D);
    }
}