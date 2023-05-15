import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] computer;
    static boolean[] visit;
    static int answer = 0;

    public static void dfs(int from, int to) {
        for (int i = 1; i < computer.length; i++) {
            if (!visit[i] && computer[to][i] == 1) {
                visit[i] = true;
                answer++;
                dfs(to, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerNum = Integer.parseInt(br.readLine());
        int inputNum = Integer.parseInt(br.readLine());
        computer = new int[computerNum][computerNum];
        visit = new boolean[computerNum];

        for (int i = 0; i < inputNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            computer[a][b] = 1;
            computer[b][a] = 1;
        }

        for (int i = 0; i < computerNum; i++) {
            if (computer[0][i] == 1 && !visit[i]) {
                visit[i] = true;
                answer++;
                dfs(0, i);
            }
        }

        System.out.print(answer);
    }
}