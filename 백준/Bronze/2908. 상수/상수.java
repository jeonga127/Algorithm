import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder stringA = new StringBuilder(st.nextToken());
        StringBuilder stringB = new StringBuilder(st.nextToken());

        int A = Integer.parseInt(stringA.reverse().toString());
        int B = Integer.parseInt(stringB.reverse().toString());

        System.out.print(A > B ? A : B);
    }
}