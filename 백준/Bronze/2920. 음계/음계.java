import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String answer = "";
        int before = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 8; i++) {
            int after = Integer.parseInt(st.nextToken());
            if (after - before > 0)
                answer = answer.equals("descending") || answer.equals("mixed") ? "mixed" : "ascending";
            else answer = answer.equals("ascending") || answer.equals("mixed") ? "mixed" : "descending";
            before = after;
        }
        System.out.print(answer);
    }
}