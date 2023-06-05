import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로 길이
        int M = Integer.parseInt(st.nextToken()); // 가로 길이
        int B = Integer.parseInt(st.nextToken()); // 블록 갯수
        int[][] map = new int[N][M];

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        long minTime = Long.MAX_VALUE;
        int finalHeight = -1;

        for (int expectedHeight = minHeight; expectedHeight <= maxHeight; expectedHeight++) {
            long time = 0;
            int needBlock = 0;
            int addBlock = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] - expectedHeight > 0) { // 블럭 제거 필요(2초 소요)
                        time += 2 * (map[i][j] - expectedHeight);
                        addBlock += (map[i][j] - expectedHeight);
                    } else if (map[i][j] - expectedHeight < 0) { // 블럭 쌓기 필요(1초 소요)
                        time += expectedHeight - map[i][j];
                        needBlock += expectedHeight - map[i][j];
                    }
                }
            }

            if(needBlock > B + addBlock)
                continue;

            minTime = Math.min(minTime, time);
            finalHeight = minTime == time ? expectedHeight : finalHeight;
        }

        System.out.print(minTime + " "+finalHeight);
    }
}