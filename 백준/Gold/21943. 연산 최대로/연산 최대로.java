import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int maxValue = Integer.MIN_VALUE;
    static int[] pNumber;
    static int[] area;
    static int P, Q;

    public static void allPossibleCase(int count) {
        if (count == pNumber.length) {
            int result = 1;
            for (int a : area)
                result *= a;
            maxValue = Math.max(result, maxValue);
            return;
        }

        for (int j = 0; j < area.length; j++) {
            int tmp = area[j];
            area[j] += pNumber[count];
            allPossibleCase(count + 1);
            area[j] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        pNumber = new int[N];
        String[] pInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            pNumber[i] = Integer.parseInt(pInput[i]);

        String[] operatorInput = br.readLine().split(" ");
        P = Integer.parseInt(operatorInput[0]); // 더하기 연산자 개수
        Q = Integer.parseInt(operatorInput[1]); // 곱하기 연산자 개수
        area = new int[Q + 1];

        allPossibleCase(0);

        System.out.println(maxValue);
    }
}
