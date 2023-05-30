import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (--T >= 0) {
            int N = Integer.parseInt(br.readLine());

            String begin = br.readLine();
            String end = br.readLine();

            int countW = 0;
            int countB = 0;

            for (int i = 0; i < N; i++) {
                if (begin.charAt(i) != end.charAt(i) && begin.charAt(i) == 'W')
                    countW++;
                if (begin.charAt(i) != end.charAt(i) && begin.charAt(i) == 'B')
                    countB++;
            }
            sb.append(Math.max(countW, countB)).append("\n");
        }

        System.out.print(sb);
    }
}