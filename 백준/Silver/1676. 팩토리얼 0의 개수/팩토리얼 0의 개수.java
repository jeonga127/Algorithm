import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = 0;
        int m = 0;
        for (int i = 2; i <= N; i++) {
            n += cal(i, 2);
            m += cal(i, 5);
        }
        System.out.print(Math.min(n, m));
    }

    private static int cal(int i, int num) {
        int tmp = i;
        int count = 0;
        while (tmp % num == 0) {
            tmp /= num;
            count++;
        }
        return count;
    }
}