import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[][] itemInfo = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            itemInfo[i][0] = Integer.parseInt(st.nextToken()); // 물건의 무게 W
            itemInfo[i][1] = Integer.parseInt(st.nextToken()); // 물건의 가치 V
        }

        int[][] weight = new int[N + 1][K + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                weight[i][j] = weight[i-1][j];
                
                if(j - itemInfo[i][0] >= 0)
                    weight[i][j] = Math.max(weight[i][j], weight[i - 1][j - itemInfo[i][0]] + itemInfo[i][1]);
            }
        }

        System.out.print(weight[N][K]);
    }
}