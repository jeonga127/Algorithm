import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairNum = Integer.parseInt(br.readLine());
        int[] stairs = new int[stairNum + 1];
        int[] scores = new int[stairNum + 1];

        for (int i = 1; i < stairNum + 1; i++)
            stairs[i] = Integer.parseInt(br.readLine());

        // i번째 계단의 선택지는 : 1. 다음 계단을 밟기 or 2. 다다음 계단을 밟기
        // 연속된 3개의 계단을 밟을 수 없으므로, 각각의 계단들은 ?OXO 또는 OXOO의 패턴을 가짐
        scores[0] = 0;
        scores[1] = stairs[1];
        if (stairNum > 1) scores[2] = stairs[1] + stairs[2];

        for (int i = 3; i < stairNum + 1; i++) {
            scores[i] = Math.max(scores[i - 2], scores[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.print(scores[stairNum]);
    }
}