import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = N / 5;

        switch (N % 5) {
            case 1:
                count += 1;
                break;
            case 2:
                count += 2;
                break;
            case 3:
                count += 1;
                break;
            case 4:
                count += 2;
                break;
        }

        System.out.print(N == 4 || N == 7 ? -1 : count);
    }
}