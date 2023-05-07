import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        String[] input = br.readLine().split("");
        for(int i = 0; i < N; i++)
            answer += Integer.parseInt(input[i]);
        System.out.print(answer);
    }
}