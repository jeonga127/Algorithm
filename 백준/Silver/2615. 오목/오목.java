import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String[][] map = new String[19][19];
    static boolean[][] visit = new boolean[19][19];

    /* (x,y) = 탐색 좌표 / target = 검은돌이면 1, 흰돌이면 2 */
    public static int checkResult(int x, int y, String target, String direction) {
        int checkNum = 0;
        if (x < 0 || y < 0 || x > 18 || y > 18)
            return 0;
        if (!visit[x][y] && map[x][y].equals(target)) {
            checkNum++;
            visit[x][y] = true;
            switch (direction) {
                case "row":
                    checkNum += checkResult(x - 1, y, target, direction);
                    checkNum += checkResult(x + 1, y, target, direction);
                    break;
                case "column":
                    checkNum += checkResult(x, y - 1, target, direction);
                    checkNum += checkResult(x, y + 1, target, direction);
                    break;
                case "diagonal":
                    checkNum += checkResult(x - 1, y - 1, target, direction);
                    checkNum += checkResult(x + 1, y + 1, target, direction);
                    break;
                case "revdiagonal":
                    checkNum += checkResult(x + 1, y - 1, target, direction);
                    checkNum += checkResult(x - 1, y + 1, target, direction);
                    break;
            }
        } else return 0;
        return checkNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] command = {"row", "column", "diagonal", "revdiagonal"};

        // 1. 보드판 정보 받아오기
        for (int i = 0; i < 19; i++)
            map[i] = bf.readLine().split(" ");

        // 2. 흰돌 / 검은돌 오목 정보 확인
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (!map[i][j].equals("0")) {
                    for (int k = 0; k < 4; k++) {
                        if (checkResult(i, j, String.valueOf(map[i][j]), command[k]) == 5) {
                            System.out.println(map[i][j]);
                            if (k == 3) System.out.println((i + 5) + " " + (j - 3));
                            else System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                        for (int p = 0; p < 19; p++)
                            Arrays.fill(visit[p], false);
                    }
                }
            }
        }
        System.out.println(0);
    }
}
