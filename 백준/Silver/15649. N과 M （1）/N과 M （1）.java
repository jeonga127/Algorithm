import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int N, M;

    public static void dfs(int depth, int[] arr) {
        if (depth == M) {
            Arrays.stream(arr).forEach(x->sb.append(x).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                dfs(depth + 1, arr);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            int[] arr = new int[M];
            arr[0] = i;
            visited[i] = true;
            dfs(1, arr);
            visited[i] = false;
        }

        System.out.print(sb);
    }
}