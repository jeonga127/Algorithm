import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int countPPL(int floor, int room) {
        if (floor == 0) return room;
        if (room == 0) return 0;
        return countPPL(floor - 1, room) + countPPL(floor, room - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(countPPL(k, n) + "\n");
        }
        System.out.print(sb);
    }
}