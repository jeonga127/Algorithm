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
            int H = Integer.parseInt(st.nextToken()); // 층 수
            int W = Integer.parseInt(st.nextToken()); // 방 수
            int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님

            int floor = N % H == 0 ? H : N % H; // 손님이 쓰게 되는 층수
            int room = N % H == 0 ? N / H : N / H + 1; // 손님이 쓰게 되는 호수

            sb.append(room < 10 ? floor + "0" + room + "\n" : floor + "" + room + "\n");
        }
        System.out.print(sb);
    }
}