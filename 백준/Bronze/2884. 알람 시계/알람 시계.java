import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        H = M >= 45 ? H : H - 1;
        H = H < 0 ? 23 : H;
        M = M >= 45 ? M - 45 : 15 + M;
        System.out.print(H + " " + M);
    }
}