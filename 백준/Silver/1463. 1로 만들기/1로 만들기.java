import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int minCount = Integer.MAX_VALUE;

    public static void makeOne(int x, int count) {
        if (x == 1 || count > minCount) {
            minCount = Math.min(minCount, count);
            return;
        }
        if (x % 3 == 0)
            makeOne(x / 3, count + 1);
        if (x % 2 == 0)
            makeOne(x / 2, count + 1);

        makeOne(x - 1, count + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        makeOne(X, 0);
        System.out.print(minCount);
    }
}