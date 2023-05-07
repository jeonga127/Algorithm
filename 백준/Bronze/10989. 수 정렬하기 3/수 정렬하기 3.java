import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];

        for (int i = 0; i < N; i++)
            answer[i] = Integer.parseInt(br.readLine());
        Arrays.sort(answer);
        
        for (int i = 0; i < N; i++)
            sb.append(answer[i]).append("\n");
        System.out.print(sb);
    }
}