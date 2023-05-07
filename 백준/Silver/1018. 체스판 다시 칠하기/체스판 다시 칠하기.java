import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;

    public static int calColor(int startX, int startY, char color) {
        int count = 0;
        for (int i = startX; i < startX + 8; i++) {
            for (int j = startY; j < startY + 8; j++) {
                if ((i - startX) % 2 == 0 && (j - startY) % 2 == 0 && board[i][j] != color)
                    count++;
                if ((i - startX) % 2 == 0 && (j - startY) % 2 == 1 && board[i][j] == color)
                    count++;
                if ((i - startX) % 2 == 1 && (j - startY) % 2 == 0 && board[i][j] == color)
                    count++;
                if ((i - startX) % 2 == 1 && (j - startY) % 2 == 1 && board[i][j] != color)
                    count++;
            }
        }
        return Math.min(count, 64 - count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++)
                board[i][j] = input.charAt(j);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 7 >= N || j + 7 >= M)
                    continue;
                min = Math.min(min, calColor(i, j, board[i][j]));
            }
        }
        System.out.print(min);
    }
}
