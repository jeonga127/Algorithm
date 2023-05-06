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
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(br.readLine());

        double answer = 0;
        double total = 0;
        for (int i = 0; i < N; i++) {
            if (GCD(Math.max(A[i], X), Math.min(A[i], X)) == 1) {
                answer += A[i];
                total++;
            }
        }
        System.out.print(answer / total);
    }
}