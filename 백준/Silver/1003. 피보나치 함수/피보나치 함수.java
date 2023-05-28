import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            int target = Integer.parseInt(br.readLine());

            if (target == 1 || target == 0) {
                sb.append(target == 1 ? "0 1\n" : "1 0\n");
                continue;
            }

            int[] countZero = new int[target + 1];
            int[] countOne = new int[target + 1];

            countOne[1] = 1;
            countOne[2] = 1;
            countZero[2] = 1;

            for (int j = 3; j < target + 1; j++) {
                countZero[j] = countZero[j - 1] + countZero[j - 2];
                countOne[j] = countOne[j - 1] + countOne[j - 2];
            }
            sb.append(countZero[target] + " " + countOne[target] + "\n");
        }
        System.out.print(sb);
    }
}