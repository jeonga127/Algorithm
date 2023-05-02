import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Dynamic Programming 문제를 Brute Force 방식으로 풀이함 (시간 초과 )
public class DP9465_2 {
    static int[][] sticker;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxScore = Integer.MIN_VALUE;
    static int N;

    public static void calSticker(int count, int score) {
        if(count == 2*N){
            maxScore = Math.max(maxScore, score);
            return;
        }

        for(int i = 0; i < 2; i ++){
            for(int j = 0; j < N; j++){

                if(!visit[i][j]){ // 아직 방문하지 않았다면 방문
                    int tmp = count;

                    for(int p = 0; p < 4; p++){
                        int tmpX = i + dx[p];
                        int tmpY = j + dy[p];

                        if(tmpX < 0 || tmpY < 0 || tmpX >= 2 || tmpY >= N)
                            continue;

                        if(visit[tmpX][tmpY])
                            continue;

                        visit[tmpX][tmpY] = true;
                        tmp ++;
                    }

                    visit[i][j] = true;
                    calSticker(tmp+1 , score + sticker[i][j]);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine()); // 스티커의 row 정보
            sticker = new int[2][N];
            visit = new boolean[2][N];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++)
                    sticker[j][k] = Integer.parseInt(st.nextToken());
            }

            for(int p = 0; p < 2; p ++){
                for(int q = 0; q < N; q++){

                    int tmp = 0;
                    visit[p][q] = true;

                    for(int k = 0; k < 4; k++){
                        int tmpX = p + dx[k];
                        int tmpY = q + dy[k];

                        if(tmpX < 0 || tmpY < 0 || tmpX >= 2 || tmpY >= N)
                            continue;

                        visit[tmpX][tmpY] = true;
                        tmp ++;
                    }

                    calSticker(tmp+1 , sticker[p][q]);

                    for(int k = 0; k < 2; k++)
                        Arrays.fill(visit[k], false);
                }
            }

            calSticker(0,0);
            sb.append(maxScore).append("\n");
            maxScore = Integer.MIN_VALUE;
        }
        System.out.print(sb);
    }
}
