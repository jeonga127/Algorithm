import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int row = 4 * N - 3;
        Character[][] answer = new Character[row][row];

        for (int i = 0; i < N; i++) { // print 시작 인덱스
            for (int j = 2 * i; j < row - 2 * i; j++) {
                Arrays.fill(answer[j], 2 * i, row - 2 * i, '*');
                if (j != 2 * i && j != row - 2 * i - 1)
                    Arrays.fill(answer[j], 2 * i + 1, row - 2 * i - 1, ' ');
            }
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++)
                System.out.print(answer[i][j]);
            System.out.print("\n");
        }
    }
}
