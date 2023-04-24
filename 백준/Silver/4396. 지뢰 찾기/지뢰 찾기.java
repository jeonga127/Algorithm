import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int N = Integer.parseInt(num);

        String[][] map1 = new String[N][N]; // 지뢰 정보 맵
        String[][] map2 = new String[N][N]; // 사용자 입력 맵
        String[][] answer = new String[N][N];
        List<Point> savePoint = new ArrayList<Point>();

        int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = { 1, 0, -1, 1, -1, 1, 0, -1};

        // map1 (지뢰 정보 맵) 받아오면서 answer 배열까지 "."로 초기화
        for(int i = 0; i < N; i++){
            Arrays.fill(answer[i],".");
            map1[i] = br.readLine().split("");
            for(int j = 0; j < map1[i].length; j++){
                if(map1[i][j].equals("*"))
                    savePoint.add(new Point(i,j)); // m개인 list
            }
        }

        // map2 (사용자 입력 맵) 받아오기
        for(int i = 0; i < N; i++)
            map2[i] = br.readLine().split("");

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 1. 지뢰를 찾은 경우
                if(map2[i][j].equals("x") && map1[i][j].equals("*") && answer[i][j].equals(".")){
                    for(Point p : savePoint)
                        answer[p.x][p.y] = "*";
                }
                // 2. 근처 지뢰 탐색
                else if(map2[i][j].equals("x") && map1[i][j].equals(".")){
                    int mineNum = 0;

                    for(int p = 0; p < 8; p++){
                        int tmpX = i + dx[p];
                        int tmpY = j + dy[p];

                        if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N)
                            continue;

                        if(map1[tmpX][tmpY].equals("*"))
                            mineNum++;
                    }

                    answer[i][j] = Integer.toString(mineNum);
                }
            }
        }

        // 결과 출력
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]);
            } sb.append("\n");
        }
        System.out.println(sb);
    }
}
