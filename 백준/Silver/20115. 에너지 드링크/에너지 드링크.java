import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 에너지 드링크의 수
        double[] drinks = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            drinks[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(drinks);
        double answer = drinks[N - 1];

        for (int i = N - 2; i >= 0; i--)
            answer += drinks[i] / 2;

        System.out.print(answer);
    }
}