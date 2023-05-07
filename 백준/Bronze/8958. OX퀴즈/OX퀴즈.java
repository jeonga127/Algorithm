import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testNum; i++) {
            String input = br.readLine();
            int answer = 0;
            int continuous = 0;

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'O') {
                    answer += (1 + continuous);
                    continuous += 1;
                } else continuous = 0;
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}