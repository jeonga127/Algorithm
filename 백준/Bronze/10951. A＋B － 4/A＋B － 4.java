import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String tmp;

        while ((tmp = br.readLine()) != null && !tmp.isEmpty()) {
            StringTokenizer st = new StringTokenizer(tmp);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(A + B).append("\n");
        }
        System.out.print(sb);
    }
}