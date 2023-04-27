import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static boolean[] start;
    static int minDiff = Integer.MAX_VALUE;
    static int N;

    // 한 선수에 대해 2가지 선택지가 있음 :
    // 1. 스타트팀에 넣거나 (start[i][j] = true)
    // 2. 링크 팀에 넣거나 (start[i][j] = false)

    public static void dfs(int teamNum, int num, int target) {
        if(num == teamNum){
            minDiff = Math.min(minDiff, scoreDiff());
            return;
        }
        for(int i = target; i < N; i++){
            if(!start[i]){
                start[i] = true;
                dfs(teamNum, num+1, i+1);
                start[i] = false;
            }
        }
    }

    public static int scoreDiff(){
        int startScore = 0, linkScore = 0;

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if(start[i] && start[j]) // i와 j 모두 start 팀에 속할 경우
                    startScore += map[i][j] + map[j][i];
                else if(!start[i] && !start[j]) // i와 j 모두 link 팀에 속할 경우
                    linkScore += map[i][j] + map[j][i];
            }
        }
        return Math.abs(startScore - linkScore);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        start = new boolean[N];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(tmp[j]);
        }

        // 한 팀의 인원 수는 1 ~ N-1 임
        for(int i = 1; i < N; i++) {
            dfs(i, 0, 0);
            if(minDiff == 0) break;
        }
        System.out.println(minDiff);
    }
}
