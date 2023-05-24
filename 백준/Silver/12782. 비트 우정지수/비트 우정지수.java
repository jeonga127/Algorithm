import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String N = st.nextToken();
            String M = st.nextToken();

            int countOne = 0;
            int countZero = 0;

            for (int j = 0; j < N.length(); j++) {
                if (N.charAt(j) != M.charAt(j)) {
                    if (N.charAt(j) == '1') countOne++;
                    else countZero++;
                }
            }
            sb.append(Math.max(countOne, countZero)).append("\n");
        }

        System.out.print(sb);
    }
}