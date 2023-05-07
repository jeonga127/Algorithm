import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken()); // 반복 횟수
            String[] S = st.nextToken().split("");
            String answer = "";

            for(int j = 0; j < S.length; j++)
                answer += S[j].repeat(R);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}