import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int checkRow(int[][] map, int tmpX){
        if(map[tmpX][0] == 0 && map[tmpX][1] == 0 && map[tmpX][2] == 0 && map[tmpX][3] == 0 && map[tmpX][4] == 0)
            return 1;
        return 0;
    }

    public static int checkColumn(int[][] map, int tmpY){
        if(map[0][tmpY] == 0 && map[1][tmpY] == 0 && map[2][tmpY] == 0 && map[3][tmpY] == 0 && map[4][tmpY] == 0)
            return 1;
        return 0;
    }

    public static int checkDiagonal(int [][] map){
        if(map[0][0] == 0 && map[1][1] == 0 && map[2][2] == 0 && map[3][3] == 0 && map[4][4] == 0)
            return 1;
        return 0;
    }

    public static int checkDiagonal2(int [][] map){
        if(map[4][0] == 0 && map[3][1] == 0 && map[2][2] == 0 && map[1][3] == 0 && map[0][4] == 0)
            return 1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[5][5];
        int answer = 0;
        int bingo = 0;

        for(int i = 0; i < 5; i++){
            String[] tmpMap = br.readLine().split(" ");
            for(int j = 0; j < 5; j ++){
                map[i][j] = Integer.parseInt(tmpMap[j]);
            }
        }

        for(int i = 0; i < 5; i++){
            String[] tmpMap = br.readLine().split(" ");
            for(int j = 0; j < 5; j ++){
                int target = Integer.parseInt(tmpMap[j]);

                for(int p = 0; p < 5; p++){
                    for(int q = 0; q < 5; q++){
                        if(map[p][q] == target){
                            map[p][q] = 0;
                            answer ++;
                            bingo += checkRow(map, p) + checkColumn(map, q);
                            if( p == q ) bingo += checkDiagonal(map);
                            if( p + q == 4) bingo += checkDiagonal2(map);
                            if(bingo >= 3){
                                System.out.println(answer);
                                return;
                            }
                        }
                    }
                }
            }
        }

    }
}
